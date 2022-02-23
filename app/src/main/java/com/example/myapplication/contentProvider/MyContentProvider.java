package com.example.myapplication.contentProvider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.myapplication.database.DbHelper;

public class MyContentProvider extends ContentProvider {

    private DbHelper helper;
    private static final String DB_FILE = "friends.db";//数据库名称
    private static final String DB_TABLE = "friends";   //表名
    private SQLiteDatabase db;
    private static final String AUTHORITY = "com.example.myapplication.q";//地址
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DB_TABLE);//Uri所对应的资源
    private ContentResolver contentResolver;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        int i = db.delete(DB_TABLE, selection, null);
        return i;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //检查传过来的Uri是否是正确的，若不正确，则抛出异常
        Long rawId = db.insert(DB_TABLE, null, values);
        //在数据库发生变化的时候我们调用notifyChange方法,
        //在该方法中我们通知ContentObserver那个uri数据发生了变化，以便及时更新页面。
        Uri returnUri = ContentUris.withAppendedId(CONTENT_URI, rawId);
        getContext().getContentResolver().notifyChange(returnUri, null);
        return returnUri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        helper = new DbHelper(getContext(), DB_FILE, null, 1);
        db = helper.getWritableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS " + DB_TABLE + "(" +
                "_id primary key," +
                 "name text," +
                "sexId text," +
                "address text);";
        db.execSQL(sql);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = db.query(false, DB_TABLE, projection, selection, selectionArgs, null, null, sortOrder, null);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }
}