package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IdeaScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_screen);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ideas);

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
                        startActivity(new Intent(getApplicationContext(), E_InvitationScreen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ideas:
                        return true;

                    case R.id.plane:
                        startActivity(new Intent(getApplicationContext(), PlanningScreen.class));
                        overridePendingTransition(0,0);
                        return true;
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