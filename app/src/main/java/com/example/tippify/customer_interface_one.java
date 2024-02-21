package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class customer_interface_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_interface_one);

        CardView pay = findViewById(R.id.cardpayment);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,payment.class));
            }

        });
        CardView guide = findViewById(R.id.cardtipguide);
        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,tipguide.class));

            }
        });
        CardView calculate_tip = findViewById(R.id.cardtipcalculate);
        calculate_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,calculatetip.class));

            }
        });
        CardView view_record = findViewById(R.id.cardtiprecords);
        view_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,viewtiprecord.class));

            }
        });
        CardView currency = findViewById(R.id.cardcurrency);
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,Currency.class));

            }
        });
        CardView exit = findViewById(R.id.cardexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customer_interface_one.this,Paypalconfig.class));

            }
        });


    }
}