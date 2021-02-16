package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이전에는  R.id.pgb_loading 이 null이 된다
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트
        // 이후에
        // pgb_loading은 실행시에 메모리에 뜸.
        // 실행전에 컴파일시에 틀이 저것들을 R에 등록해줌
        mProgressBar = findViewById(R.id.pgb_loading);

        download(); // 3초 = UI스레드

    }

    private void download(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // Alt + 엔터
                    // 다운로드 완료 , 스프링 서버 요청 응답의 결과
                    mProgressBar.setVisibility(View.INVISIBLE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



}