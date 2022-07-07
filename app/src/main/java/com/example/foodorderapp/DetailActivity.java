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
    protected TextView itemQuantityTextView;
    protected int itemCount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DbHelper helper = new DbHelper(this);

        incrementItemCount = findViewById(R.id.incrementItemCount);
        decrementItemCount = findViewById(R.id.decrementItemCount);
        itemQuantityTextView = findViewById(R.id.itemQuantity);



//        ----------- From Main Activity "Order" or "Add to Cart" -----------

        if (getIntent().getIntExtra("type", 0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);

            binding.nameLbl.setText(name);

            binding.priceLbl.setText(String.valueOf(price));
            binding.nameBox.setText(name);

            binding.detailDescription.setText(description);

            binding.addToCartBtn.setOnClickListener((view) -> {
                boolean isInserted = helper.insertorder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        itemCount
                );
                if (isInserted)
                    Toast.makeText(DetailActivity.this, "Data Sucess.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DetailActivity.this, "ERROR.", Toast.LENGTH_LONG).show();
            });


        }
//        ----------- From Order Activity "Add cart" -> "Update Now" -----------
        else {
            int id = getIntent().getIntExtra("id", 0);
            try {
                Cursor cursor = helper.getOrderById(id);
                int image = cursor.getInt(4);
                binding.detailimage.setImageResource(image);
                binding.priceLbl.setText(String.valueOf(cursor.getInt(3)));
                binding.nameLbl.setText(cursor.getString(6));
                binding.detailDescription.setText(cursor.getString(5));

                binding.nameBox.setText(cursor.getString(1));
                binding.phoneBox.setText(cursor.getString(2));
                binding.addToCartBtn.setText("update Now");

                binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdated = helper.updateOrder(
                                binding.nameBox.getText().toString(),
                                binding.phoneBox.getText().toString(),
                                Integer.parseInt(binding.priceLbl.getText().toString()),
                                image,
                                binding.detailDescription.getText().toString(),
                                binding.nameLbl.getText().toString(),
                                1,
                                id
                        );

                        if (isUpdated)
                            Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(DetailActivity.this, "Not updated", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {
                Toast.makeText(DetailActivity.this, "Error handled", Toast.LENGTH_SHORT).show();
            }

        }

        incrementItemCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount++;
                itemQuantityTextView.setText(String.valueOf(itemCount));
//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
            }
        });

        decrementItemCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemCount>0) itemCount--;
                itemQuantityTextView.setText(String.valueOf(itemCount));
//                    Toast.makeText(DetailActivity.this, String.valueOf(itemCount),Toast.LENGTH_SHORT).show();
            }
        });
    }
}