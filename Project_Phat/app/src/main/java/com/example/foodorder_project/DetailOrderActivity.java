package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.CartAdapter;
import com.example.foodorder_project.Adapter.DetailOrder_Adapter;
import com.example.foodorder_project.Adapter.MenuChitiet_Adapter;
import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.Model.Detail_order;
import com.example.foodorder_project.Model.MenuChitiet;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DetailOrderActivity extends AppCompatActivity {
    ArrayList<Detail_order> listoder;
    RecyclerView recyclerView;
    DetailOrder_Adapter detailOrder_adapter;
    FirebaseFirestore db;
    TextView phidukien, tongcong;
    Button btnthanhtoan;
    ImageView imgedit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_order);

//        recyclerView = findViewById(R.id.rcl_order);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        db = FirebaseFirestore.getInstance();
//        listoder = new ArrayList<>();
//        detailOrder_adapter = new DetailOrder_Adapter(DetailOrderActivity.this, listoder);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setAdapter(detailOrder_adapter);
//        EventChangeListener();

        recyclerView = findViewById(R.id.rcl_order);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        listoder = new ArrayList<Detail_order>();
        String receivedData3 = null;
        btnthanhtoan = findViewById(R.id.Button_dathang);
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailOrderActivity.this, PaymentActivity.class);
                startActivity(intent1);
            }
        });
        imgedit = findViewById(R.id.edit);

        imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailOrderActivity.this, ThongtincanhanActivity.class);
                startActivity(intent1);
            }
        });
        if (intent != null) {
            String receivedData1 = intent.getStringExtra("FoodName");
            String receivedData2 = intent.getStringExtra("Quality1");
            receivedData3 = intent.getStringExtra("Price1");
            String receivedData4 = intent.getStringExtra("Note1");

            Log.d("OrderItem", "Name: " + receivedData1);
            Log.d("OrderItem", "Quantity: " + receivedData2);
            Log.d("OrderItem", "Price: " + receivedData3);
            Log.d("OrderItem", "Note: " + receivedData4);

//            listoder = new ArrayList<Detail_order>();
            listoder.add(new Detail_order(R.drawable.lauthai, receivedData1, receivedData2, receivedData3));
            // Gán dữ liệu vào TextView trong Activity B
        }

        detailOrder_adapter = new DetailOrder_Adapter(listoder, DetailOrderActivity.this);
        recyclerView.setAdapter(detailOrder_adapter);

        phidukien = findViewById(R.id.price_chiphi);
        tongcong = findViewById(R.id.Tonggia);
        phidukien.setText(receivedData3);
        tongcong.setText(receivedData3);


    }

//    private void EventChangeListener() {
//        db.collection("Menu_Detail")
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                        if (error != null){
//                            Log.e("Firestore error", error.getMessage());
//                            return;
//                        }
//
//                        for (DocumentSnapshot dc: value.getDocuments()){
//
//                            Detail_order menu = dc.toObject(Detail_order.class);
//                            listoder.add(menu);
//                            if (menu != null) {
////                                String foodName= menu.getFoodName();
////                                Log.d("Food Name", foodName);
////                                int foodprice = menu.getPrice();
////                                Log.d("Food price", String.valueOf(foodprice));
////                                int foodstart= menu.getReviewStar();
////                                Log.d("Food start", String.valueOf(foodstart));
//                            }
//                        }
//                        detailOrder_adapter.notifyDataSetChanged();
//                    }
//                });
//    }
}
