package com.victor.imdemo.imdemo.app;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/7.
 */
public class IMDemoApplication extends Application {

    private String TAG = getApplicationInfo().toString();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
