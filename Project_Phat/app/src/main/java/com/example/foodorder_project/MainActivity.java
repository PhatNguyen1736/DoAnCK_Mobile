package com.example.foodorder_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//       // Tạo danh sách thông tin đơn hàng
//        ArrayList<String> orderInfoList = new ArrayList<>();
//        orderInfoList.add("Đơn hàng 2310JK\nĐơn hàng hiện đang trên đường giao đến bạn. Hãy chú ý theo dõi đơn hàng. Nhà hàng Tuệ Duyên xin cảm ơn!");
//        orderInfoList.add("Đơn hàng 2308JK\nĐơn hàng đã giao thành công. Bạn hãy để lại đánh giá cho món ăn để chúng tôi có thể cải thiện chất lượng món ăn và khách hàng khác có thể hiểu thêm về món ăn nhé!");
//
//        // Tạo ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderInfoList);
//
//        // Liên kết ArrayAdapter với ListView
//        ListView listView = findViewById(R.id.infoListView);
//        listView.setAdapter(adapter);

    }
}