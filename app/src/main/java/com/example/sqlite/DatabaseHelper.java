package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String dbName = "Login.db";

    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table users(email TEXT primary key, password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE if exists users");

    }

    public Boolean insertData(String email , String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = database.insert("users",null,contentValues);

        if(result==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkEmail(String email)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users where email =?",new String[]{email});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkBoth(String email,String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users where email = ? and password = ?",new String[]{email,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
