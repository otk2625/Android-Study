package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout RelativeLayout_login;
    EditText login_ID,login_Password;
    TextView loginsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_ID = findViewById(R.id.login_ID);
        login_Password = findViewById(R.id.login_Password);

        RelativeLayout_login = findViewById(R.id.RelativeLayout_login);
        loginsignup = findViewById(R.id.login_signup);

        loginsignup.setClickable(true);
        loginsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login_signup.class);
                startActivity(intent);
            }//회원가입
        });

        RelativeLayout_login.setClickable(true);
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_ID.getText().toString();
                String password = login_Password.getText().toString();

                Intent intent = new Intent(getApplicationContext(), login_result.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }//로그인
        });

    }
}
