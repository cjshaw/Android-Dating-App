package com.example.shawasssisignment1;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseSingleton {
    private static AppDatabase db;

    public AppDatabaseSingleton() {

    }

    public static AppDatabase getDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "settings-database")
                    .build();
        }
        return db;
    }

}
