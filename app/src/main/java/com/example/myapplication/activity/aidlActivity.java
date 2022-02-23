package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.service.aidlService;

public class aidlActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {


    private Button startService,stopService,bindService,UnBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        stopService = findViewById(R.id.startService);
        startService = findViewById(R.id.closeService);
        bindService = findViewById(R.id.bindService);
        UnBindService = findViewById(R.id.UnBindService);
        stopService.setOnClickListener(this);
        startService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        UnBindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(aidlActivity.this,aidlService.class);
        switch (view.getId()){
            case R.id.startService:
                startService(intent);
                break;
            case R.id.closeService:
                stopService(intent);
                break;
            case R.id.bindService:
                bindService(intent,this,BIND_AUTO_CREATE);
                break;
            case R.id.UnBindService:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("ServiceConnect","onServiceConnected");
        Log.d("ServiceConnect",""+iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("ServiceConnect","onServiceDisconnected");
    }
}