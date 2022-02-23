package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class AActivity extends AppCompatActivity implements View.OnClickListener{
    private Button goToB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        goToB = findViewById(R.id.goToB);
        goToB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goToB:
                Intent intent = new Intent(AActivity.this, BActivity.class);
                startActivity(intent);
                break;
        }
    }
}