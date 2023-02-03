package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

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
}