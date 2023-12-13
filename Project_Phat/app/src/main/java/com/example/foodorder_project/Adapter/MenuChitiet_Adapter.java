package com.example.foodorder_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.Model.MenuChitiet;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class MenuChitiet_Adapter extends RecyclerView.Adapter<MenuChitiet_Adapter.MenuViewHolder> {

    private ArrayList<MenuChitiet> listmenu;
    private Context context;

    public MenuChitiet_Adapter(ArrayList<MenuChitiet> listmenu, Context context) {
        this.listmenu = listmenu;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuChitiet_Adapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_chitiet,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuChitiet_Adapter.MenuViewHolder holder, int position) {

        holder.imgheart.setImageResource(listmenu.get(position).getImgheart());
        holder.imgfood.setImageResource(listmenu.get(position).getImgfood());
        holder.txtfoodname.setText(listmenu.get(position).getFoodname());
        holder.txtprice.setText(listmenu.get(position).getPrice());
        holder.txtevaluation.setText(listmenu.get(position).getEveluation());

    }

    @Override
    public int getItemCount() {
        return listmenu.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView imgheart, imgfood;
        TextView txtfoodname, txtprice, txtevaluation;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imgheart = itemView.findViewById(R.id.img_heart);
            imgfood = itemView.findViewById(R.id.image_food);
            txtevaluation = itemView.findViewById(R.id.txtstar);
            txtfoodname = itemView.findViewById(R.id.food_name);
            txtprice = itemView.findViewById(R.id.food_price);
        }
    }

}
