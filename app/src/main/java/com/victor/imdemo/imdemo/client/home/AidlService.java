package com.victor.imdemo.imdemo.client.home;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.victor.imdemo.imdemo.client.forActivity;
import com.victor.imdemo.imdemo.client.forService;

/**
 * Created by Administrator on 2015/9/8.
 */
public class AidlService extends Service {

    private static final String TAG = "AidlService";
    private forActivity activityCallback;

    private void Log(String str) {
        Log.i(TAG, "------" + str + "------");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log("onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log("onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log("onDestroy");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log("onRebind");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log("IBinder");
        return binder;
    }

    private final forService.Stub binder = new forService.Stub() {
        @Override
        public void registerTestCall(forActivity activity) throws RemoteException {
            activityCallback = activity;
        }

        @Override
        public void invokCallback() throws RemoteException {
            activityCallback.performAction();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };
}
