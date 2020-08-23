package com.example.pracroomdata.RoomDataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Continente.class}, version = 1, exportSchema = false)
public abstract class ContinenteRoomDatabase extends RoomDatabase {
    public abstract ContinenteDao continenteDao();
    private static ContinenteRoomDatabase INSTANCIA;

    public static ContinenteRoomDatabase getDatabase(final Context context){
        if (INSTANCIA == null){
            synchronized (ContinenteRoomDatabase.class){
                if (INSTANCIA == null){
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            ContinenteRoomDatabase.class, Continente.TABLE_NAME)
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

        private final ContinenteDao continenteDao;

        String[] nombres = {"AFRICA","AMERICA","ASIA","EUROPA","OCEANIA","ANTARTIDA"};

        LLenarBDAsync(ContinenteRoomDatabase bd) {
            continenteDao = bd.continenteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            continenteDao.deleteAll();
            for (int i=0; i<=nombres.length-1; i++){
                Continente continente = new Continente(nombres[i]);
                continenteDao.insert(continente);
            }
            return null;
        }
    }
}
