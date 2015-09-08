package com.victor.imdemo.imdemo.client.home;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by Administrator on 2015/9/8.
 */
public class CoreService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG","onBind");

        return null;
    }

    @Override
    public void onCreate() {
        Log.i("TAG","onCreate");

        super.onCreate();
    }

    @Override
    public void onDestroy() {

        Log.i("TAG","onDestroy");
        AlarmManager manager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Date date = new Date();
        Intent intent = new Intent(getApplicationContext(), CoreService.class);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 1, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        manager.set(AlarmManager.RTC_WAKEUP, (date.getTime() + 5000), pendingIntent);
        super.onDestroy();
    }
}
