package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.CartAdapter;
import com.example.foodorder_project.Adapter.MenuChitiet_Adapter;
import com.example.foodorder_project.Model.MenuChitiet;

import java.util.ArrayList;

public class MenuChitiet_Activity extends AppCompatActivity {
    ArrayList<MenuChitiet> listmenu;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_chitiet);

        recyclerView = findViewById(R.id.recycleview_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        listmenu = new ArrayList<MenuChitiet>();
        listmenu.add(new MenuChitiet("4.9",R.drawable.heart,R.drawable.lauthai,"Lẩu thái","100000"));
        listmenu.add(new MenuChitiet("4.8",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 1","99000"));
        listmenu.add(new MenuChitiet("4.7",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 2","88000"));
        listmenu.add(new MenuChitiet("4.6",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 3","77000"));
        listmenu.add(new MenuChitiet("4.5",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 4","66000"));
        listmenu.add(new MenuChitiet("4.4",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 5","55000"));

        MenuChitiet_Adapter adapter = new MenuChitiet_Adapter(listmenu,this);
        recyclerView.setAdapter(adapter);
    }

}
