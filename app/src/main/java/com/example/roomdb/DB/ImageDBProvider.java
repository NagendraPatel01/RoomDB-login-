package com.example.roomdb.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb.DAO.ImageDao;
import com.example.roomdb.DAO.UserDao;
import com.example.roomdb.Model.ImageModel;

@Database(entities = {ImageModel.class},version = 1)
public abstract class ImageDBProvider extends RoomDatabase {


    public abstract ImageDao getImageDao();

    public static ImageDBProvider imageDBProvider=null;
    public static  ImageDBProvider  getDbConnection(Context context){


        if (imageDBProvider==null){

            imageDBProvider= Room.databaseBuilder(context.getApplicationContext(),ImageDBProvider.class,"mydbimg")
                    .allowMainThreadQueries().build();
        }

        return imageDBProvider;
    }

}
