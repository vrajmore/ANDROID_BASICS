package com.example.databasesql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhandler handler = new dbhandler(this, "empdb",null,1);
//        handler.addemployee(new emp(1,"hell yes",100));
        handler.getEmoloyee(3);
//        for(int i=0 ; i> handler.getDBSize(); i++){
//            handler.getEmoloyee(i);
//        }
//        Log.d("mytag", String.valueOf(handler.getDBSize()));
        handler.close();

    }
}