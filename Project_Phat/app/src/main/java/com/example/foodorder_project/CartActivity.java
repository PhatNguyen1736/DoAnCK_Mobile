package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
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
        Intent intent = getIntent();
        String receivedData2 = null;
        if (intent != null) {
            String receivedData3 = intent.getStringExtra("Image");
            String receivedData = intent.getStringExtra("Name");
            String receivedData1 = intent.getStringExtra("Quality");
            receivedData2 = intent.getStringExtra("Price");
            String receivedData4 = intent.getStringExtra("Note");

            // Gán dữ liệu vào TextView trong Activity B
            listcart = new ArrayList<Cart>();
            listcart.add(new Cart(R.drawable.lauthai, receivedData, receivedData1, receivedData2, receivedData4));
        }


        CartAdapter adapter = new CartAdapter(listcart, this);
        recyclerView.setAdapter(adapter);

        AppCompatButton btnthem = findViewById(R.id.btn_themmon);
        TextView totalPrice = findViewById(R.id.totalPrice);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CartActivity.this, MenuChitiet_Activity.class);
                startActivity(intent1);
            }
        });
        totalPrice.setText(receivedData2);

    }
}
