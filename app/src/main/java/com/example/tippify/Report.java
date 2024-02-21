package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Report extends AppCompatActivity {
    DatabaseHelper dbHelper = new DatabaseHelper(Report.this);;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ListView listView = (ListView) findViewById(R.id.Listview);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = dbHelper.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(Report.this,"Nothing in database.",Toast.LENGTH_LONG)
                    .show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);


            }
        }











    }

   }