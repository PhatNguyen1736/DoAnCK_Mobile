package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.CartAdapter;
import com.example.foodorder_project.Model.Cart;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        String  receivedData2 = null;
        if (intent != null) {
            String receivedData3 = intent.getStringExtra("Image");
            String receivedData = intent.getStringExtra("Name");
            String receivedData1 = intent.getStringExtra("Quality");
            receivedData2 = intent.getStringExtra("Price");
            String receivedData4 = intent.getStringExtra("Note");

            // Gán dữ liệu vào TextView trong Activity B
            listcart = new ArrayList<Cart>();
            listcart.add(new Cart(R.drawable.comhaplasen1, receivedData, receivedData1, receivedData2, receivedData4));
        }
        // Truy xuất dữ liệu trong listcart
//        if (listcart != null && listcart.size() > 0) {
//            // Lấy đối tượng Cart đầu tiên từ danh sách
//            Cart firstCartItem = listcart.get(0);
//
//            // Lấy các thông tin từ đối tượng Cart
////            int imageResource = firstCartItem.getImageResource();
//            String name = firstCartItem.getFoodName();
//            String quantity = firstCartItem.getQuantity();
//            String price = firstCartItem.getPrice();
//            String note = firstCartItem.getNote();
//        }

        CartAdapter adapter = new CartAdapter(listcart, this);
        recyclerView.setAdapter(adapter);

        AppCompatButton btnthem = findViewById(R.id.btn_themmon);
        TextView totalPrice = findViewById(R.id.totalPrice);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CartActivity.this, MenuActivity.class);
                startActivity(intent1);
            }
        });
        AppCompatButton btnthanhtoan = findViewById(R.id.btn_thanhtoan);
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem danh sách có phần tử không
                if (listcart != null && listcart.size() > 0) {
                    Cart firstCartItem = listcart.get(0);

                    // Lấy các giá trị từ firstCartItem
                    String name = firstCartItem.getFoodName();
                    String quantity = firstCartItem.getQuantity();
                    String price = firstCartItem.getPrice();
                    String note = firstCartItem.getNote();

                    // Đặt giá trị vào Intent
                    Intent intent2 = new Intent(CartActivity.this, DetailOrderActivity.class);

                    intent2.putExtra("FoodName", name);
                    intent2.putExtra("Quantity1", quantity);
                    intent2.putExtra("Price1", price);
                    intent2.putExtra("Note1", note);

                    // Log thông tin để kiểm tra
                    Log.d("CartItem", "Name: " + name);
                    Log.d("CartItem", "Quantity: " + quantity);
                    Log.d("CartItem", "Price: " + price);
                    Log.d("CartItem", "Note: " + note);

                    // Chuyển đến DetailOrderActivity với Intent đã đặt giá trị
                    startActivity(intent2);
                } else {
                    // Xử lý khi danh sách không có phần tử
                    // Ví dụ: Hiển thị thông báo, không thực hiện chuyển đến DetailOrderActivity
                }
            }
        });

        totalPrice.setText(receivedData2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
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
}
