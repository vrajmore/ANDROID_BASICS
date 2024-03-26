package com.example.runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textview);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "run on ui thread", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "this thread is - "+Thread.currentThread(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "these thread can update UI", Toast.LENGTH_SHORT).show();

                        text1.setText("run on ui thread");
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        text1.setText("these thread can update UI");
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        text1.setText("this thread is - "+Thread.currentThread());
                    }
                });
                
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}