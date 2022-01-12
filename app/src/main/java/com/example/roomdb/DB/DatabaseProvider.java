package com.example.roomdb.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb.DAO.UserDao;
import com.example.roomdb.Model.UserModel;

@Database(entities = {UserModel.class},version = 1)
public  abstract class DatabaseProvider  extends RoomDatabase {

   public abstract UserDao getuserDao();

   public static DatabaseProvider databaseProvider=null;
   public static  DatabaseProvider  getDbConnection(Context context){


       if (databaseProvider==null){

           databaseProvider= Room.databaseBuilder(context.getApplicationContext(),DatabaseProvider.class,"mydb")
                   .allowMainThreadQueries().build();
       }

       return databaseProvider;
   }

}
