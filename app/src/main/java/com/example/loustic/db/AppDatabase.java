package com.example.loustic.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.google.android.gms.gcm.Task;


@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}





