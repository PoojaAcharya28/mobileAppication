package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ImageView leftIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.abc, "Burger", "90", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Machine gun", "100", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "165", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.tyu, "samosa", "155", "Chicken burger with extra cheese"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recycleView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);


        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_cart:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
//
            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
