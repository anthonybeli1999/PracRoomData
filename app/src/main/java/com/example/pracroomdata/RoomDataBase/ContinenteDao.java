package com.example.pracroomdata.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContinenteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Continente continente);

    @Query("SELECT * FROM continente")
    LiveData<List<Continente>> getAllContinentes();

    @Query("DELETE FROM continente")
    void deleteAll();
}
