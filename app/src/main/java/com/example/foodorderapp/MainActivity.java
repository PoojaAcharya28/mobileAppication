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

        list.add(new MainModel(R.drawable.abc, "Burger", "90", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Machine gun", "100", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "165", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.tyu, "samosa", "155", "Chicken burger with extra cheese"));


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
