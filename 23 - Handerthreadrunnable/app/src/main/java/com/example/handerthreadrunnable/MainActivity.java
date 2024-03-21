package com.example.handerthreadrunnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "thread name - "+ Thread.currentThread(), Toast.LENGTH_SHORT).show();
                Log.d("TAG", "run: thread name"+Thread.currentThread());
                Toast.makeText(MainActivity.this, "Thread will be blocked - you can not use UI as thread is running for 10 seconds"+"this thread is - "+Thread.currentThread(), Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(MainActivity.this, "thread continoue to work - now you can use UI", Toast.LENGTH_LONG).show();
            }
        };
        Handler handler = new Handler();
        handler.post(runnable);


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "run: new thread running and you will still be able to use ui , thread running for 10 seconds");
                Log.d("TAG", "run: this and main thread is running in parallel");
                Log.d("TAG", "run: thread name"+Thread.currentThread());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Log.d("TAG", "run: new thread over");
            }
        };
        Thread thread = new Thread(runnable1);
        thread.start();
    }
}