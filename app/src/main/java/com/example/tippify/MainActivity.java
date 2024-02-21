package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
     RadioButton radio_one;
     RadioButton radio_two;

     Button buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         radioGroup = findViewById(R.id.radioGroup);
         radio_one = findViewById(R.id.radio_one);
         radio_two = findViewById(R.id.radio_two);
        Button buttonNext = findViewById(R.id.button_Next);

        buttonNext.setOnClickListener( new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                if (radio_one.isChecked()) {

                    startActivity(new Intent(MainActivity.this,customer_interface_one .class));

                }
                else
                    startActivity(new Intent(MainActivity.this, customer_interface_one .class));
        }
    });
}
public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

}
}