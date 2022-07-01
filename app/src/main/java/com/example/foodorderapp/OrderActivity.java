package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

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

        ArrayList<OrdersModel> list=new ArrayList<>();
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));
        list.add(new OrdersModel(R.drawable.tyu,"cheese Burger","4","55443322"));


        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}