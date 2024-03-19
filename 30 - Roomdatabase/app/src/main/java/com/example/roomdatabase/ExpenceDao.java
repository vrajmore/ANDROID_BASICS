package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenceDao {

    @Query("select * from expense")
    List<Dailyexpense> showAllData();

    @Insert
    void insertData(Dailyexpense dailyexpense);

    @Update
    void updataData(Dailyexpense dailyexpense);

    @Delete
    void deleteData(Dailyexpense dailyexpense);
}
