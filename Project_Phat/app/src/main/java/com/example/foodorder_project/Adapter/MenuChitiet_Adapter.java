package com.example.foodorder_project.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorder_project.ChitietMonAnActivity;
import com.example.foodorder_project.MenuChitiet_Activity;
import com.example.foodorder_project.MenuChitiet_Lau_Activity;
import com.example.foodorder_project.MenuChitiet_TrangMieng_Activity;
import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.Model.MenuChitiet;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class MenuChitiet_Adapter extends RecyclerView.Adapter<MenuChitiet_Adapter.MenuViewHolder> {

    private ArrayList<MenuChitiet> listmenu;
    private Context context;

    public MenuChitiet_Adapter(Context context, ArrayList<MenuChitiet> listmenu) {
        this.context = context;
        this.listmenu = listmenu;
    }

    @NonNull
    @Override
    public MenuChitiet_Adapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_chitiet,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuChitiet_Adapter.MenuViewHolder holder, @SuppressLint("RecyclerView") int position) {
          MenuChitiet menuChitiet = listmenu.get(position);
          holder.txtstar.setText(String.valueOf(menuChitiet.reviewStar));
          holder.food_name.setText(menuChitiet.foodName);
          holder.food_price.setText(String.valueOf(menuChitiet.price));
          Glide.with(context)
                .load(menuChitiet.image) // Đường dẫn hình ảnh từ Firebase
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                switch (position) {
                    case 0:
                        // Mở Activity tương ứng với dòng 0
                        Intent intent0 = new Intent(context, ChitietMonAnActivity.class);
                        context.startActivity(intent0);
                        break;
                    // Thêm các trường hợp khác nếu cần
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listmenu != null) {
            return listmenu.size();
        }
        return listmenu.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtstar, food_name, food_price;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            txtstar= itemView.findViewById(R.id.txtstar);
            food_name= itemView.findViewById(R.id.food_name);
            food_price= itemView.findViewById(R.id.food_price);
            img = itemView.findViewById(R.id.image_food);

        }
    }

}
