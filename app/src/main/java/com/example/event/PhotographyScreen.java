package com.example.event;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PhotographyScreen extends AppCompatActivity {

    Button sendMassage1, sendMassage2, sendMassage3, sendMassage4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography_screen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        sendMassage1 = findViewById(R.id.send_button11);
        sendMassage2 = findViewById(R.id.send_button12);
        sendMassage3 = findViewById(R.id.send_button13);
        sendMassage4 = findViewById(R.id.send_button14);

        sendMassage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotographyScreen.this, SendMassagePhotographer.class);
                startActivity(intent);
            }
        });
        sendMassage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotographyScreen.this, SendMassagePhotographer.class);
                startActivity(intent);
            }
        });
        sendMassage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotographyScreen.this, SendMassagePhotographer.class);
                startActivity(intent);
            }
        });
        sendMassage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotographyScreen.this, SendMassagePhotographer.class);
                startActivity(intent);
            }
        });
    }
}