package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNoteList;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Note> notes = new ArrayList<>();

        notes.add(new Note(1,"해리포터와 비밀의 방", "이것은 해리포터이야기",15));
        notes.add(new Note(2,"해리포터와 비밀의 방", "이것은 해리포터이야기",16));
        notes.add(new Note(3,"해리포터와 비밀의 방", "이것은 해리포터이야기",1));
        notes.add(new Note(4,"해리포터와 비밀의 방", "이것은 해리포터이야기",5));
        notes.add(new Note(5,"해리포터와 비밀의 방", "이것은 해리포터이야기",156));
        notes.add(new Note(6,"해리포터와 비밀의 방", "이것은 해리포터이야기",78));
        notes.add(new Note(7,"해리포터와 비밀의 방", "이것은 해리포터이야기",16));
        notes.add(new Note(8,"해리포터와 비밀의 방", "이것은 해리포터이야기",54));
        notes.add(new Note(9,"해리포터와 비밀의 방", "이것은 해리포터이야기",38));
        notes.add(new Note(10,"해리포터와 비밀의 방", "이것은 해리포터이야기",79));
        notes.add(new Note(11,"해리포터와 비밀의 방", "이것은 해리포터이야기",77));
        notes.add(new Note(12,"해리포터와 비밀의 방", "이것은 해리포터이야기",12));


        LinearLayoutManager manger = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rvNoteList = findViewById(R.id.rv_note_list);
        rvNoteList.setLayoutManager(manger);

        noteAdapter = new NoteAdapter(notes);

        rvNoteList.setAdapter(noteAdapter);

    }
}