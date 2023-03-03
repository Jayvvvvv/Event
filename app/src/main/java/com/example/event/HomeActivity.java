package com.example.event;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;



import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.event.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.c1:
                    i = new Intent(this, ListOfEvent.class);
                    startActivity(i);
                    break;
            case R.id.c2:
                    i = new Intent(this, BirthdayEvent.class);
                    startActivity(i);
                    break;
            case R.id.c3:
                    i = new Intent(this, WeddingAniversoryEvent.class);
                    startActivity(i);
                    break;
            case R.id.c4:
                    i = new Intent(this, FamilyAndFriendEvent.class);
                    startActivity(i);
                    break;
        }
    }

//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame, fragment);
//        fragmentTransaction.commit();
//    }




//    public void btnNext(View view){
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

//        MenuItem.OnActionExpandListener OnActionExpendListener = new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(@NonNull MenuItem menuItem) {
//                Toast.makeText(HomeActivity.this, "Searching...", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(@NonNull MenuItem menuItem) {
//                Toast.makeText(HomeActivity.this, "Searching end!", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        };
//        menu.findItem(R.id.searchTool).setOnActionExpandListener(OnActionExpendListener);
//        SearchView searchView =(SearchView) menu.findItem(R.id.searchTool).getActionView();
//        searchView.setQueryHint("Search your event...");
        return true;
    }

};