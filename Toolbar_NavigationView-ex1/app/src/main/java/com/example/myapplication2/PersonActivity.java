package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication2.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class PersonActivity extends AppCompatActivity {

    private ImageView imgBack;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

//        imgBack = findViewById(R.id.img_back);
//        imgBack.setOnClickListener(view -> {
//            finish();
//        });

        nav = findViewById(R.id.nav);
        // 이것만 적으서 Activity에 걸어두면 거기서 동작함!
        NavigationViewHelper.enable(PersonActivity.this,nav);
    }
}