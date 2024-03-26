package com.example.looperthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startthread, stopthread, asigntask;
    TextView text1;
    private Mylooper ml = new Mylooper();
    private static final String TAG = "Mylooper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startthread = findViewById(R.id.startthread);
        stopthread = findViewById(R.id.stopthread);
        asigntask = findViewById(R.id.asigntask);
        text1 = findViewById(R.id.textView);
        text1.setText("waiting ...");


        startthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ml.start();
                Toast.makeText(MainActivity.this, "thread started"+ml.getName()+ml.getState(), Toast.LENGTH_SHORT).show();
            }
        });
        stopthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ml.handler.getLooper().quit();
                Toast.makeText(MainActivity.this, "thread stoped"+ml.getName()+ml.getState(), Toast.LENGTH_SHORT).show();

            }
        });

        asigntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ml.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: runnable in thread looper");
                        for (int i = 0; i < 11; i++) {
                            Log.d(TAG, "run: "+i);
                            SystemClock.sleep(1000);

                        }
                    }
                });
            }
        });
    }
}