package com.victor.imdemo.imdemo.client.home;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2015/9/7.
 */
public class IMService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IMBinder binder = new IMBinder();


        return binder;
    }


}
