package com.example.pracroomdata.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Animal.TABLE_NAME)
public class Animal {

    public static final String TABLE_NAME = "animal";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombreAnimal")
    private String nombreAnimal;

    @NonNull
    @ColumnInfo(name = "estructuraAnimal")
    private String estructuraAnimal;

    @NonNull
    @ColumnInfo(name = "alimentacionAnimal")
    private String alimentacionAnimal;

    @NonNull
    @ColumnInfo(name = "nombreContinente")
    private String nombreContinente;

    public Animal(@NonNull String nombreAnimal, @NonNull String estructuraAnimal, @NonNull String alimentacionAnimal, @NonNull String nombreContinente) {
        this.nombreAnimal = nombreAnimal;
        this.estructuraAnimal = estructuraAnimal;
        this.alimentacionAnimal = alimentacionAnimal;
        this.nombreContinente = nombreContinente;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public String getEstructuraAnimal() {
        return estructuraAnimal;
    }

    public String getAlimentacionAnimal() {
        return alimentacionAnimal;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }



}
