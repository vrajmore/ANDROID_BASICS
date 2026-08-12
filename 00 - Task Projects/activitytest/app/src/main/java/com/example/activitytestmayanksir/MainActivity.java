package com.example.activitytestmayanksir;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    Button btn;





    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn);
        Toast.makeText(this, "Activity AAA     oncreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onCreate");

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity AAA     onstart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity AAA     onresume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity AAA     onpause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity AAA     onstop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity AAA     ondestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ACTIVITY AAA     onDestroy");
    }
}
