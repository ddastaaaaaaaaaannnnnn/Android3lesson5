package com.example.android3lesson5.local.room.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android3lesson5.local.room.daos.CategoryDao;
import com.example.android3lesson5.local.room.daos.WordDao;
import com.example.android3lesson5.local.room.models.CategoryModel;
import com.example.android3lesson5.local.room.models.WordModel;

@Database(entities = {CategoryModel.class, WordModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    AppDatabase appdatabase;

    public AppDatabase getDatabase() {
        return appdatabase;
    }

    public abstract CategoryDao categoryDao();

    public abstract WordDao wordDao();
}
