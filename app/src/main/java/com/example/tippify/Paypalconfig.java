package com.example.tippify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.protobuf.StringValue;

import java.util.ArrayList;
import java.util.List;



public class Paypalconfig extends AppCompatActivity {

    private List<BillItem> billItems = new ArrayList<>();
    private LinearLayout itemContainer;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypalconfig);

        itemContainer = findViewById(R.id.itemContainer);
        resultTextView = findViewById(R.id.resultTextView);

        Button addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBillItem();
            }
        });

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateShares();
            }
        });
    }

    private void addBillItem() {
        View itemView = getLayoutInflater().inflate(R.layout.item_layout, itemContainer, false);

        itemContainer.addView(itemView);
    }

    private void calculateShares() {
        double total = 0;

        for (int i = 0; i < itemContainer.getChildCount(); i++) {
            View itemView = itemContainer.getChildAt(i);
            EditText itemNameEditText = itemView.findViewById(R.id.itemNameEditText);
            EditText itemCostEditText = itemView.findViewById(R.id.itemCostEditText);

            String itemName = itemNameEditText.getText().toString();
            double itemCost = Double.parseDouble(itemCostEditText.getText().toString());

            total += itemCost;
            // You may want to store these items in a data structure for further processing
        }

        // Display the total and any other relevant information
        resultTextView.setText(String.valueOf(total) );
    }
    public class BillItem {
        // Define properties and methods for the BillItem class
        private String itemName;
        private double itemCost;

        public BillItem(String itemName, double itemCost) {
            this.itemName = itemName;
            this.itemCost = itemCost;
        }

        public String getItemName() {
            return itemName;
        }

        public double getItemCost() {
            return itemCost;
        }
    }
}
