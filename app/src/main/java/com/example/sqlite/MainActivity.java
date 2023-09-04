package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


//BASIC SQLite Queries------------------------------------------------------------------------
/*
        try
        {
            SQLiteDatabase database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age INT(4))");
          //  database.execSQL("INSERT INTO users VALUES('wolf',40)");
          //  database.execSQL("INSERT INTO users VALUES('wild',20)");
           // database.execSQL("INSERT INTO users VALUES('lion',18)");
           // database.execSQL("INSERT INTO users VALUES('destroyer',24)");

            Cursor c =database.rawQuery("SELECT * FROM users WHERE age>18",null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while(c!=null)
            {
                Log.i("name",c.getString(nameIndex));
                Log.i("age",c.getString(ageIndex));
                c.moveToNext();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

*/

/*
        try
        {SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events",MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4) )");
            sqLiteDatabase.execSQL("INSERT INTO events VALUES ('Alien invasion',2024)");
            sqLiteDatabase.execSQL("INSERT INTO events VALUES ('Super Power',2025)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM events",null);
            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

 */
//BASIC SQLite Queries------------------------------------------------------------------------




    }
}