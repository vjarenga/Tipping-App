package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculatetip extends AppCompatActivity {

    private EditText countryEditText;
    private EditText billAmountEditText;
    private Button calculateButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatetip);

        // Initialize views
        countryEditText = findViewById(R.id.countryEditText);
        billAmountEditText = findViewById(R.id.billAmountEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View v)

                {
                    String country = countryEditText.getText().toString();
                    double billAmount = Double.parseDouble(billAmountEditText.getText().toString());

                    double tipPercent = 0;
                    if (country.equals("USA")) {
                        tipPercent = 0.18;
                    } else if (country.equals("Canada")) {
                        tipPercent = 0.15;
                    } else {
                        tipPercent = 0.10;
                    }

                    double tipAmount = billAmount * tipPercent;
                    double totalAmount = billAmount + tipAmount;

                    resultTextView.setText(String.valueOf(totalAmount));
                }
            });
        }
    }