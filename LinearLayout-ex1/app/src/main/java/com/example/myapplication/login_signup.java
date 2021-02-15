package com.example.myapplication;

import android.app.ProgressDialog;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class login_signup extends AppCompatActivity {
    TextView signuplogin;
    RelativeLayout signupbtn;


    //이메일 비밀번호 로그인 모듈 변수
    private FirebaseAuth mAuth;
    //현재 로그인 된 유저 정보를 담을 변수
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //이메일
        final EditText signupid = (EditText) findViewById(R.id.sign_up_id);
        //이름
        final EditText signupname = (EditText) findViewById(R.id.sign_up_name);
        //비밀번호
        final EditText signuppassword = (EditText) findViewById(R.id.sign_up_password);
        //생년월일
        final EditText signupbirth = (EditText) findViewById(R.id.sign_up_birth);


        signupbtn = findViewById(R.id.sg_btn);

        mAuth = FirebaseAuth.getInstance();
        //버튼 클릭시
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = signupid.getText().toString();
                String name = signupname.getText().toString();
                String pw = signuppassword.getText().toString();
                String birth = signupbirth.getText().toString();


                Toast.makeText(login_signup.this, "회원가입 중입니다....", Toast.LENGTH_SHORT).show();
                joinStart(id, name, pw);

            }

        });


        signuplogin = findViewById(R.id.sg_login);
        signuplogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void joinStart(String id, final String name, String password) {

        mAuth.createUserWithEmailAndPassword(id, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                Toast.makeText(login_signup.this, "비밀번호가 간단해요..", Toast.LENGTH_SHORT).show();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(login_signup.this, "email 형식에 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                            } catch (FirebaseAuthUserCollisionException e) {
                                Toast.makeText(login_signup.this, "이미존재하는 email 입니다.", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(login_signup.this, "다시 확인해주세요..", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            currentUser = mAuth.getCurrentUser();

                            Toast.makeText(login_signup.this, "가입 성공  " + name + currentUser.getEmail() + "/" + currentUser.getUid(), Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(login_signup.this, MainActivity.class));
                            finish();

                        }
                    }
                });


    }
}
