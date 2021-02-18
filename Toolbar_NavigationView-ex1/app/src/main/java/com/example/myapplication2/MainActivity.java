package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.helper.NavigationViewHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Toolbar toolbarMain;
    private TextView tvAndroid;
    private ImageView ivMmenu;
    private DrawerLayout drawer;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        tvAndroid = findViewById(R.id.tv_android);
        tvAndroid.setOnClickListener(view -> {
            Intent intent = new Intent(this, PersonActivity.class);
            startActivity(intent);
        });

        drawer = findViewById(R.id.drawer);
        nav = findViewById(R.id.nav);
        ivMmenu = findViewById(R.id.iv_menu);
        ivMmenu.setOnClickListener(view -> {
            drawer.openDrawer(GravityCompat.START);
        });


        // 이것만 적으서 Activity에 걸어두면 거기서 동작함!
        NavigationViewHelper.enable(MainActivity.this,nav);

    }
}