package com.example.myapplication.broadCastReceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class My2BroadCastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "msg222", Toast.LENGTH_SHORT).show();
    }
}
