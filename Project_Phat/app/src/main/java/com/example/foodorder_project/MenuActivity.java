package com.example.foodorder_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.foodorder_project.Adapter.CategoryAdapter;
import com.example.foodorder_project.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView rclView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);

        rclView = findViewById(R.id.recycler_menu);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rclView.setLayoutManager(gridLayoutManager);

        CategoryAdapter adapter = new CategoryAdapter(getListCate());
        rclView.setAdapter(adapter);
    }

    private List<Category> getListCate() {
        List<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.com, "Cơm chay"));
        list.add(new Category(R.drawable.lau, "Lẩu chay"));
        list.add(new Category(R.drawable.bun, "Bún/Phở"));
        list.add(new Category(R.drawable.monkhac, "Món khác"));
        list.add(new Category(R.drawable.trangmieng, "Tráng miệng"));
        list.add(new Category(R.drawable.anvat, "Ăn vặt"));

        return list;

    }
}

