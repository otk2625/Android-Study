package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private TabLayout tabs;
    private ViewPager vpContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabLayout은 메뉴.xml이 없음
        tabs = findViewById(R.id.tabs);
        vpContainer = findViewById(R.id.vp_container);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),1);
        myFragmentPagerAdapter.addFragment(new Frag1());
        myFragmentPagerAdapter.addFragment(new Frag2());
        myFragmentPagerAdapter.addFragment(new Frag3());

        vpContainer.setAdapter(myFragmentPagerAdapter);

        // tab이랑 연결
        tabs.setupWithViewPager(vpContainer);

        // tab에 아이템 그리기
        tabs.getTabAt(0).setText("1").setIcon(R.drawable.ic_android_black_24dp);
        tabs.getTabAt(1).setText("2").setIcon(R.drawable.ic_android_black_24dp);
        tabs.getTabAt(2).setText("3").setIcon(R.drawable.ic_android_black_24dp);
    }
}