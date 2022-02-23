package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.contentProvider.MyContentProvider;

public class contentResolverActivity extends AppCompatActivity implements View.OnClickListener {

    private Uri uri = MyContentProvider.CONTENT_URI;
    private Button add, get, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver);
        add = findViewById(R.id.addToContentResolver);
        add.setOnClickListener(this);
        get = findViewById(R.id.getFromContentResolver);
        get.setOnClickListener(this);
        delete = findViewById(R.id.deleteFromContentResolver);
        delete.setOnClickListener(this);
    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addToContentResolver:
                ContentValues values = new ContentValues();
                values.put("name", "c");
                values.put("sexId", "1c");
                values.put("address", "homec");
                getContentResolver().insert(uri, values);
                break;
            case R.id.getFromContentResolver:
                Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);
                Log.d("index", "" + cursor.getCount());
                String name;
                String sexId;
                String address;
                Log.d("asdasd", "" + cursor.getCount());
                int i = 0;
                while (cursor.moveToNext()) {
                    i++;
                    Log.d("asdasd", "执行了" + i + "次");
                    name = cursor.getString(cursor.getColumnIndex("name"));
                    sexId = cursor.getString(cursor.getColumnIndex("sexId"));
                    address = cursor.getString(cursor.getColumnIndex("address"));
                    Log.d("asdasd", name + "-------" + sexId + "-------" + address);
                }
                break;

            case R.id.deleteFromContentResolver:
                int cursor1 = getContentResolver().delete(uri,"name = 'c'",null);
                Log.d("asdasd", ""+cursor1);
                break;
        }
    }
}