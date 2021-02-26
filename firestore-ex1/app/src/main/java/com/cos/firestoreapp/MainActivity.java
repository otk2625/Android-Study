package com.cos.firestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User(null,"xorud012","1234","0103333");

        //dbSave(user);
        //dbReadAll();
        //dbSaveOrUpdate();
        //dbUpdate();

        //readTest();

        //화면에 뿌릴예정
        //boardAll();

        BoardService boardService = new BoardService();
        // 원래는 동작하는 스레드가 하나라서 board를 return하는게 어렵다
        // 하지만 interface로 callback을만들어서 dto를 return해서 뿌려줄 수 있다
        boardService.boardDetail(new MyCallBack<BoardDetail>() {
            @Override
            public void back(BoardDetail dto) {
                Log.d(TAG, "back: dto :" +dto);
            }
        });
    }



}