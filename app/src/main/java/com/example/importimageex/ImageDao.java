package com.example.importimageex;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insert(Image...image);

    @Query("SELECT * FROM image")
    List<Image> getAllImage();

    @Delete
    void delete(Image image);
}


