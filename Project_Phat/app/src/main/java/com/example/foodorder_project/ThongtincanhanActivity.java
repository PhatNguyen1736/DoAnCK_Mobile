package com.example.foodorder_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorder_project.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ThongtincanhanActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan);
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("Users")
//                .document("20521736") // Thay thế "20521736" bằng ID thực của document
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            DocumentSnapshot document = task.getResult();
//                            if (document.exists()) {
//                                // Document tồn tại, chuyển đổi dữ liệu thành đối tượng Users
//                                Users user = document.toObject(Users.class);
//
//                                // Lấy các TextView từ giao diện XML
//                                TextView email = findViewById(R.id.tx_email1);
//                                TextView sdt = findViewById(R.id.tx_sdt1);
//                                TextView gioitinh = findViewById(R.id.tx_gioitinh1);
//                                TextView diachi = findViewById(R.id.tx_diachigiaohang1);
//                                TextView ngaysinh = findViewById(R.id.tx_ngaysinh1);
//
//                                // Đổ dữ liệu vào TextView
//                                if (user != null) {
//                                    email.setText(user.getEmail());
//                                    sdt.setText(user.getPhone());
//                                    gioitinh.setText(user.getGender());
//                                    diachi.setText(user.getLocationID());
//                                    ngaysinh.setText(user.getDOD());
//                                }
//                            } else {
//                                // Document không tồn tại
//                                Log.d("Firestore", "No such document");
//                            }
//                        } else {
//                            // Xử lý khi có lỗi xảy ra
//                            Log.d("Firestore", "Error getting document: ", task.getException());
//                        }
//                    }
//                });

    }
}
