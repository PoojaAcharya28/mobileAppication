package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.os.Bundle;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;


public class BillingActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setContentView(R.layout.activity_billing);




        DbHelper helper=new DbHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();

//        int id = getIntent().getIntExtra("id",0);
//        Cursor cursor = helper.getOrderById(id);
//        String all="";
//               String amt = "";
//               SQLiteDatabase database = helper1.getWritableDatabase();
//               Cursor cursor = database.rawQuery("Select foodname,price,quantity from orders", null);
//                int sum = 0;
//                while(cursor.moveToNext())
//               {
//                    String name=cursor.getString(0);
//                   String price=cursor.getString(1);
//                   String quan=cursor.getString(2);
//                    int p = Integer.parseInt(price);
////                    int q = Integer.parseInt(quan);
//                    int pr = p*q;
//                   all+="--------------------------------------------------\nName: "+name+"\nQuantity: "+q+"\nPrice: "+pr+"\n\n" +
//                           "--------------------------------------------------\n";
//                    sum +=pr;
//                }





        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);


    }


}