package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication3.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class SubActivity extends AppCompatActivity {

    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        nav = findViewById(R.id.nav);

        NavigationViewHelper.enable(SubActivity.this,nav);
    }
}