package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LichsuActivity extends Fragment {
    private TextView chitiet, chitiet1;

    @SuppressLint("MissingInflatedId")
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichsu_, container, false);

        chitiet = view.findViewById(R.id.txt_chitiet);
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getActivity(),DondahuyActivity.class);
                startActivity(intent6);
            }
        });

        chitiet1 = view.findViewById(R.id.txt_chitiet1);
        chitiet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(getActivity(), DonthanhcongActivity.class);
                startActivity(intent7);
            }
        });
        return view;
    }
}
