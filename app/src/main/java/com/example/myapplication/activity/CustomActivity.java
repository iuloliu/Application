package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.customRecycleView.MyAdapter;

public class CustomActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        recyclerView = findViewById(R.id.myRecycleView);
        recyclerView.setAdapter(new MyAdapter(CustomActivity.this));
        recyclerView.setLayoutManager(new LinearLayoutManager(CustomActivity.this));
    }
}