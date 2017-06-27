package com.dba;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.jkdroid.core.util.SLog;
import com.jkdroid.core.util.SpUtils;

/**
 *
 * Created by guanzhihao on 2016/2/17.
 */
public class MyApplication extends Application implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        SLog.e("uncaughtException:" + ex.getMessage());
        //noinspection StatementWithEmptyBody
        if(SLog.isDebuggable()){
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        com.jkdroid.core.util.SLog.setSIGN("mession");
        sContext = getApplicationContext();
        SpUtils.init(this);
        if(SLog.isDebuggable()){
            return;
        }

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @SuppressLint("StaticFieldLeak")
    public static Context sContext;

}

