package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
@Database(entities = Dailyexpense.class, exportSchema = false, version = 1)
public abstract class Databasehelper extends RoomDatabase {
    private static final String DB_NAME = "expense";
    private static Databasehelper instance;

    public static synchronized Databasehelper getDB(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, Databasehelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract ExpenceDao expenceDao();
}
