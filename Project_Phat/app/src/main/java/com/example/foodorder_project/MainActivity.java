package com.example.foodorder_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private RelativeLayout dangvanchuyen;

    @SuppressLint("MissingInflatedId")
    private RecyclerView rclView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinhanhnhahang);
//        ANH NGUYEN
       // Tạo danh sách thông tin đơn hàng
//        ArrayList<String> orderInfoList = new ArrayList<>();
//        orderInfoList.add("Đơn hàng 2310JK\nĐơn hàng hiện đang trên đường giao đến bạn. Hãy chú ý theo dõi đơn hàng. Nhà hàng Tuệ Duyên xin cảm ơn!");
//        orderInfoList.add("Đơn hàng 2308JK\nĐơn hàng đã giao thành công. Bạn hãy để lại đánh giá cho món ăn để chúng tôi có thể cải thiện chất lượng món ăn và khách hàng khác có thể hiểu thêm về món ăn nhé!");
//
        // Tạo ArrayAdapterns
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderInfoList);

//        // Liên kết ArrayAdapter với ListView
//        ListView listView = findViewById(R.id.infoListView);
//        listView.setAdapter(adapter);

//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager2 = findViewById(R.id.viewPager);
//        //dangvanchuyen = findViewById(R.id.frameLayout);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Hiện tại"));
//        tabLayout.addTab(tabLayout.newTab().setText("Lịch sử"));
//
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        MyFragmentAdapter adapter = new MyFragmentAdapter(fragmentManager, getLifecycle());
//        viewPager2.setAdapter(adapter);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager2.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        });

    }
    public void onLocationImageClick(View view) {
        // Chuyển sang trang chondiachi khi click vào ImageView
        Intent intent = new Intent(this, GoogleMapActivity.class);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Nhận tên địa chỉ từ Intent và hiển thị trong EditText
                String selectedAddress = data.getStringExtra("selectedAddress");
                if (selectedAddress != null) {
                    EditText editDiachichitiet = findViewById(R.id.edit_diachichitiet);
                    editDiachichitiet.setText(selectedAddress);
                }
            }
        }
    }
}