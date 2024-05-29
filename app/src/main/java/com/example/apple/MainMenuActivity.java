package com.example.apple;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        bottomNavigationView = findViewById(R.id.main_menu_bottom_navigation);
        customizeBottomNavigationBar();

        frameLayout = findViewById(R.id.main_menu_frame_layout);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuItemItemId = menuItem.getItemId();

                if (menuItemItemId == R.id.bottom_navigation_dashboard) {
                    addFragment(new DashboardFragment());
                } else if (menuItemItemId == R.id.bottom_navigation_performance) {
                    addFragment(new PerformanceFragment());
                } else if (menuItemItemId == R.id.bottom_navigation_leader_board) {
                    addFragment(new LeaderboardFragment());
                } else if (menuItemItemId == R.id.bottom_navigation_practice) {
                    addFragment(new PracticeFragment());
                } else if (menuItemItemId == R.id.bottom_navigation_settings) {
                    addFragment(new SettingsFragment());
                } else {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.main_menu_frame_layout, new DashboardFragment());
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
        addFragment(new DashboardFragment());
    }

    @Override
    public void onBackPressed() {
        if (false)
            super.onBackPressed();
        finishAffinity();
        finish();
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_menu_frame_layout, fragment);
        fragmentTransaction.commit();
    }
    private void customizeBottomNavigationBar() {
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.vivid_cerise)));
    }
}