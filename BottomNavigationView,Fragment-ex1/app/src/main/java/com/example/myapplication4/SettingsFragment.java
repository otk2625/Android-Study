package com.example.myapplication4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private static final String TAG = "SettingsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity at = (MainActivity)container.getContext();
        View view = inflater.inflate(R.layout.fragment_settings,container,false);

        Log.d(TAG, "onCreateView: "+at.num);
        return view;
    }
}
