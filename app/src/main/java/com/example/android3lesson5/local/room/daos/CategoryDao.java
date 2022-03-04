package com.example.android3lesson5.local.room.daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android3lesson5.local.room.models.CategoryModel;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(CategoryModel categoryModels);


    @Query("SELECT * FROM categorymodel")
    LiveData<List<CategoryModel>> getAll();

}
