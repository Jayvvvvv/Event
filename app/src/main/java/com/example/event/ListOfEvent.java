package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class ListOfEvent extends AppCompatActivity implements View.OnClickListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_event);

        ImageView image1, image2, image3, image4;
        image1 = (ImageView) findViewById(R.id.image_venues);
        image2 = (ImageView) findViewById(R.id.photos_images);
        image3 = (ImageView) findViewById(R.id.make_up);
        image4 = (ImageView) findViewById(R.id.bridal_wear);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.vendor);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeScreen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.vendor:
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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.image_venues:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
            case R.id.photos_images:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
            case R.id.make_up:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
            case R.id.bridal_wear:
                i = new Intent(this, VenueScreen.class);
                startActivity(i);
                break;
        }

    }
}