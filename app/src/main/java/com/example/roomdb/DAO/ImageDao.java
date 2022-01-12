package com.example.roomdb.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdb.Model.ImageModel;

import java.util.List;

@Dao
public interface ImageDao {

    @Query("SELECT * FROM ImageModel")
    List<ImageModel> getAll();

    @Insert
    void insertAll(ImageModel... myImage);

    @Delete
    void delete(ImageModel myImage);
}
