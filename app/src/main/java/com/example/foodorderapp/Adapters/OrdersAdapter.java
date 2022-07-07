package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.DbHelper;
import com.example.foodorderapp.DetailActivity;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model =  list.get(position);

        System.out.println("----------------------------------");
        System.out.println(model.getOrderNumber());
        System.out.println("----------------------------------");

        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());



        holder.itemQuantityTextView.setText(model.getItemQuantity());
//        holder.orderNumber.setText(model.getOrderNumber());

        holder.price.setText(model.getPrice());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
//                intent.putExtra("type",2);
//                context.startActivity(intent);
//            }
//        });

        holder.removeFromCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try{
                    DbHelper helper = new DbHelper(context);
                    if(helper.deleteOrder(model.getOrderNumber()) > 0) {
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView orderImage;
        TextView soldItemName,orderNumber,price, itemQuantityTextView;
        Button removeFromCart;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImage);
            soldItemName=itemView.findViewById(R.id.orderItemName);
            orderNumber=itemView.findViewById(R.id.quan);
            price=itemView.findViewById(R.id.orderPrice);
            itemQuantityTextView = itemView.findViewById(R.id.itemQuantity);
            removeFromCart = itemView.findViewById(R.id.removeFromCart);
        }
    }
}
