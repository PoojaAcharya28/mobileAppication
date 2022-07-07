package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    protected ImageView incrementItemCount, decrementItemCount;
    protected TextView itemQuantity;
    protected int itemCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DbHelper helper = new DbHelper(this);

        incrementItemCount = findViewById(R.id.incrementItemCount);
        decrementItemCount = findViewById(R.id.decrementItemCount);
        itemQuantity = findViewById(R.id.itemQuantity);

        //insert operation begins.....
        if (getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.nameBox.setText("");
            binding.nameLbl.setText(name);
            binding.detailDescription.setText(description);


            binding.orderNowBtn.setOnClickListener((view) -> {
                boolean isInserted = helper.insertorder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.itemQuantity.getText().toString())
                );
                if (isInserted)
                    Toast.makeText(DetailActivity.this, "Data Sucess.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DetailActivity.this, "ERROR.", Toast.LENGTH_LONG).show();





            });



            incrementItemCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemCount++;

                    itemQuantity.setText(String.valueOf(itemCount));
//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
                }
            });

            decrementItemCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemCount>0) itemCount--;
                    itemQuantity.setText(String.valueOf(itemCount));
//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
                }
            });

        }// insert ends update code begins
        else {
            //fetch data from db
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
//            Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
            int image =cursor.getInt(4);
            binding.detailimage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.nameLbl.setText(cursor.getString(7));     //6
            binding.detailDescription.setText(cursor.getString(6));   //5
            binding.itemQuantity.setText(cursor.getString(5));   //changes  added extra


            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.orderNowBtn.setText("update Now");
            binding.orderNowBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated =helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.nameLbl.getText().toString(),

                            Integer.parseInt(binding.itemQuantity.getText().toString()),

                            //1,
                            id



                            );

                    if(isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Not updated", Toast.LENGTH_SHORT).show();
                }
            });

            incrementItemCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String itemqua=itemQuantity.getText().toString();
                    int itemCounts=Integer.parseInt(itemqua);
                    itemCounts++;
                    //itemCount++;
                    //Toast.makeText(DetailActivity.this, itemCounts, Toast.LENGTH_SHORT).show();
                    System.out.println(itemCounts);
                    itemQuantity.setText(String.valueOf(itemCounts));
//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
                }
            });

            decrementItemCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String itemqua=itemQuantity.getText().toString();
                    int itemCounts=Integer.parseInt(itemqua);
                    if(itemCounts>0)
                    {

                        itemCounts--;
                        itemQuantity.setText(String.valueOf(itemCounts));
                    }

//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}