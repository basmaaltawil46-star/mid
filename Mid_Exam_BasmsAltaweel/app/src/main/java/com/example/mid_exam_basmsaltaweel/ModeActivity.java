package com.example.mid_exam_basmsaltaweel;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mid_exam_basmsaltaweel.databinding.ActivityModeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ModeActivity extends AppCompatActivity {
    ActivityModeBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityModeBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        MyAdapter adapter = new MyAdapter(this);
        mainBinding.viewPager.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new TabLayoutMediator(mainBinding.tabLayout,
                mainBinding.viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {

                    @Override
                    public void onConfigureTab(TabLayout.Tab tab, int position) {

                        if (position == 0) {
                            tab.setText("First");
                        } else if (position == 1) {
                            tab.setText("Second");
                        } else {
                            tab.setText("Third");
                        }
                    }
                }).attach();
        mainBinding.btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(ModeActivity.this, v);

                popup.getMenu().add("Light");
                popup.getMenu().add("Night");
                popup.getMenu().add("System");

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getTitle().equals("Light")) {

                            AppCompatDelegate.setDefaultNightMode(
                                    AppCompatDelegate.MODE_NIGHT_NO);

                        } else if (item.getTitle().equals("Night")) {

                            AppCompatDelegate.setDefaultNightMode(
                                    AppCompatDelegate.MODE_NIGHT_YES);

                        } else {

                            AppCompatDelegate.setDefaultNightMode(
                                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        }

                        return true;
                    }
                });

                popup.show();
            }
        });
    }
    @Override
    public void onBackPressed() {

        if (mainBinding.viewPager.getCurrentItem() == 0) {

            finish();

        } else {

            mainBinding.viewPager.setCurrentItem(0);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return true;
    }
}