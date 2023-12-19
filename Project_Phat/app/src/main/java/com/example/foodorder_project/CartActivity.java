package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.CartAdapter;
import com.example.foodorder_project.Model.Cart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ArrayList<Cart> listcart;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        recyclerView = findViewById(R.id.recycleview_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listcart = new ArrayList<Cart>();
        listcart.add(new Cart(R.drawable.lauthai, "Lau tao", "2", "590000", "Bun them"));
//        listcart.add(new Cart(R.drawable.lauthai, "Lau", "3", "230000","Rau them"));
//        listcart.add(new Cart(R.drawable.lauthai, "Lau thai", "2", "590000","Bun them"));


        CartAdapter adapter = new CartAdapter(listcart, this);
        recyclerView.setAdapter(adapter);

    }
}
