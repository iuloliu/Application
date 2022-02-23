package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class aidlService extends Service {
    public aidlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  null;
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