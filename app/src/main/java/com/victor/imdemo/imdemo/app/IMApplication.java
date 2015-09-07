package com.victor.imdemo.imdemo.app;

import android.app.Application;
import android.os.Process;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/7.
 */
public class IMApplication extends Application {

    public static IMApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        int pid = Process.myPid();
        Log.i("onCreate", pid + "");

    }
}
