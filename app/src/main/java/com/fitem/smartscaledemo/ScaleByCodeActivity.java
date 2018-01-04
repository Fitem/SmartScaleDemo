package com.fitem.smartscaledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;

public class ScaleByCodeActivity extends AppCompatActivity {

    public static final float TAB_SWIDTH = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_by_code);
        TextView mediaView = findViewById(R.id.tv_media_type);
        float widthDpi = SizeUtils.px2dp(ScreenUtils.getScreenWidth());
        if(widthDpi < TAB_SWIDTH) {
            mediaView.setText(R.string.phone);
        } else {
            mediaView.setText(R.string.tab);
        }
    }
}
