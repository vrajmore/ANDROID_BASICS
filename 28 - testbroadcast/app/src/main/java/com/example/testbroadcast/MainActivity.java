package com.example.testbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Broadcastreceivermod br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch swit = findViewById(R.id.switch1);
        Button on = findViewById(R.id.button);
        Button off = findViewById(R.id.button2);
        Button addition = findViewById(R.id.button3);
        on.setText("on");
        off.setText("off");
        addition.setText("add");

        Intent intent = new Intent();
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction("com.example.testbroadcast.ACTION1");
                intent.putExtra("switch",true);
                sendBroadcast(intent);
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction("com.example.testbroadcast.ACTION1");
                intent.putExtra("switch",false);
                sendBroadcast(intent);
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction("com.example.testbroadcast.ACTION2");
                intent.putExtra("num1", 5);
                intent.putExtra("num2", 10);
                sendBroadcast(intent);
            }
        });


        br = new Broadcastreceivermod(swit);
        IntentFilter intfi = new IntentFilter("com.example.testbroadcast.ACTION1");
        intfi.addAction("com.example.testbroadcast.ACTION2");
        registerReceiver(br,intfi);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}