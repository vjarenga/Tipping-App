package com.example.tippify;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity {


    // Daraja daraja;


    // Initiate M-Pesa payment here
    // You can use the code from step 3 inside this method
    // Initialize Daraja

    private EditText editTextTotalBill;
    private EditText editTextNumberOfPeople;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editTextTotalBill = findViewById(R.id.editTextTotalBill);
        editTextNumberOfPeople = findViewById(R.id.editTextNumberOfPeople);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);



        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSplitBill();
            }
        });
    }

    private void calculateSplitBill() {
        String totalBillStr = editTextTotalBill.getText().toString();
        String numberOfPeopleStr = editTextNumberOfPeople.getText().toString();

        if (!totalBillStr.isEmpty() && !numberOfPeopleStr.isEmpty()) {
            double totalBill = Double.parseDouble(totalBillStr);
            int numberOfPeople = Integer.parseInt(numberOfPeopleStr);

            if (numberOfPeople > 0) {
                double individualShare = totalBill / numberOfPeople;
                String result = String.format("Individual Share: $%.2f", individualShare);
                textViewResult.setText(result);
            } else {
                textViewResult.setText("Number of people must be greater than 0");
            }
        } else {
            textViewResult.setText("Please enter both total bill and number of people");
        }
    }
}