package com.baw.zhaozhipeng.app;

import android.app.Application;
import android.content.Context;

import com.baw.zhaozhipeng.ExceptionCapture;

/**
 * Copyright (C)
 * <p>
 * FileName: MyApp
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 8:49
 */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ExceptionCapture.getInstance().init(this);
    }
}
