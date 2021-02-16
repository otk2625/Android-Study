package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// stack 생성
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private ListView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lv_movie);

        // 어댑터 => 내장 어댑터(간단한 디자인의 리스트)
        // 어댑터 직접 만들어야 되는 경우 (커스텀 리스트 만들 때)

        List<String> mid = new ArrayList<>();
        mid.add("해리포터와 불의 잔");
        mid.add("스파이더맨3");
        mid.add("트랜스포머");
        mid.add("주식");
        mid.add("킹콩");

        // 어댑터는 화면 사이즈와 리스트의 하나의 아이템의 사이즈를 알아야하고 그다음에 데이터 컬렉션을 알아야 한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,mid);

        lvMovie.setAdapter(adapter);

        // 뒤에서 add가능
        mid.add("분노의 질주");

        //삭제 가능
        mid.remove(0);
    }


}