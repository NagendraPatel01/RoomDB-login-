package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.roomdb.Model.UserModel;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);


        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (sharedPreferences==null){

                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }

                else {

                    startActivity(new Intent(SplashActivity.this,HomeRMActivity.class));

                    finish();
                }



            }
        },2000);

    }
}