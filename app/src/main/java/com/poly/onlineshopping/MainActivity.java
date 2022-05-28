package com.poly.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.poly.onlineshopping.Fragments.GioHangFragment;
import com.poly.onlineshopping.Fragments.HomeFragment;
import com.poly.onlineshopping.Fragments.TaiKhoanFragment;
import com.poly.onlineshopping.Fragments.YeuThichFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    HomeFragment homeFragment = new HomeFragment();
    GioHangFragment gioHangFragment = new GioHangFragment();
    YeuThichFragment yeuThichFragment = new YeuThichFragment();
    TaiKhoanFragment taiKhoanFragment = new TaiKhoanFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView= findViewById(R.id.navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                        return true;
                    case R.id.nav_giohang:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,gioHangFragment).commit();
                        return true;
                    case R.id.nav_favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, yeuThichFragment).commit();
                        return true;
                    case R.id.nav_account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,taiKhoanFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }


}