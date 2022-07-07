package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    Button checkout;
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

        checkout =findViewById(R.id.checkOut);

        final DbHelper helper1 = new DbHelper(this);
        int id = getIntent().getIntExtra("id",0);
        Cursor cursor = helper1.getOrderById(id);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String all="";
                SQLiteDatabase database = helper1.getWritableDatabase();
                Cursor cursor = database.rawQuery("Select foodname,price,quantity from orders", null);
                while(cursor.moveToNext())
                {
                    String i=cursor.getString(0);
                    String n=cursor.getString(1);
                    String p=cursor.getString(2);
                    all+="Name: "+i+"\nprice: "+n+"\nQuantity: "+p+"\n\n";

                }
                AlertDialog.Builder alert=new AlertDialog.Builder(OrderActivity.this);
                alert.setTitle("Your Orders");
                alert.setMessage(all);
                AlertDialog a=alert.create();
                a.show();
            }
        });







//        ImageView leftIcon = findViewById(R.id.bill_icon);

//        leftIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(OrderActivity.this, "you clicked", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(OrderActivity.this, BillingActivity.class));
//            }
//        });
// code to get data from db
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