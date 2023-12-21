package com.example.foodorder_project.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Model.Category;
import com.example.foodorder_project.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateViewHolder> {

    private ArrayList<Category> mListCate;
    Context context;

    public CategoryAdapter(Context context,ArrayList<Category> mListCate) {
        this.mListCate = mListCate;
        this.context = context;
    }
    @NonNull
    @Override
    public CategoryAdapter.CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new CateViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CateViewHolder holder, int position) {
        Category cate = mListCate.get(position);
//        holder.imgCate.setImageResource(cate.image);
        holder.tvName.setText(cate.nameCategory);

    }

    @Override
    public int getItemCount() {
        if (mListCate != null) {
            return mListCate.size();
        }
        return mListCate.size();
    }

    public static class CateViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCate;
        private TextView tvName;
        public CateViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgCate = itemView.findViewById(R.id.img_cate);
            tvName = itemView.findViewById(R.id.tv_cate);
        }
    }


}

