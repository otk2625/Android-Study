package com.cos.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinActivity extends AppCompatActivity {
    private static final String TAG = "JoinActivity";

    private FirebaseAuth mAuth;

    private TextInputEditText teEmail;
    private TextInputEditText tePassword;
    private MaterialButton btnJoin;
    private LinearLayout joinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance(); // 초기화

        teEmail = findViewById(R.id.te_email);
        tePassword = findViewById(R.id.te_password);
        btnJoin = findViewById(R.id.btn_join);
        joinLayout = findViewById(R.id.join_layout);

        btnJoin.setOnClickListener(view -> {
            String email = teEmail.getText().toString().trim(); // 공백 날려주기!
            String password = tePassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this,task -> {
                if(task.isSuccessful()){ // 통신 성공이라면
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d(TAG, "onCreate: user : " + user.getEmail());

                    Intent intent = new Intent(JoinActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    Log.d(TAG, "onCreate: 로그인 실패"+ task.getException());
                    Snackbar.make(joinLayout,"로그인 실패", Snackbar.LENGTH_SHORT).show();
                }
            });
        });

    }
}