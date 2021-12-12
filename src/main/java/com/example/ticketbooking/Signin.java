package com.example.ticketbooking;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Signin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    private com.example.ticketbooking.Ticket1 ticket1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);



        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        Button b1=(Button)findViewById(R.id.button3);
        ticket1=new com.example.ticketbooking.Ticket1(this);
        ticket1=ticket1.open();


        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=e1.getText().toString();
                String password=e2.getText().toString();

                // fetch the Password from database for respective user name
                String storedPassword=ticket1.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(Signin.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

                    Intent i=new Intent(Signin.this,Reservation_panel.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Signin.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
