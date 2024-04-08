package com.example.activitytestmayanksir;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class BlankFragment extends Fragment {
    private static final String TAG = "tag";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "FRAGMENT     onattach", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "FRAGMENT     oncreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "FRAGMENT     onviewcreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "FRAGMENT     onstart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "FRAGMENT     onresume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "FRAGMENT     onpause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "FRAGMENT     onstop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "FRAGMENT     ondestroyview", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "FRAGMENT     ondestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "FRAGMENT     ondetach", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FRAGMENT     onDetach");
    }

}