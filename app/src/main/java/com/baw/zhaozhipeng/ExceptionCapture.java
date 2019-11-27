package com.baw.zhaozhipeng;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;

/**
 * Copyright (C)
 * <p>
 * FileName: Thraw
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/27 10:37 异常捕获
 */
public class ExceptionCapture implements Thread.UncaughtExceptionHandler {

    //静态单例
    public ExceptionCapture() {

    }

    private static class Thraws {
        private static ExceptionCapture thraw = new ExceptionCapture();
    }

    public static ExceptionCapture getInstance() {
        return Thraws.thraw;
    }

    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private Context mContext;

    public void init(Context context) {
        this.mContext = context;
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {

        if (!Hander(e) && uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }

    public boolean Hander(Throwable ex) {
        if (ex != null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.loop();
                Toast.makeText(mContext, "即将退出程序", Toast.LENGTH_SHORT).show();
                Looper.prepare();
            }
        }.start();
        return true;
    }
}
