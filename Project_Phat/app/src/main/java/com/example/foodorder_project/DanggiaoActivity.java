package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;

import java.util.ArrayList;

public class DanggiaoActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    TextView btndanggiao;
    TextView tongtien, thanhtien, soluong, ngaydat;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdonhang_danggiao);

        recyclerView = findViewById(R.id.recycle_giao);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));



        btndanggiao = findViewById(R.id.btn_nhanduocmon);
        btndanggiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanggiaoActivity.this, GiaothanhcongActivity.class);
                startActivity(intent);
            }
        });
        String price = null;
        String date = null;
        Intent intent = getIntent();
        if (intent != null) {
            String quantity = intent.getStringExtra("quantity");
            price = intent.getStringExtra("price");
            String status = intent.getStringExtra("status");
            String arrivalTime = intent.getStringExtra("arrivalTime");
            String paymentMethod = intent.getStringExtra("paymentMethod");
            date = intent.getStringExtra("createDate");

            listfood = new ArrayList<Xacnhan>();
            listfood.add(new Xacnhan(R.drawable.comhaplasen1, "Cơm hấp lá sen", "Size M", quantity, price));
        }
        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

        tongtien = findViewById(R.id.txt_giatong);
        thanhtien = findViewById(R.id.txt_giathanhtien);
        soluong = findViewById(R.id.txt_soluongtong);
        ngaydat = findViewById(R.id.ngaydat);
        tongtien.setText(price);
        ngaydat.setText(date);
        char firstChar = price.charAt(0); // Lấy ký tự đầu tiên
        String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
        soluong.setText(firstCharString);
        thanhtien.setText(price);
    }
}
