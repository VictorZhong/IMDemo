package com.victor.imdemo.imdemo.app;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/7.
 */
public class IMApplication extends Application {

    public static IMApplication instance;
    private String TAG = IMApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(TAG, "onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory");
    }
}
