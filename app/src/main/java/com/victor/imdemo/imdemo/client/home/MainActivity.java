package com.victor.imdemo.imdemo.client.home;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import com.victor.imdemo.imdemo.R;
import com.victor.imdemo.imdemo.client.forActivity;
import com.victor.imdemo.imdemo.client.forService;

public class MainActivity extends Activity implements View.OnClickListener {

    private forService mService;
    private forActivity activityCallback = new forActivity.Stub() {

        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }

        @Override
        public void performAction() throws RemoteException {
            Toast.makeText(MainActivity.this, "called from service", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = forService.Stub.asInterface(service);
            try {
                mService.registerTestCall(activityCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_callback).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                Intent intent = new Intent(this, AidlService.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                startService(intent);
                break;

            case R.id.btn_cancel:
                if (connection != null) {
                    unbindService(connection);
                }
                break;

            case R.id.btn_callback:
                if (mService != null) {
                    try {
                        mService.invokCallback();
                    } catch (RemoteException e) {
                    }
                }

                break;

        }
    }
}
