package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.orderToolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);




//        ImageView leftIcon = findViewById(R.id.bill_icon);

//        leftIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(OrderActivity.this, "you clicked", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(OrderActivity.this, BillingActivity.class));
//            }
//        });

        DbHelper helper=new DbHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();

//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
//        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));


        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}