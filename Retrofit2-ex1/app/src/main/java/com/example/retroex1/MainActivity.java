package com.example.retroex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private RecyclerView postList;
    private PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostApi postApi = PostApi.retrofit.create(PostApi.class);
        Call<List<Post>> call = postApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                Log.d(TAG, "onResponse: " +posts); // 어댑터에 던지기 + NotifiyChanged

                LinearLayoutManager manger = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,false);
                postList = findViewById(R.id.post_list);
                postList.setLayoutManager(manger);

                postAdapter = new PostAdapter();
                postAdapter.setPosts(posts);

                postList.setAdapter(postAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");
            }
        });
    }
}