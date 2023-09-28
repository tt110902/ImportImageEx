package com.example.importimageex;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Image.class}, version = 1)
@TypeConverters({ImageBitmapString.class})
public abstract class DatabaseProviderImg extends RoomDatabase {
    public abstract ImageDao imageDao();

    private static DatabaseProviderImg databaseProvider = null;

    public static DatabaseProviderImg getDbConnection(Context context)
    {
        if (databaseProvider == null)
        {
            databaseProvider = Room.databaseBuilder(context.getApplicationContext(), DatabaseProviderImg.class, "imgDB")
                    .allowMainThreadQueries()
                    .build();

        }
        return databaseProvider;
    }
}
