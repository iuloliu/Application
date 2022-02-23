package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.activity.AActivity;
import com.example.myapplication.activity.aidlActivity;
import com.example.myapplication.activity.contentResolverActivity;
import com.example.myapplication.broadCastReceive.myBroadCast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button exchange, goToA, aidl,contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (exchange != null) {
            Log.d("testA", "" + exchange.getId());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exchange = findViewById(R.id.exchange);
        exchange.setOnClickListener(this);
        Log.d("testA", "onCreate");
        goToA = findViewById(R.id.goToA);
        goToA.setOnClickListener(this);
        aidl = findViewById(R.id.aidl);
        aidl.setOnClickListener(this);
        contentResolver = findViewById(R.id.contentResolver);
        contentResolver.setOnClickListener(this);

        //注册本地广播相关代码
        myBroadCast broadCast = new myBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("msg");
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(broadCast, intentFilter);

        //发送本地广播
        Intent intent = new Intent("msg");
        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);

        //静态注册广播时一般为不显示，设置.setComponet后可以显式显示广播内容
        Intent msg = new Intent("msg");
        msg.setComponent(new ComponentName(MainActivity.this, myBroadCast.class));

        //动态注册广播并使用
        registerReceiver(broadCast, intentFilter);
        //动态发送全局广播
        sendBroadcast(msg);
        //发送粘性广播
        getApplicationContext().sendStickyBroadcast(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("testA", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("testA", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("testA", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("testA", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("testA", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("testA", "onRestart");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("testA", "onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("testA", "onConfigurationChanged");
    }


    public void getScreenMessage() {
        Configuration cfg = getResources().getConfiguration();
        if (cfg.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.exchange:
                getScreenMessage();
                break;
            case R.id.goToA:
                Intent intent = new Intent(MainActivity.this, AActivity.class);
                startActivity(intent);
                break;
            case R.id.aidl:
                Intent intent1 = new Intent(MainActivity.this, aidlActivity.class);
                startActivity(intent1);
                break;
            case R.id.contentResolver:
                Intent intent2 = new Intent(MainActivity.this, contentResolverActivity.class);
                startActivity(intent2);
                break;
        }
    }
}