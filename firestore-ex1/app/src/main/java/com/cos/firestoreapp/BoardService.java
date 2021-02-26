package com.cos.firestoreapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BoardService {
    private static final String TAG = "BoardService2";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();



    public void boardDetail(MyCallBack myCallback){

        BoardDetail dto = new BoardDetail();
        DocumentReference docRef = db.collection("board").document("yHkPQ5WVAyjbNJ4LJlwk");

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Board board = task.getResult().toObject(Board.class);
                        String userId = board.getUserId();

                        dto.setBoard(board);

                        /////////////////////////////////////////////////////////////////////
                        DocumentReference docRef = db.collection("users").document(userId);
                        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        User user = task.getResult().toObject(User.class);

                                        dto.setUser(user);
                                        myCallback.back(dto);

                                        //Log.d(TAG, "dto " + dto);
                                    } else {
                                        //Log.d(TAG, "No such document");
                                    }
                                } else {
                                    //Log.d(TAG, "get failed with ", task.getException());
                                }
                            }
                        });
                        /////////////////////////////////////////////////////////////////////



                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        //Log.d(TAG, "No such document");
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }


    public void boardAll(){
        db.collection("board")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        //List<User> users = task.getResult().toObjects(User.class);
                        List<Board> boards = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Board board = document.toObject(Board.class);
                                board.setId(document.getId()); //이런식으로 문서 id값을찾아서 List에 뿌려준다
                                Log.d(TAG, "onComplete: board : " + board);
                                boards.add(board);
                            }
                            Log.d(TAG, "onComplete: boards" + boards);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public void addTest(){
        // 1 uid를 만들어서 그걸 넣기
        UUID uuid = UUID.randomUUID();

        User user = new User("1","Test","1234","0107777");

        db.collection("users")
                .document("1")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public void readTest(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        //List<User> users = task.getResult().toObjects(User.class);
                        List<User> users = new ArrayList<>();

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                User user = document.toObject(User.class);
                                user.setId(document.getId()); //이런식으로 문서 id값을찾아서 List에 뿌려준다
                                Log.d(TAG, "onComplete: user : " + user);
                                users.add(user);
                            }
                            Log.d(TAG, "onComplete: user" + users);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    // 부분 update
    public void dbUpdate(){
        DocumentReference washingtonRef = db.collection("users").document("udzxAZtmBTqzTuJepU03");

        washingtonRef
                .update("phone", "0108888")
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });
    }

    // 전부 update
    public void dbSaveOrUpdate(){
        User user = new User(null,"cos","1234","0102222");

        db.collection("users").document("udzxAZtmBTqzTuJepU03")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    // 데이터 삽입
    public void dbSave(User user1){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("username", user1.getUsername());
        user.put("password", user1.getPassword());
        user.put("phone", user1.getPhone());

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    // SelectAll
    public void dbReadAll(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Log.d(TAG, "onComplete: "+document.getData().get("password"));

                            }

                            List<User> users = task.getResult().toObjects(User.class);
                            Log.d(TAG, "onComplete: users : "+users);
                            // user를 어뎁터에 던지면 됨
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
