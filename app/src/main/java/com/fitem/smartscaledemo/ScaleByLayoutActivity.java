package com.fitem.smartscaledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;

public class ScaleByLayoutActivity extends AppCompatActivity {

    public static final float TAB_SWIDTH = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_by_layout);
        TextView mediaView = findViewById(R.id.tv_media_type);
        // 获取当前设备的屏幕width(单位：dp)
        float widthDpi = SizeUtils.px2dp(ScreenUtils.getScreenWidth());
        // 判断设备屏幕宽度
        if(widthDpi < TAB_SWIDTH) {
            mediaView.setText(R.string.phone);
        } else {
            mediaView.setText(R.string.tab);
        }
    }
}
