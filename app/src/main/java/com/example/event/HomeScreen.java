package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3;
    ImageView more;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        btn1 = (Button) findViewById(R.id.venues_views);
        btn2 = (Button) findViewById(R.id.photography_views);
        btn3 = (Button) findViewById(R.id.planning_views);
        more = (ImageView) findViewById(R.id.more_list);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        more.setOnClickListener(this);


       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.home:
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
                       startActivity(new Intent(getApplicationContext(), IdeaScreen.class));
                       overridePendingTransition(0,0);
                       return true;

                   case R.id.plane:
                       startActivity(new Intent(getApplicationContext(), PlanningScreen.class));
                       overridePendingTransition(0,0);
                       return true;
               }
               return false;
           }
       });
    }
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.more_list:
                i= new Intent(this, ListOfEvent.class);
                startActivity(i);
                break;
            case R.id.venues_views:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
            case R.id.photography_views:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
            case R.id.planning_views:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
        }
    }

}