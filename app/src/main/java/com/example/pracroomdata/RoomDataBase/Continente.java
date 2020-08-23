package com.example.pracroomdata.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = Continente.TABLE_NAME)
public class Continente{

    public static final String TABLE_NAME = "continente";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombreContinente")
    private String nombreContinente;


    public Continente(@NonNull String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

}
