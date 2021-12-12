package com.example.ticketbooking;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity
{
    Button b1,b2;
    com.example.ticketbooking.Ticket1 ticket1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        ticket1=new com.example.ticketbooking.Ticket1(this);
        ticket1=ticket1.open();

        // Get The Refference Of Buttons
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        // Set OnClick Listener on SignUp button
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent i1=new Intent(getApplicationContext(),Signup.class);
                startActivity(i1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent i2=new Intent(getApplicationContext(),Signin.class);
                startActivity(i2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        ticket1.close();
    }
}
