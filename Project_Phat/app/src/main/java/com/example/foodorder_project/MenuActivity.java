package com.example.foodorder_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.foodorder_project.Adapter.CategoryAdapter;
import com.example.foodorder_project.Model.Category;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView rclView;
    ArrayList<Category> catelist;
    CategoryAdapter cateadapter;
    FirebaseFirestore db;
//    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Fetching Data...");
//        progressDialog.show();

         rclView = findViewById(R.id.recycler_menu);
         rclView.setHasFixedSize(true);
         rclView.setLayoutManager(new LinearLayoutManager(this));

         db = FirebaseFirestore.getInstance();
         catelist = new ArrayList<>();
         cateadapter = new CategoryAdapter(MenuActivity.this, catelist);
         GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
         rclView.setLayoutManager(gridLayoutManager);
         rclView.setAdapter(cateadapter);
         EventChangeListener();




//
//        CategoryAdapter adapter = new CategoryAdapter(getListCate());
//        rclView.setAdapter(adapter);
    }

        private void EventChangeListener() {
            db.collection("Menu_Food")
                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                            if (error != null){
                                Log.e("Firestore error", error.getMessage());
                                return;
                            }

                            for (DocumentSnapshot dc: value.getDocuments()){

//                                catelist.add(dc.toObject(Category.class));
                                Category category = dc.toObject(Category.class);
                                catelist.add(category);
                                if (category != null) {
                                    String nameCategory = category.getNameCategory();
                                    Log.d("Category Name", nameCategory);
                                }
                            }
                            cateadapter.notifyDataSetChanged();
                        }
                    });
        }

//    private List<Category> getListCate() {
//        List<Category> list = new ArrayList<>();
//        list.add(new Category(R.drawable.com, "Cơm chay"));
//        list.add(new Category(R.drawable.lau, "Lẩu chay"));
//        list.add(new Category(R.drawable.bun, "Bún/Phở"));
//        list.add(new Category(R.drawable.monkhac, "Món khác"));
//        list.add(new Category(R.drawable.trangmieng, "Tráng miệng"));
//        list.add(new Category(R.drawable.anvat, "Ăn vặt"));
//
//        return list;
//
//    }
}

