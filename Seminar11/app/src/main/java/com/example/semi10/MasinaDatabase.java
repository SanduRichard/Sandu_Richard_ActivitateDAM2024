package com.example.semi10;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Masina.class}, version = 1, exportSchema = false)
public abstract class MasinaDatabase extends RoomDatabase {

    public abstract MasinaDAO masinaDao();

    private static volatile MasinaDatabase INSTANCE;

    public static MasinaDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MasinaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MasinaDatabase.class, "masina_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
