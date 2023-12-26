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
import com.example.foodorder_project.Model.Detail_order;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class DetailOrder_Adapter extends RecyclerView.Adapter<DetailOrder_Adapter.DetailOrderViewHolder>{
    private ArrayList<Detail_order> listdetail;
    private Context context;

    public DetailOrder_Adapter(ArrayList<Detail_order> listdetail , Context context) {
        this.listdetail = listdetail;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailOrder_Adapter.DetailOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_order,parent,false);
        return new DetailOrder_Adapter.DetailOrderViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull DetailOrder_Adapter.DetailOrderViewHolder holder, int position) {

        holder.FoodPicture.setImageResource(listdetail.get(position).getFoodPicture());
        holder.txtFoodName.setText(listdetail.get(position).getFoodName());
        holder.txtQuantity.setText(listdetail.get(position).getQuantity());
        holder.txtPrice.setText(listdetail.get(position).getPrice());
//        holder.txtNote.setText(listdetail.get(position).getNote());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                Intent intent = new Intent(context, ChitietMonAnActivity.class);
                context.startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                int deletedPosition = holder.getAdapterPosition();

                // Kiểm tra xem vị trí có hợp lệ không
                if (deletedPosition != RecyclerView.NO_POSITION) {
                    // Xóa mục khỏi danh sách
                    listdetail.remove(deletedPosition);

                    // Thông báo cho RecyclerView biết rằng một mục đã bị xóa
                    notifyItemRemoved(deletedPosition);
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        if (listdetail != null) {
            return listdetail.size();
        }
        return listdetail.size();
    }

    public class DetailOrderViewHolder extends RecyclerView.ViewHolder {
        ImageView FoodPicture, edit, delete;
        TextView txtFoodName, txtQuantity, txtPrice, txtNote;
        public DetailOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodPicture = itemView.findViewById(R.id.img_food);
            txtFoodName = itemView.findViewById(R.id.food_name);
            txtQuantity = itemView.findViewById(R.id.sl);
            txtPrice = itemView.findViewById(R.id.price);
//            txtNote = itemView.findViewById(R.id.add_note);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}
