package com.example.tippify;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "discover";
    private static final int DB_VERSION = 4;
    private static final String TABLE_NAME = "activity";
    private static final String ID_COL = "id";
    private static final String tip_COL = "tip";
    private static final String Feedback_COL = "feed";



    // creating a constructor for our database handler.
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Feedback_COL + " TEXT,"
                + tip_COL + " TEXT)";


        db.execSQL(query);
    }




    public void insertDetails(String tip, String feed) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();



        values.put(tip_COL, tip);
        values.put(Feedback_COL, feed);



        db.insert(TABLE_NAME, null, values);


        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getListContents (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;


    }
    public void  deleteActivity(String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "name=?", new String[]{Name});
        db.close();
    }



}


