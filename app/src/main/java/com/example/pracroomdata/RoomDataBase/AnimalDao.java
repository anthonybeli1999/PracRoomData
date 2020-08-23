package com.example.pracroomdata.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Animal animal);

    @Query("SELECT * FROM animal")
    LiveData<List<Animal>> getAllAnimales();

    @Query("DELETE FROM animal")
    void deleteAll();
}
