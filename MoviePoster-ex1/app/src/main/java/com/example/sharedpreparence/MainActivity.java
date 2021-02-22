package com.example.sharedpreparence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovieList;
    private MovieAdapter movieAdapter;
    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        List<Movie> movies = download();
        movieAdapter = new MovieAdapter(movies);
        rvMovieList.setAdapter(movieAdapter);

    }

    private void init(){
        GridLayoutManager manger = new GridLayoutManager(this, 3);
        rvMovieList = findViewById(R.id.rv_movie_list);
        rvMovieList.setLayoutManager(manger);
    }

    // 가짜 다운로드
    private List<Movie> download(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, R.drawable.mov01));
        movies.add(new Movie(2, R.drawable.mov02));
        movies.add(new Movie(3, R.drawable.mov03));
        movies.add(new Movie(4, R.drawable.mov04));
        movies.add(new Movie(5, R.drawable.mov05));
        movies.add(new Movie(6, R.drawable.mov06));
        movies.add(new Movie(7, R.drawable.mov07));
        movies.add(new Movie(8, R.drawable.mov08));
        movies.add(new Movie(9, R.drawable.mov09));
        movies.add(new Movie(10, R.drawable.mov10));
        movies.add(new Movie(11, R.drawable.mov11));
        movies.add(new Movie(12, R.drawable.mov12));

        return movies;
    }
}