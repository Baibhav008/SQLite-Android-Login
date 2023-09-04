package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button signUp,Back;
    EditText userName,password;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        signUp=findViewById(R.id.signUp);
        Back=findViewById(R.id.back);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);

        databaseHelper = new DatabaseHelper(this);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = userName.getText().toString();
                String pass = password.getText().toString();

                if(uname.equals("")||pass.equals(""))
                {
                    Toast.makeText(SignUpActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkusername = databaseHelper.checkEmail(uname);
                    if(checkusername==false)
                    {
                        Boolean insert = databaseHelper.insertData(uname,pass);

                        if(insert)
                        {

                            Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(i);

                        }

                        else
                        {
                            Toast.makeText(SignUpActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "User already Exist", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}