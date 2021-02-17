package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// stack 생성
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private GridView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 전체 인플레이트

        lvMovie = findViewById(R.id.lv_movie);

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1,"제목" , "서브제목", R.drawable.mov01));
        movies.add(new Movie(2,"제목" , "서브제목", R.drawable.mov02));
        movies.add(new Movie(3,"제목" , "서브제목", R.drawable.mov03));
        movies.add(new Movie(4,"제목" , "서브제목", R.drawable.mov04));
        movies.add(new Movie(5,"제목" , "서브제목", R.drawable.mov05));
        movies.add(new Movie(6,"제목" , "서브제목", R.drawable.mov06));
        movies.add(new Movie(7,"제목" , "서브제목", R.drawable.mov07));
        movies.add(new Movie(8,"제목" , "서브제목", R.drawable.mov08));
        movies.add(new Movie(9,"제목" , "서브제목", R.drawable.mov09));
        movies.add(new Movie(10,"제목" , "서브제목", R.drawable.mov10));
        movies.add(new Movie(11,"제목" , "서브제목", R.drawable.mov11));
        movies.add(new Movie(12,"제목" , "서브제목", R.drawable.mov12));

        ItemAdapter adapter = new ItemAdapter(movies);

        lvMovie.setAdapter(adapter);

    }


}