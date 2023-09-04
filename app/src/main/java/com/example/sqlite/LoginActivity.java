package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login,newAcc;
    EditText userName, password;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        login=findViewById(R.id.loginbtn);
        newAcc=findViewById(R.id.newAcc);
        password=findViewById(R.id.password);
        userName=findViewById(R.id.userName);

        databaseHelper = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = userName.getText().toString();
                String pass = password.getText().toString();

                if(uname.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Fill all Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean check = databaseHelper.checkBoth(uname,pass);
                    if(check)
                    {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}