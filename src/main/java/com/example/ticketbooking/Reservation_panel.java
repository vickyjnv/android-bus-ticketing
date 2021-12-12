package com.example.ticketbooking;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reservation_panel extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button b1, b2;
    Spinner s1, s2;
    String source, destination;
    int cost = 0;
    TextView t1, t2;
    EditText e1;
    DatePickerDialog.OnDateSetListener date;


    // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reservation_panel);



        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);

        t1 = (TextView) findViewById(R.id.textView5);
        t2 = (TextView) findViewById(R.id.textView6);
        e1 = (EditText) findViewById(R.id.editText6);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Reservation_panel.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, date, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {

                month = month + 1;
                String date = dayofmonth + "/" + month + "/" + year;
                t2.setText(date);

            }
        };

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i1=new Intent(Reservation_panel.this,Ticket_Details.class);
                i1.putExtra("from", source);
                i1.putExtra("to", destination);
                i1.putExtra("fare", t1.getText().toString());
                i1.putExtra("date", t2.getText().toString());
                i1.putExtra("Name", e1.getText().toString());
                startActivity(i1);



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Reservation_panel.this);
                alert.setMessage("Are you Sure?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialogg = alert.create();
                dialogg.show();
            }
        });


        s1= (Spinner) findViewById(R.id.Spinner);
        s2 = (Spinner) findViewById(R.id.spinner2);

        List<String> locations = new ArrayList<String>();
        locations.add("asansol");
        locations.add("durgapur");
        locations.add("rajbandh");
        locations.add("burdwan");

        source = locations.get(0);
        destination = locations.get(0);

        ArrayAdapter<String> adapterSpinnerSource = new ArrayAdapter<String>(Reservation_panel.this, android.R.layout.simple_spinner_dropdown_item, locations);
        ArrayAdapter<String> adapterSpinnerDestination = new ArrayAdapter<String>(Reservation_panel.this, android.R.layout.simple_spinner_dropdown_item, locations);
        s1.setAdapter(adapterSpinnerSource);

        s2.setAdapter(adapterSpinnerDestination);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                source = parent.getItemAtPosition(position).toString();
                calculatecost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destination = parent.getItemAtPosition(position).toString();

                calculatecost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void calculatecost() {
        if ((source.equals("asansol") && destination.equals("durgapur")) || (source.equals("durgapur") && destination.equals("asansol")))
        {
            cost = 10;
        }
        else if ((source.equals("asansol") && destination.equals("asansol")) || (source.equals("asansol") && destination.equals("asansol")))
        {
            Toast.makeText(getApplicationContext(), "Source and destination should not be same!!", Toast.LENGTH_SHORT).show();
        }
        else if ((source.equals("durgapur") && destination.equals("durgapur")) || (source.equals("durgapur") && destination.equals("durgapur")))
        {
            Toast.makeText(getApplicationContext(), "Source and destination should not be same!!", Toast.LENGTH_SHORT).show();
        }else if ((source.equals("rajbandh") && destination.equals("rajbandh")) || (source.equals("rajbandh") && destination.equals("rajbandh")))
        {
            Toast.makeText(getApplicationContext(), "Source and destination should not be same!!", Toast.LENGTH_SHORT).show();
        }else if ((source.equals("burdwan") && destination.equals("burdwan")) || (source.equals("burdwan") && destination.equals("burdwan")))
        {
            Toast.makeText(getApplicationContext(), "Source and destination should not be same!!", Toast.LENGTH_SHORT).show();
        }




        else if ((source.equals("asansol") && destination.equals("rajbandh")) || (source.equals("rajbandh") && destination.equals("asansol")))
        {
            cost = 20;
        }
        else if ((source.equals("asansol") && destination.equals("burdwan")) || (source.equals("burdwan") && destination.equals("asansol")))
        {
            cost = 30;
        }
        else if ((source.equals("durgapur") && destination.equals("asansol")) || (source.equals("asansol") && destination.equals("durgapur")))
        {
            cost = 10;
        }
        else if ((source.equals("durgapur") && destination.equals("burdwan")) || (source.equals("burdwan") && destination.equals("durgapur")))
        {
            cost = 20;
        }else if ((source.equals("durgapur") && destination.equals("rajbandh")) || (source.equals("rajbandh") && destination.equals("durgapur")))
        {
            cost = 05;
        }else if ((source.equals("rajbandh") && destination.equals("durgapur")) || (source.equals("durgapur") && destination.equals("rajbandh")))
        {
            cost = 05;
        }else if ((source.equals("rajbandh") && destination.equals("asansol")) || (source.equals("asansol") && destination.equals("rajbandh")))
        {
            cost = 20;
        }else if ((source.equals("rajbandh") && destination.equals("burdwan")) || (source.equals("burdwan") && destination.equals("rajbandh")))
        {
            cost = 30;
        }else if ((source.equals("burdwan") && destination.equals("durgapur")) || (source.equals("durgapur") && destination.equals("burdwan")))
        {
            cost = 30;
        }else if ((source.equals("burdwan") && destination.equals("asansol")) || (source.equals("asansol") && destination.equals("burdwan")))
        {
            cost = 40;
        }else if ((source.equals("burdwan") && destination.equals("rajbandh")) || (source.equals("rajbandh") && destination.equals("burdwan")))
        {
            cost = 10;
        }

        t1.setText(String.valueOf(cost));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}