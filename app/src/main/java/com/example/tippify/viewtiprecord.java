package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class viewtiprecord extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(viewtiprecord.this);
    RatingBar rbStars;
    TextView tvFeedback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtiprecord);

        rbStars = findViewById(R.id.rbStars);
        tvFeedback = findViewById(R.id.tvFeedback);




        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputs();
            }
        });

        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 0) {
                    tvFeedback.setText("Very Dissatisfied");
                } else if (rating == 1) {
                    tvFeedback.setText("Dissatisfied");
                } else if (rating == 2 || rating == 3) {
                    tvFeedback.setText("OK");
                } else if (rating == 4) {
                    tvFeedback.setText("Satisfied");
                } else if (rating == 5) {
                    tvFeedback.setText("Very Satisfied");
                } else {

                }
            }
        });
        Button btnReport = findViewById(R.id.buttonReport);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){displayReportScreen();} {

            }
        });


    }
    private  void displayReportScreen()
    {
        startActivity(new Intent(this,Report.class));
    }
    private void getInputs(){
        EditText tip = findViewById(R.id.Tip);
        EditText feedback = findViewById(R.id.Feedback);


        // reading the contents of edit text
        String Tip = tip.getText().toString();
        String Feedback = feedback.getText().toString();



        if(Tip.length()==0 || Feedback.length()==0  )
        {
            Toast.makeText(viewtiprecord.this,"FIELDS CAN NOT BE  EMPTY..",
                    Toast.LENGTH_LONG).show();
            return;
        }

        displayNextAlert(Tip,Feedback);

    }

    private void displayNextAlert(String tip, String feedback) {
        new AlertDialog.Builder(this).setTitle("Thank you for the feedback")
                .setNeutralButton("Back",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }

                        })

                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // save the details entered if save button is clicked
                        saveDetails();



                    }
                }).show();


    }


    private  void saveDetails()
    {
        DatabaseHelper dbHelper = new DatabaseHelper(viewtiprecord.this);
        EditText tip = findViewById(R.id.Tip);
        EditText feedback = findViewById(R.id.Feedback);




        String Tip = tip.getText().toString();
        String Feedback= feedback.getText().toString();


        System.out.println(Tip);
        System.out.println(Feedback);



        dbHelper.insertDetails(Tip,Feedback);
        Toast.makeText(viewtiprecord.this,"Feedback submitted successful.",Toast.LENGTH_LONG)
                .show();

    }

}
//public class payment extends AppCompatActivity

