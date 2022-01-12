package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdb.DB.DatabaseProvider;
import com.example.roomdb.Model.UserModel;

public class RagisterActivity extends AppCompatActivity {

    EditText name,mobile,email,password;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);


        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit1= name.getText().toString();
                String edit2=  mobile.getText().toString();
                String edit3=  email.getText().toString();
                String edit4= password.getText().toString();





                if (TextUtils.isEmpty(name.getText().toString())){

                    Toast.makeText(RagisterActivity.this, "please enter name", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(mobile.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "please enter mobile no", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "please enter email", Toast.LENGTH_SHORT).show();
                }

                else  if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){

                    Toast.makeText(RagisterActivity.this, "please enter valid email", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                }

                else if (password.getText().toString().length()<6){

                    Toast.makeText(RagisterActivity.this, "please enter 6 digit or more then password", Toast.LENGTH_SHORT).show();
                }



                else {

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("name",name.getText().toString());
                    editor.putString("phone no",mobile.getText().toString());
                    editor.putString("email",email.getText().toString());
                    editor.putString("=password",password.getText().toString());
                    editor.commit();

                    Toast.makeText(RagisterActivity.this, "submit succesfully", Toast.LENGTH_SHORT).show();


                    UserModel userModel=new UserModel();

                    userModel.setName(edit1);
                    userModel.setMobile(edit2);
                    userModel.setEmail(edit3);
                    userModel.setPassword(edit4);

                    DatabaseProvider databaseProvider= DatabaseProvider.getDbConnection(RagisterActivity.this);
                    databaseProvider.getuserDao().insertuser(userModel);


                    startActivity(new Intent(RagisterActivity.this,HomeRMActivity.class));
                    finish();
                    Toast.makeText(RagisterActivity.this, "Ragister SuccessFully", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(RagisterActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}