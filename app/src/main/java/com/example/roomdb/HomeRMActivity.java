package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.roomdb.DB.DatabaseProvider;
import com.example.roomdb.Model.UserModel;

import java.util.List;

public class HomeRMActivity extends AppCompatActivity {

    RecyclerView recycle;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_rmactivity);

        recycle=findViewById(R.id.recycle);
        logout=findViewById(R.id.logout);

        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();



                startActivity(new Intent(HomeRMActivity.this,MainActivity.class));

                Toast.makeText(HomeRMActivity.this, "logout Succesfully", Toast.LENGTH_SHORT).show();


                finish();
                
            }
        });


        DatabaseProvider databaseProvider= DatabaseProvider.getDbConnection(HomeRMActivity.this.getApplicationContext());
        List<UserModel> userModels= databaseProvider.getuserDao().getAlluser();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeRMActivity.this, RecyclerView.VERTICAL, false);
        recycle.setLayoutManager(linearLayoutManager);

        RoomAdapter roomAdapter=new RoomAdapter(getApplicationContext(),userModels);
        recycle.setAdapter(roomAdapter);

    }
}