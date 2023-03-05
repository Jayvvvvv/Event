package com.example.event;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlanningSceern extends AppCompatActivity {


    Button sendMassage, sendMassage1, sendMassage2, sendMassage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_sceern);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        sendMassage1 = findViewById(R.id.send_button21);
        sendMassage2 = findViewById(R.id.send_button22);
        sendMassage3 = findViewById(R.id.send_button23);

        sendMassage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanningSceern.this, SendMassage.class);
                startActivity(intent);
            }
        });
        sendMassage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanningSceern.this, SendMassage.class);
                startActivity(intent);
            }
        });
        sendMassage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanningSceern.this, SendMassage.class);
                startActivity(intent);
            }
        });
    }
}