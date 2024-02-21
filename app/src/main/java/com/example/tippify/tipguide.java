package com.example.tippify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class tipguide extends AppCompatActivity {
    private String [][] tipping_guide ={

            {"Kenya","Depending on the quality of the service, etiquette recommends that a 15% tip for the waiter is customary, just like in North America or practically every other nation in Europe."},
            {"China" ,"No tipping required"},
            {"Canada" ,"The standard tipping rate for waiters is generally around 15-20% of the bill before tax is applied. This is a good baseline for satisfactory service. However, if the service was exceptional, you may consider tipping more."},
            {"Australia ","No tipping required, as most restaurants have a service charge. A tipping jar is usually available where a token sum is given."},
            {"France", "Bellhops and hotel porters: If you need help carrying your bags, tip €1-2 per bag.\n" +
                    "Doormen: For valet services or help with hailing taxis, leave a €1 tip.\n" +
                    "Room service waiters: Add a few euros to compensate the staff for delivering your meals or helping you with other information.\n" +
                    "Concierge: If you had help making restaurant reservations or arranging other services, consider leaving a €5-20 tip.\n"},
            {"Germany", "in restaurants, a reasonable tip is between 5-10% of the bill, and a 15% tip is considered very generous. \n" +
                    "Tipping taxi drivers in Germany is considered a generous and courteous thing to do. Feel free to add 5-10%, depending on the level of service. Alternatively, you might choose to round up the cost of your trip to the nearest euro or tell the driver to keep the change.\n"},
            {"Mexico", "in most restaurants, it's customary to leave a tip equal to 10 to 20 percent of the total cost of the bill. \n" +
                    "It is not customary to tip taxi drivers, unless they assist you with your luggage, in which case 10 pesos per suitcase is a good rule of thumb. \n"},
            {"United Kingdom"," when dining out, a service charge of 12-15 percent may be added to your bill, but the practice is not universal in U.K. restaurants. If you see the service charge on your bill, there's no need to tip. If there's no service charge, tipping at 10 percent is the standard"}


    };

Button btn;
HashMap<String,String> item;
String [][] Tipping_guide={};
ArrayList list;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipguide);


        btn =findViewById(R.id.buttonback);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tipguide.this,customer_interface_one.class));

            }
        });

        list= new ArrayList();
        for(int i=0;i<tipping_guide.length; i++){
            item=new HashMap<String, String>();
            item.put("line1",tipping_guide[i][0]);
            item.put("line2",tipping_guide[i][1]);


            list.add(item);

        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
        new String[]{"line1","line2"},
        new int []{R.id.line1,R.id.line2}
        );
        ListView lst = findViewById(R.id.ListViewguide);
        lst.setAdapter(sa);

    }
}