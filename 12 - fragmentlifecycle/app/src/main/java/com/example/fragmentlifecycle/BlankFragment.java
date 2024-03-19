package com.example.fragmentlifecycle;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        // Called when the fragment is associated with the activity
        Log.d(TAG, "onAttach: fragment attached");
        Toast.makeText(context, "fragment attached", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Called to do initial creation of the fragment
        Log.d(TAG, "onCreate: fragment created");
        Toast.makeText(getContext(), "fragment created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Called when the activity's onCreate() method has returned
        Log.d(TAG, "onActivityCreated: on activity created");

    }

    @Override
    public void onStart() {
        super.onStart();
        // Called when the fragment becomes visible to the user
        Log.d(TAG, "onStart: fragment started");
        Toast.makeText(getContext(), "fragment started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Called when the fragment is visible and actively running
        Log.d(TAG, "onResume: fragment resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
        // Called when the fragment is no longer interacting with the user
        Log.d(TAG, "onPause: fragment paused");
    }

    @Override
    public void onStop() {
        super.onStop();
        // Called when the fragment is no longer visible to the user
        Log.d(TAG, "onStop: fragment stoped");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Called when the fragment's view is about to be destroyed
        Log.d(TAG, "onDestroyView: fragment destroyed");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Called when the fragment is no longer in use
        Log.d(TAG, "onDestroy: fragment destroyed");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // Called when the fragment is being disassociated from the activity
        Log.d(TAG, "onDetach: fragment detached");
    }


}