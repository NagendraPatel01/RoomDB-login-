package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdb.DB.DatabaseProvider;
import com.example.roomdb.Model.UserModel;


import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String edit1=   email.getText().toString();
                String edit2= password.getText().toString();

              if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(MainActivity.this, "please enter email", Toast.LENGTH_SHORT).show();
                }

                else  if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){

                    Toast.makeText(MainActivity.this, "please enter valid email", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                }

                else if (password.getText().toString().length()<6){

                    Toast.makeText(MainActivity.this, "please enter 6 digit or more then password", Toast.LENGTH_SHORT).show();
                }

                else {

                /*    UserModel userModel=new UserModel();

                    userModel.setEmail(edit1);
                    userModel.setPassword(edit2);*/

                    DatabaseProvider databaseProvider= DatabaseProvider.getDbConnection(MainActivity.this.getApplicationContext());
                  List<UserModel> userModels= databaseProvider.getuserDao().getAlluser();

                    Iterator<UserModel> userModelIterator=userModels.iterator();

                    while (userModelIterator.hasNext())
                    {

                        UserModel userModel=(UserModel) userModelIterator.next();

                        String email1=userModel.getEmail();
                        String pass1=userModel.getPassword();
                        if (edit1.equals(email1) && edit2.equals(pass1))
                        {
                            startActivity(new Intent(MainActivity.this,HomeRMActivity.class));
                            Toast.makeText(MainActivity.this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
                            finish();

                        }

                        else {

                            Toast.makeText(MainActivity.this, "Login Field", Toast.LENGTH_SHORT).show();


                        }


                    }



                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,RagisterActivity.class));
                finish();
            }
        });
    }
}