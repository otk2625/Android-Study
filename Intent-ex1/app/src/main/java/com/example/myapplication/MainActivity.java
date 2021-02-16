package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

// stack 생성
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);

        fabRoute = findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(view -> {
            // Intnent 개념
            // 1. 현재 내화면, 이동할 화면
            // 2. 현재 내화면, 내부앱의 이동할 화면
            //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777")); // 전화거는 화면으로 화면 제공
            // Intent는 트럭! (현재 내 위치정보, 이동할 위치정보, 이동할떄 가져갈 박스)
            // 다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)

            // 전달할 객체
            User user = new User();
            user.setId(1);
            user.setUsername("cos");
            user.setPassword("1234");

            // 화면 이동시 값 전달
            Intent intent = new Intent(mContext, SubActivity.class);
            intent.putExtra("username", "ssar");

            // 객체 전달하는법!!
            // 1. gson으로 json변환해서 putExtra로 넘기고 gson으로 자바 오브젝트
            Gson gson = new Gson();
            intent.putExtra("jsonuser",  gson.toJson(user));

            // 2. serializable
            intent.putExtra("serialuser",user);

            // 3. Bundle (택배박스)
            Bundle bundle = new Bundle();
            bundle.putSerializable("user",user);
            intent.putExtra("bundleuser",bundle);

            //화면 이동
            //startActivity(intent);

            startActivityForResult(intent,300);
        });
        


    }

    // SubActivity에서 finish() 함수 될때 콜백
    // setResult() 함수의 파라메터가 전달됨
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: 실행됨");
        Log.d(TAG, "requestCode: "+ requestCode);
        Log.d(TAG, "resultCode: " + resultCode);

        // Window가 무엇인지? AlertDialog사용
        if (requestCode == 300){ //서브 액티비티에서 돌아왔다
            if(resultCode == 1){ // 로직 성공
                //Toast.makeText(mContext, "인증 성공함 : "+data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout,"인증성공함", BaseTransientBottomBar.LENGTH_LONG).show();
            }else { // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}