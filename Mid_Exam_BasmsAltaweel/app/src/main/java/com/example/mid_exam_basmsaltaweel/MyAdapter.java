package com.example.mid_exam_basmsaltaweel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public MyAdapter(FragmentActivity activity) {
        super(activity);
    }

    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1) {
            return new SecondFragment();
        } else {
            return new ThirdFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
