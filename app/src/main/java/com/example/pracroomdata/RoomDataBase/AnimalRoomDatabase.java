package com.example.pracroomdata.RoomDataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Animal.class}, version = 1, exportSchema = false)
public abstract class AnimalRoomDatabase extends RoomDatabase {
    public abstract AnimalDao animalDao();
    private static AnimalRoomDatabase INSTANCIA;

    public static AnimalRoomDatabase getDatabase(final Context context){
        if (INSTANCIA == null){
            synchronized (AnimalRoomDatabase.class){
                if (INSTANCIA == null){
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            AnimalRoomDatabase.class, Animal.TABLE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase bd){
            super.onOpen(bd);
            new LLenarBDAsync(INSTANCIA).execute();
        }
    };

    private static class LLenarBDAsync extends AsyncTask<Void,Void,Void> {

        private final AnimalDao animalDao;
        String[] nombres = {"NOMBRE"};
        String[] estructura = {"ESTRUCTURA"};
        String[] alimentacion = {"ALIMENTO"};
        String[] continente = {"CONTINENTE"};

        LLenarBDAsync(AnimalRoomDatabase bd) {
            animalDao = bd.animalDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            animalDao.deleteAll();
            for (int i=0; i<=nombres.length-1; i++){
                Animal animal = new Animal(nombres[i],estructura[i],alimentacion[i],continente[i]);
                animalDao.insert(animal);
            }
            return null;
        }
    }
}
