package com.example.loustic.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Plus besoin du faux import Task !

// On dit bien à Room que notre table c'est User.class
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}