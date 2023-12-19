package com.example.foodorder_project.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Model.Category;
import com.example.foodorder_project.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateViewHolder> {

    private List<Category> mListCate;
    public CategoryAdapter(List<Category> mListCate) {
        this.mListCate = mListCate;
    }
    @NonNull
    @Override
    public CategoryAdapter.CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new CateViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CateViewHolder holder, int position) {
        Category cate = mListCate.get(position);
        if(cate == null) {
            return;
        }
        holder.imgCate.setImageResource(cate.getImage());
        holder.tvName.setText(cate.getName());

    }

    @Override
    public int getItemCount() {
        if (mListCate != null) {
            return mListCate.size();
        }
        return 0;
    }

    public class CateViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCate;
        private TextView tvName;
        public CateViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCate = itemView.findViewById(R.id.img_cate);
            tvName = itemView.findViewById(R.id.tv_cate);
        }
    }


}

