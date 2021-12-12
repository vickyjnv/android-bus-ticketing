package com.example.ticketbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    com.example.ticketbooking.Ticket1 ticket1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ticket1=new com.example.ticketbooking.Ticket1(this);
        ticket1=ticket1.open();

        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        b1=(Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String a=e1.getText().toString();
                String b=e2.getText().toString();
                String c=e3.getText().toString();

                if(a.equals("")||b.equals("")||c.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!b.equals(c))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    ticket1.insertEntry(a,b);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Signup.this,Signin.class);
                    startActivity(i);
                }


            }
        });
    }
}
