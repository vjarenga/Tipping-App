package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class EmployeeInterfaceOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_interface_one);
        CardView exit = findViewById(R.id.cardlogout2);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeInterfaceOne.this,MainActivity.class));
            }

        });
        CardView guide = findViewById(R.id.cardtipguide2);
        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeInterfaceOne.this,tipguide.class));

            }
        });
        CardView calculate_tip = findViewById(R.id.cardtipcalculate2);
        calculate_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeInterfaceOne.this,calculatetip.class));

            }
        });
        CardView view_record = findViewById(R.id.cardtiprecords2);
        view_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeInterfaceOne.this,viewtiprecord.class));

            }
        });


    }



}