package com.example.studentsqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase";

    private static final int DATABASE_VERSION = 1;

    // Define your table creation SQL statement
    private static final String TABLE_CREATE =
            "CREATE TABLE my_table (" +
                    "_id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "rollno INTEGER," +
                    "address TEXT," +
                    "gender TEXT);";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.d("tag", "Table created: " + TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
