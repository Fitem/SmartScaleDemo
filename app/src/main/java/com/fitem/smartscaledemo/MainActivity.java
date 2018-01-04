package com.fitem.smartscaledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toScaleByCode(View view) {
        Intent intent = new Intent(this, ScaleByCodeActivity.class);
        startActivity(intent);
    }

    public void toDifferentLayout(View view) {
        Intent intent = new Intent(this, ScaleByLayoutActivity.class);
        startActivity(intent);
    }
}
