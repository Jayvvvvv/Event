package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class E_InvitationScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einvitation_screen);

        TextView wedCardView;
        wedCardView = findViewById(R.id.w_card_view);
        wedCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(E_InvitationScreen.this, CardsOfWedding.class));
            }
        });

        TextView vedioCardView;
        vedioCardView = findViewById(R.id.vedio_cards_view);
        vedioCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(E_InvitationScreen.this, VedioCards.class));
            }
        });

        TextView saveCardView;
        saveCardView = findViewById(R.id.save_card_view);
        saveCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(E_InvitationScreen.this, SaveTheDateCards.class));
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.e_invites);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeScreen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.vendor:
                        startActivity(new Intent(getApplicationContext(), ListOfEvent.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.e_invites:
                        return true;


//                    case R.id.ideas:
//                        startActivity(new Intent(getApplicationContext(), IdeaScreen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//
//                    case R.id.plane:
//                        startActivity(new Intent(getApplicationContext(), PlanningScreen.class));
//                        overridePendingTransition(0,0);
//                        return true;

                }
                return false;
            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}