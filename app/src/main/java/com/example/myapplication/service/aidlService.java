package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.inspector.IntFlagMapping;

import com.example.myapplication.aidl.IAppServiceRemoteBinder;


public class aidlService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return  new IAppServiceRemoteBinder.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("testService","onCreate");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("testService","onDestroy");
    }
}