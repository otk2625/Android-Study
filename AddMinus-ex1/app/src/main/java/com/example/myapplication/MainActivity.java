package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd,btnMinus;
    private TextView tvNum;
    private Integer num;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init(); //여기서 findViewById해준다
        initSetting();
        initListener();

    }

    private void init(){
        // 이걸 안쓸 수 있다!! 라이브러리 사용 => 버터나이프, 데이터 바인딩 등
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        tvNum = findViewById(R.id.tv_num);
    }

    private void initSetting(){
        num = 1;
        tvNum.setText(num.toString());
    }
    
    private void initListener(){
        btnAdd.setOnClickListener(view -> {
            Log.d(TAG, "initListener: ");
            num = num + 1;
            tvNum.setText(num.toString());
        });

        btnMinus.setOnClickListener(view -> {
            num = num - 1;
            tvNum.setText(num.toString());
        });
    }
}