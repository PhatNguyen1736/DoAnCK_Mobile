package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailOrderActivity extends AppCompatActivity {
    ArrayList<Detail_order> listoder;
    RecyclerView recyclerView;
    DetailOrder_Adapter detailOrder_adapter;
    FirebaseFirestore db;
    TextView phidukien, tongcong;
    Button btnthanhtoan;
    ImageView imgedit, imgvoucher, imgpay;
    EditText voucher;
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
        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.rcl_order);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        listoder = new ArrayList<Detail_order>();
        String receivedData3 = null;
        String voucherid = null;
        btnthanhtoan = findViewById(R.id.Button_dathang);

        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadOrderDataToFirebase();
                Intent intent1 = new Intent(DetailOrderActivity.this, DathangthanhcongActivity.class);
                startActivity(intent1);
            }
        });
        imgpay = findViewById(R.id.arrow1);

        imgpay.setOnClickListener(new View.OnClickListener() {
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
        imgvoucher = findViewById(R.id.icon_voucher);
        imgvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailOrderActivity.this, voucherggActivity.class);
                startActivity(intent1);
                voucher.setText("SO15");

            }
        });

        if (intent != null) {
            String receivedData1 = intent.getStringExtra("FoodName");
            String receivedData2 = intent.getStringExtra("Quality1");
            receivedData3 = intent.getStringExtra("Price1");
            String receivedData4 = intent.getStringExtra("Note1");
            voucherid = intent.getStringExtra("Voucher1");

            Log.d("OrderItem", "Name: " + receivedData1);
            Log.d("OrderItem", "Quantity: " + receivedData2);
            Log.d("OrderItem", "Price: " + receivedData3);
            Log.d("OrderItem", "Note: " + receivedData4);
            Log.d("OrderItem", "Voucher: " + voucherid);

//            listoder = new ArrayList<Detail_order>();
            listoder.add(new Detail_order(R.drawable.comhaplasen1, receivedData1, "x3", receivedData3));
            // Gán dữ liệu vào TextView trong Activity B
        }

        detailOrder_adapter = new DetailOrder_Adapter(listoder, DetailOrderActivity.this);
        recyclerView.setAdapter(detailOrder_adapter);

        phidukien = findViewById(R.id.price_chiphi);
        tongcong = findViewById(R.id.Tonggia);
        voucher = findViewById(R.id.edit_voucher);
        phidukien.setText(receivedData3);
        tongcong.setText(receivedData3);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_id) {
                // Xử lý khi nhấn vào Trang chủ
                if (!isMainActivity()) {
                    openMainActivity();
                    return true;
                }
            } else if (itemId == R.id.menu_id) {
                openmenu();
                // Xử lý khi nhấn vào Thực đơn
            } else if (itemId == R.id.giohang_id) {
                // Xử lý khi nhấn vào Giỏ hàng
                opengiohang();
            } else if (itemId == R.id.bagach_id) {
                // Xử lý khi nhấn vào Khác
                openbagach();
            }
            return true;
        });

    }
    private void uploadOrderDataToFirebase() {
        // Lấy reference đến tài liệu trong Firestore
        DocumentReference orderRef = db.collection("Orders").document();

        // Lấy 3 trường dữ liệu giống nhau từ listoder
        Map<String, Object> orderData = new HashMap<>();
        for (Detail_order orderItem : listoder) {
            orderData.put("FoodName", orderItem.getFoodName());
            orderData.put("Quantity", orderItem.getQuantity());
            orderData.put("Price", orderItem.getPrice());
        }

        // Gán 5 trường còn lại là giá trị tự gán vào
        orderData.put("Location", "Khu phố 6, Linh Trung ,Thủ Đức");
        orderData.put("Payment", "Tiền mặt");
        orderData.put("Username", "Nguyễn Tấn Phát");
        orderData.put("voucherID", "SO15");
        orderData.put("status", "Đang giao");
        // Lấy ngày và giờ hiện tại
        long createDate = System.currentTimeMillis();

        // Thêm trường createDate vào orderData
        orderData.put("createDate", new Date(createDate));

        // Đặt giá trị cho các trường trong tài liệu
        orderRef.set(orderData)
                .addOnSuccessListener(documentReference -> {
//                    Log.d("Firestore", "Order item added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error adding order item", e);
                });
    }
    private boolean isMainActivity() {
        // Kiểm tra xem đang ở MainActivity hay không
        return getClass().getSimpleName().equals(MainActivity.class.getSimpleName());
    }
    private void openMainActivity() {
        // Khởi tạo lại MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    private void openmenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    private void opengiohang() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    private void openbagach() {
        Intent intent = new Intent(this, ThongtinkhacActivity.class);
        startActivity(intent);
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
