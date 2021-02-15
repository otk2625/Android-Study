package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class login_signup1 extends AppCompatActivity {
    TextView signuplogin;
    RelativeLayout signupbtn;



    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //이메일
        final EditText signupid = findViewById(R.id.sign_up_id);
        //이름
        final EditText signupname =  findViewById(R.id.sign_up_name);
        //비밀번호
        final EditText signuppassword = findViewById(R.id.sign_up_password);
        //생년월일
        final EditText signupbirth = findViewById(R.id.sign_up_birth);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        signupbtn = findViewById(R.id.sg_btn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = signupid.getText().toString();
                String name = signupname.getText().toString();
                String pw = signuppassword.getText().toString();
                String birth = signupbirth.getText().toString();

                HashMap result = new HashMap<>();
                result.put("name", name);
                result.put("pw", pw);
                result.put("birth", birth);


                Toast.makeText(login_signup1.this, "회원가입 중입니다....", Toast.LENGTH_SHORT).show();
                writeNewUser(id, pw, name, birth);

            }

        });





    }
    private void writeNewUser(String id, String pw, String name, String birth) {
        userDTO user = new userDTO(id,pw,name,birth);

        mDatabase.child("users").child(id).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Toast.makeText(login_signup1.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(login_signup1.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
