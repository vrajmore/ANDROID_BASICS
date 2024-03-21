package com.example.databasesql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbhandler extends SQLiteOpenHelper {


    public dbhandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE myemployee (sno INTEGER PRIMARY KEY, name TEXT, increment TEXT)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"my employee"});
        onCreate(db);
    }


    public void addemployee(emp emp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("increment", emp.getIncrement());
        Long k = db.insert("myemployee", null, values);
        Log.d("mytag", Long.toString(k));
        db.close();
    }

    public void getEmoloyee(int sno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("myemployee", new String[]{"sno", "name", "increment"}, "sno=?", new String[]{String.valueOf(sno)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            Log.d("mytag", cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2));
        }else {
            Log.d("mytag","some error occured");
        }

    }
}
