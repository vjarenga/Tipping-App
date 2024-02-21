package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Currency extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);

        String[] to ={"Indian Rupees","Srilankan Rupees","Kenyan shilling", "USD","Euros","Swiss franc","Syrian pound", "Moroccan dirham","Rwandan franc", "Philippine peso", "Mexican peso", "Mauritanian ouguiya"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        String[] from ={"USD","Euros","Swiss franc","Syrian pound", "Moroccan dirham","Rwandan franc", "Philippine peso", "Mexican peso", "Mauritanian ouguiya", "Indian Rupees", "Srilankan Rupees","Kenyan shilling"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;

                Double amount = Double.parseDouble(ed1.getText().toString());

                if (sp1.getSelectedItem().toString()== "USD" && sp2.getSelectedItem().toString()=="Indian Rupees"){
                    tot = amount * 70.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG)
                            .show();
                }
                else if(sp1.getSelectedItem().toString()== "USD" && sp2.getSelectedItem().toString()=="Srilankan Rupees"){
                    tot = amount * 180.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG)
                            .show();
                }else if (sp1.getSelectedItem().toString()== "USD" && sp2.getSelectedItem().toString()=="Kenyan shilling"){
                    tot = amount * 153.25 ;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG)
                            .show();
                }else if (sp1.getSelectedItem().toString()== "USD" && sp2.getSelectedItem().toString()=="Euros") {
                    tot = amount * 0.93;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG)
                            .show();
                }
                else if (sp1.getSelectedItem().toString()== "USD" && sp2.getSelectedItem().toString()=="Swiss franc") {
                    tot = amount * 0.88;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG)
                            .show();
                }else if (sp1.getSelectedItem().toString()== "Moroccan dirham" && sp2.getSelectedItem().toString()=="Kenyan shilling") {
                    tot = amount * 15.08;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}