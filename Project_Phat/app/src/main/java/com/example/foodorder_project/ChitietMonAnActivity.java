package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodorder_project.Model.MenuChitiet;

public class ChitietMonAnActivity extends AppCompatActivity {
    MenuChitiet data;

    TextView namefood, soluong, Foodprice, total;
    ImageView addCart;
    ImageView add , subtract;
    int count = 1;
    RadioGroup radioGroup;
    RadioButton small, medium, large;
    int customPizzaPrice;
    int amount = 1;
    int originalPrice;
    private int quantity = 1;
    private int basePrice = 110000;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);
        soluong = findViewById(R.id.val);
        total = findViewById(R.id.total);
        radioGroup = findViewById(R.id.radgroup);
        addCart = findViewById(R.id.add);
        namefood = findViewById(R.id.name);

        // Set initial quantity and total price
        soluong.setText(String.valueOf(quantity));
        updateTotalPrice();

        // Set click listeners for the increment and decrement buttons
        ImageView inc = findViewById(R.id.inc);
        ImageView dec = findViewById(R.id.dec);

        inc.setOnClickListener(v -> incrementQuantity());
        dec.setOnClickListener(v -> decrementQuantity());

        // Set a listener for radio button changes
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Gọi phương thức cập nhật giá trị tổng khi có sự thay đổi RadioButton được chọn
                updateTotalPrice();
            }
        });
        ImageView imgFood = findViewById(R.id.img_food);
        EditText note = findViewById(R.id.edit_note);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ Activity A và chuyển sang Activity B

                    Intent intent = new Intent(ChitietMonAnActivity.this, CartActivity.class);
//                    intent.putExtra("Image", imagePath);
                    intent.putExtra("Name", String.valueOf(namefood.getText()));
                    intent.putExtra("Quality", String.valueOf(soluong.getText()));
                    intent.putExtra("Price", String.valueOf(total.getText()));
                    intent.putExtra("Note", String.valueOf(note.getText()));
                    startActivity(intent);
            }
        });
    }

    private void incrementQuantity() {
        quantity++;
        soluong.setText(String.valueOf(quantity));
        updateTotalPrice();
    }

    private void decrementQuantity() {
        if (quantity > 1) {
            quantity--;
            soluong.setText(String.valueOf(quantity));
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        int selectedSizePrice = 0;
        int checkedId = radioGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.radS) {
            // No price change for Size S
        } else if (checkedId == R.id.radM) {
            selectedSizePrice = 50000;
        } else if (checkedId == R.id.radL) {
            selectedSizePrice = 80000;
        }

        int totalPrice = quantity * basePrice + selectedSizePrice;
        total.setText(String.valueOf(totalPrice) + "đ");
    }
}
//        data = getIntent().getParcelableExtra("foodData");
//        customPizzaPrice = getIntent().getIntExtra("CustomFoodPrice", 50);

//        amount = data.getPrice();
//
//        Foodprice = findViewById(R.id.price);
//
//        add = findViewById(R.id.inc);
//        subtract = findViewById(R.id.dec);
//        soluong = findViewById(R.id.val);
//
//        small = findViewById(R.id.radS);
//        large = findViewById(R.id.radL);
//        medium = findViewById(R.id.radM);
//
//        addCart = findViewById(R.id.add);
//        radioGroup = findViewById(R.id.radgroup);
//
//        originalPrice = data.getPrice();

//        if (data.getFoodName().equalsIgnoreCase("Custom")) {
//            amount = customPizzaPrice;
//            Foodprice.setText("Rs " + amount);
//        } else {
//            amount = data.getPrice();
//            Foodprice.setText("" + amount);
//        }
        //--------------------------------------------------------------------------------------------------
//        subtract.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (count >= 2) {
//                    count = count - 1;
//                    soluong.setText(String.valueOf(count));
//                    Foodprice.setText( doCheckSelectionForSubtract(count));
//                } else {
//                    Toast.makeText(ChitietMonAnActivity.this, "Select at least one item", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        //--------------------------------------------------------------------------------------------------
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                count = count + 1;
////                Foodprice.setText(String.valueOf(count));
//
//                Foodprice.setText(String.valueOf(count));
//                String s = doCheckSelectionForAdd(count);
//                Foodprice.setText(s);
//            }
//        });
//
//        addCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String price = Foodprice.getText().toString().trim();
////                Toast.makeText(ChitietMonAnActivity.this, "Ordered successfully", Toast.LENGTH_SHORT).show();
////                Intent i = new Intent(ChitietMonAnActivity.this, CartActivity.class);
////                i.putExtra("foodData", (CharSequence) data);
////                i.putExtra("CustomPizzaPrice", customPizzaPrice);
////                i.putExtra("price", price);
////
////                startActivity(i);
//            }
//        });
////        mName.setText(data.getFoodName());
////        Glide.with(this).load(data.getImage()).into(pizzaImg);
////--------------------------------------------------------------------------------------------------
//        small.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    Foodprice.setText("" + amount * count);
//                }
//
//            }
//        });
//        large.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    int temp = amount + 50;
//                    Foodprice.setText("" + temp * count);
//                }
//            }
//        });
//
//        medium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    int temp = amount + 30;
//                    Foodprice.setText("" + temp * count);
//                }
//            }
//        });
//        Log.d("ChitietMonAnActivity", "onCreate: data.getFoodName() = " + data.getFoodName());
//        Log.d("ChitietMonAnActivity", "onCreate: customPizzaPrice = " + customPizzaPrice);

//    private String doCheckSelectionForAdd(int count) {
//        if (small.isChecked()) {
//            return "" + (amount * count);
//        } else if (medium.isChecked()) {
//            return "" + ((amount + 30) * count);
//        } else if (large.isChecked()) {
//            return "" + ((amount + 50) * count);
//        }
//        return amount + "";
//    }
//    private String doCheckSelectionForSubtract(int count) {
//        if (small.isChecked()) {
//            return "" + (amount * count);
//        } else if (medium.isChecked()) {
//            return "" + ((amount + 30) * count);
//        } else if (large.isChecked()) {
//            return "" + ((amount + 50) * count);
//        }
//        return amount + "";
//    }
