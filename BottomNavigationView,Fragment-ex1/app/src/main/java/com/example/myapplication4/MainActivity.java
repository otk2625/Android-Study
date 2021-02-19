package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import info.androidhive.fontawesome.FontDrawable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this;
    private BottomNavigationView bottomNavigationView;

    public Integer num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //최초 화면
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId())  {
                case  R.id.bottom_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.bottom_setting :
                    selectedFragment = new SettingsFragment();
                    break;
                case R.id.bottom_navigation :
                    selectedFragment = new NavigationFragment();
                    break;

            }
            //fragmanet 바꿔치기
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

    }
}