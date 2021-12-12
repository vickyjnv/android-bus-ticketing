package com.example.ticketbooking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ticket_Details extends AppCompatActivity {


    TextView t1, t2, t3, t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ticket__details);


        t1 = (TextView) findViewById(R.id.textView21);
        t2 = (TextView) findViewById(R.id.textView13);
        t3 = (TextView) findViewById(R.id.textView14);
        t4 = (TextView) findViewById(R.id.textView17);
        t5 = (TextView) findViewById(R.id.textView19);

        Intent i2 = getIntent();
        Bundle bundle = i2.getExtras();
        String a = bundle.getString("from");
        String b = bundle.getString("to");
        String c = bundle.getString("fare");
        String d = bundle.getString("date");
        String e = bundle.getString("Name");

        t1.setText(a);
        t2.setText(b);
        t3.setText(c);
        t4.setText(d);
        t5.setText(e);

    }
}