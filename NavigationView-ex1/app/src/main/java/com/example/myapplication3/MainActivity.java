package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication3.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity3";

    private Button btn1;
    private DrawerLayout drawer;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.nav);
        btn1 = findViewById(R.id.btn1);
        drawer = findViewById(R.id.drawer);

        btn1.setOnClickListener(view -> {
            drawer.openDrawer(GravityCompat.START);
            //drawer.openDrawer(nav);

        });

        // 이것만 적으서 Activity에 걸어두면 거기서 동작함!
        NavigationViewHelper.enable(MainActivity.this,nav);


    }
}