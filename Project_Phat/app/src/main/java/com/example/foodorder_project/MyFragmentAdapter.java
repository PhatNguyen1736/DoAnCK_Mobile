package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
         if(position == 1)
         {
             return new Lichsu_Fragment();
         }
         return new Hientai_Fragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class icon_cai_chuongActivity extends AppCompatActivity {
        @SuppressLint("MissingInflatedId")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.icon_cai_chuong);
            LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);
            myLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển từ trang icon cai chuong sang trang voucher khi nhấn vào LinearLayout
                    Intent intent = new Intent(icon_cai_chuongActivity.this, voucherggActivity.class);
                    startActivity(intent);
                }
            });
            LinearLayout myLinearLayouttintucnhahang = findViewById(R.id.myLinearLayouttintucnhahang);
            myLinearLayouttintucnhahang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển từ trang icon cai chuong sang trang tin tức nhà hàng khi nhấn vào LinearLayout
                    Intent intent = new Intent(icon_cai_chuongActivity.this, tintucnhahangActivity.class);
                    startActivity(intent);
                }
            });

            LinearLayout myLinearLayoutkhuyenmai = findViewById(R.id.myLinearLayoutkhuyenmai);
            myLinearLayoutkhuyenmai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển từ trang icon cai chuong sang trang tin tức nhà hàng khi nhấn vào LinearLayout
                    Intent intent = new Intent(icon_cai_chuongActivity.this, khuyenmaiActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
