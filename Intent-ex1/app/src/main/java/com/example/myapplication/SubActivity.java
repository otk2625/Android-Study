package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActivity";
    private FloatingActionButton fabPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        Log.d(TAG, "onCreate: " + intent.getStringExtra("username"));

        // Gson을 통해 객체 전달
        try {
            JSONObject object = new JSONObject(intent.getStringExtra("jsonuser"));
            Log.d(TAG, "onCreate: Gson전달 : "+ object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Serializable을 통해 객체 전달
        User user = (User)intent.getSerializableExtra("serialuser");
        Log.d(TAG, "onCreate: Serializable로 전달 : " +user.toString());

       // Bundle을 통해 객체 전달
        Log.d(TAG, "onCreate: Bundle로 전달 :" + intent.getBundleExtra("bundleuser").toString());

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(view -> {
            // 인증이 성공했을때 resultCode값, Intent로 데이터값 전달 가능
            Intent newIntent = new Intent();
            newIntent.putExtra("auth","ok");
            setResult(1, newIntent);
            finish(); // 현재 액티비티를 날린다!! pop
        });
    }
}