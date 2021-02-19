package com.example.myapplication4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView rvChatList;
    private RecyclerView.LayoutManager chatLayoutManager;
    private ChatAdapter chatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        List<Chatting> chattings = new ArrayList<>();

        for (int i=0; i<20; i++){
            chattings.add(new Chatting("user","내용 무","1시간전" ));
        }

        View view = inflater.inflate(R.layout.fragment_chat,container,false);
        rvChatList = (RecyclerView) view.findViewById(R.id.rv_chat_list);

        chatLayoutManager = new LinearLayoutManager(getActivity());
        rvChatList.setLayoutManager(chatLayoutManager);

        chatAdapter = new ChatAdapter(chattings);
        rvChatList.setAdapter(chatAdapter);

        return view;
    }
}
