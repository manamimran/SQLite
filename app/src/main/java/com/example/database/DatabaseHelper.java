package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DemoDb.db";          //name the database
    public static final String TABLE_NAME = "Student";             //name the table
    public static final String COL_1 = "Id";                         // creating the fields   ,  column 1, column 2, column 3, column 4
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Phone #";
    public static final String COL_4 = "Address";

    public DatabaseHelper(@Nullable Context context) {                     //constructor (here we create database)
        super(context, DATABASE_NAME, null, 1);
        //  SQLiteDatabase db=this.getReadableDatabase();                //show data in database
    }

    @Override
    public void onCreate(SQLiteDatabase db) {                         //we perform all functionality in ONCREAT and ONUPGRADE
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONE INTEGER, ADDRESS TEXT)");                    //we create table with fields of database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);                            //drop table in database we created
        onCreate(db);
    }

    public Boolean insertData(String name, String phone, String address) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, address);
        long res = db.insert(TABLE_NAME, null, contentValues);                         //we will take LONG datatype variable RES to check

        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }
}
