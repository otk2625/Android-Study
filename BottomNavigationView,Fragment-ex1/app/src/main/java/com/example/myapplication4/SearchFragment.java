package com.example.myapplication4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SearchFragment extends Fragment {

    private TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity at = (MainActivity)container.getContext();
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        at.num = 1;

        // 여기서 각 프레그먼드의 어떤 데이터를 설정가능
        tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("Fragment Search");

        return view;
    }
}
