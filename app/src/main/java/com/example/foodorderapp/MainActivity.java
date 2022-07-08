package com.example.foodorderapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar myToolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(myToolbar);

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.roastedcoffebean, "Roasted Coffee Bean", "450", "Roast Coffee Price Range:Rs 450 per kg"));
        list.add(new MainModel(R.drawable.wheattt, "Wheat", "50", "Wheat  Price Range-Rs 50 per kg"));
        list.add(new MainModel(R.drawable.buckywheat, "Bucky Wheat", "60", "Bucky Wheat Price Range:Rs 60 per kg"));
        list.add(new MainModel(R.drawable.barley, "Barley", "119", "Barley Price Range:Rs 119 per kg"));
        list.add(new MainModel(R.drawable.teffgrain, "Teff Grain", "500", "Teff grain Price Range:Rs 500 per kg"));
        list.add(new MainModel(R.drawable.rye, "Rye", "150", "Rye Price Range:Rs 150 per kg"));
        list.add(new MainModel(R.drawable.rice, "Rice", "65", "Rice Price Range:Rs 65 per kg"));
        list.add(new MainModel(R.drawable.redrice, "Red Rice", "96", "Red Rice Price Range:Rs 96 per kg"));
        list.add(new MainModel(R.drawable.oats, "Oats", "190", "Oats Price Range:Rs 190 per kg"));
        list.add(new MainModel(R.drawable.milletsjpg, "Millets", "28", "Millets Price Range:Rs 28 per kg"));
        //list.add(new MainModel(R.drawable.maize, "Maize", "", "Barley Price Range:Rs 25 per kg"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.activityMainRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.activityMainRecycleView.setLayoutManager(layoutManager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbarmenu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
//
            case R.id.action_cart:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
