package com.example.foodorderapp;

import androidx.annotation.NonNull;
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
    private Toolbar toolbar;

    ActivityMainBinding binding;
//    Button order2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar=findViewById(R.id.myToolBar);

        ImageView leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "you clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
            }
        });



        setSupportActionBar(toolbar);

        ArrayList<MainModel> list =new ArrayList<>();
//        order2=(Button) findViewById(R.id.order2);
//        String name,price,description;

        list.add(new MainModel(R.drawable.abc, "Burger", "90", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Machine gun", "100", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "5", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.abc, "Burger", "165", "Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.tyu, "samosa", "155", "Chicken burger with extra cheese"));

//        ArrayList<OrdersModel> list=new ArrayList<>();
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recycleView.setAdapter(adapter);

//        OrdersAdapter adapter=new OrdersAdapter(list,this);
//        binding.recycleView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(layoutManager);
//        order2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
//                startActivity(intent);
//            }
//        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (item.getItemId() == R.id.order1) {
//            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
////            startActivity(new Intent(MainActivity.this, OrderActivity.class));
//            Intent i = new Intent(MainActivity.this, OrderActivity.class);
//            startActivity(i);
//        } else {
//            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
//        }
//         return super.onOptionsItemSelected(item);
//
//    }
}

