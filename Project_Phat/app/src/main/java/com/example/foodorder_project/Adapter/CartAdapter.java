package com.example.foodorder_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.ChitietMonAnActivity;
import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<Cart> listcart;
    private Context context;

    public CartAdapter(ArrayList<Cart> listcart, Context context) {
        this.listcart = listcart;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {

        holder.FoodPicture.setImageResource(listcart.get(position).getFoodPicture());
        holder.txtFoodName.setText(listcart.get(position).getFoodName());
        holder.txtQuantity.setText(listcart.get(position).getQuantity());
        holder.txtPrice.setText(listcart.get(position).getPrice());
        holder.txtNote.setText(listcart.get(position).getNote());

        holder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                Intent intent = new Intent(context, ChitietMonAnActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listcart.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgedit;
        ImageView FoodPicture;
        TextView txtFoodName, txtQuantity, txtPrice, txtNote;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodPicture = itemView.findViewById(R.id.img_food);
            txtFoodName = itemView.findViewById(R.id.food_name);
            txtQuantity = itemView.findViewById(R.id.number_food);
            txtPrice = itemView.findViewById(R.id.price);
            txtNote = itemView.findViewById(R.id.add_note);
            imgedit = itemView.findViewById(R.id.edit);

        }
    }


}
