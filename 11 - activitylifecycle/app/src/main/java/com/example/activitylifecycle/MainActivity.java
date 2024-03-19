package com.example.activitylifecycle;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate: activity created");
        Toast.makeText(this, "activity created", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onStart() {
        super.onStart();

        Log.d("TAG", "onStart: activity started");
        Toast.makeText(this, "activity started", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("TAG", "onResume: activity resume");
        Toast.makeText(this, "activity resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("TAG", "onPause: activity pause");
        Toast.makeText(this, "activity pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("TAG", "onStop: activity stop");
        Toast.makeText(this, "activity stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("TAG", "onDestroy: activity destroy");
        Toast.makeText(this, "activity destroy", Toast.LENGTH_SHORT).show();
    }
}