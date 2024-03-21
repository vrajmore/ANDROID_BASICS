package com.example.custombroadcastsend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button send;
    Switch aswitch;
    boolean putbroadcast = true;
    Receivermodule rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.button);
        aswitch = findViewById(R.id.switch1);
        send.setText("send broadcast");

        // used for sending custom broadcast using button
        Intent custbroadcast = new Intent("com.example.custombroadcastsend.CUSTOM_ACTION");
//        custbroadcast.putExtra("message",true);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (putbroadcast){
                    custbroadcast.putExtra("message",true);
                    putbroadcast = false;
                }
                else {
                    custbroadcast.putExtra("message", false);
                    putbroadcast = true;
                }
                sendBroadcast(custbroadcast);
            }
        });



        // code for receiving the broadcast send by the custom broadcast send above
        rec = new Receivermodule(aswitch);
        IntentFilter recbroad = new IntentFilter("com.example.custombroadcastsend.CUSTOM_ACTION");
        registerReceiver(rec, recbroad);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(rec);
    }
}