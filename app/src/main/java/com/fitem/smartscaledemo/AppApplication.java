package com.fitem.smartscaledemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by Fitem on 2018/1/4.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
