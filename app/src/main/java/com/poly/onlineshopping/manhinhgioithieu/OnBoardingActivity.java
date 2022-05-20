package com.poly.onlineshopping.manhinhgioithieu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.activity.LoginActivity;

import me.relex.circleindicator.CircleIndicator;

public class OnBoardingActivity extends AppCompatActivity {

    TextView tv_skip;
    ViewPager viewPager;
    Button btn_next;
    CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding2);
        tv_skip = findViewById(R.id.tv_skip);
        viewPager = findViewById(R.id.viewpager);
        btn_next = findViewById(R.id.btn_next);
        circleIndicator = findViewById(R.id.circleindicator);

        //set viewpager
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        viewPager.setAdapter(viewPagerAdapter);
        //set circleIndicator
        circleIndicator.setViewPager(viewPager);

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //neu viewpager ma < 2 thi lay viewpage hien tai + them 1
                if (viewPager.getCurrentItem()<2){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                } else {
                    Intent intent = new Intent(OnBoardingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }
            }
        });
    }
}