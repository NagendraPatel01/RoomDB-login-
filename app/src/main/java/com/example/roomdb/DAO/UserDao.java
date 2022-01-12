package com.example.roomdb.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdb.Model.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertuser(UserModel...user);


    @Query("SELECT * FROM UserModel")
    public List<UserModel> getAlluser();


    @Delete
    public  void delete(UserModel userModel);
}
