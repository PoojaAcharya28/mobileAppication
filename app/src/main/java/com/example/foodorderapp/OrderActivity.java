package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.print.PrintHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
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


//        checkout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(OrderActivity.this,BillingActivity.class);
//                startActivity(intent);
//            }
//        });

        final DbHelper helper1 = new DbHelper(this);
        int id = getIntent().getIntExtra("id",0);
        Cursor cursor = helper1.getOrderById(id);

        checkout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String all="";
                String amt = "";
                SQLiteDatabase database = helper1.getWritableDatabase();
                Cursor cursor = database.rawQuery("Select foodname,price,quantity from orders", null);
                int sum = 0;
                while(cursor.moveToNext())
                {
                    String name=cursor.getString(0);
                    String price=cursor.getString(1);
                    String quan=cursor.getString(2);
                    int p = Integer.parseInt(price);
                    int q = Integer.parseInt(quan);
                    int pr = p*q;
                    all+="--------------------------------------------------\nName: "+name+"\nQuantity: "+q+"\nPrice: "+pr+"\n\n" +
                            "--------------------------------------------------\n";
                    sum +=pr;
                }
                AlertDialog.Builder alert=new AlertDialog.Builder(OrderActivity.this);
                alert.setTitle("Your Orders");
                amt = all +"\nTotal Price : "+sum;
                alert.setMessage(amt);
                alert.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OrderActivity.this, "Your order has been confirmed", Toast.LENGTH_SHORT).show();


                        //code for taking the pdf of invoice...............
                        View view = getWindow().getDecorView().findViewById(android.R.id.content);
                        view.setDrawingCacheEnabled(true);
                        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),View. MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                        view.buildDrawingCache(true);

                        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
                        view.setDrawingCacheEnabled(false);
                        PrintHelper photoPrinter = new PrintHelper(OrderActivity.this);
                        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
                        photoPrinter.printBitmap("print", bitmap);



                    }
                });
                alert.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OrderActivity.this, "Your order has been cancelled", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
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