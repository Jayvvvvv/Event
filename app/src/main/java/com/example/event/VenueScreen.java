package com.example.event;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VenueScreen extends AppCompatActivity {

    Button sendMassage1 ,sendMassage2, sendMassage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_screen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        sendMassage1 = findViewById(R.id.send_button1);
        sendMassage2 = findViewById(R.id.send_button2);
        sendMassage3 = findViewById(R.id.send_button3);
        sendMassage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VenueScreen.this, SendMassage.class);
                startActivity(intent);
            }
        });
        sendMassage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VenueScreen.this, SendMassage.class);
                startActivity(intent);
            }
        });
        sendMassage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VenueScreen.this, SendMassage.class);
                startActivity(intent);
            }
        });
    }
}