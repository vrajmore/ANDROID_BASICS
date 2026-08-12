package com.example.activitytestmayanksir;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "tag";
    Button frgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        frgbtn = findViewById(R.id.frgbtn);

        Toast.makeText(this, "Activity BBB     oncreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onCreate");

        FragmentManager fm = getSupportFragmentManager();
        frgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        fm.beginTransaction()
                .replace(R.id.fragmentContainerView, BlankFragment.class, null)
                .commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity BBB     onstart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity BBB     onresume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity BBB     onpause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity BBB     onstop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity BBB     ondestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY BBB     onDestroy");
    }
}