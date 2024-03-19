package com.example.studentsqlapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataAccess {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DataAccess(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        // Open the database for read/write operations
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        // Close the database when done
        dbHelper.close();
    }

    public long insertData(String name, int rollno, String address, String gender) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("rollno", rollno);
        values.put("address", address);
        values.put("gender", gender);


        // Insert data into the table
        return database.insert("my_table", null, values);
    }

    public Cursor getAllData() {
        // Retrieve all data from the table
        return database.query("my_table", null, null, null, null, null, null);
    }

}
