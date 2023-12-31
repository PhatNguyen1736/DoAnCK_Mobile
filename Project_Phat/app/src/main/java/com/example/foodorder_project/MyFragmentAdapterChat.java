package com.example.foodorder_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapterChat extends FragmentStateAdapter {


    public MyFragmentAdapterChat(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0)
        {
            return new ChatShipper();
        }
        return new ChatNhaHang();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
