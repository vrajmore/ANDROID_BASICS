package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Myreceiver Myreceiver = new Myreceiver();

        // Register the BroadcastReceiver for Airplane mode changes
        IntentFilter filterAirplaneMode = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(Myreceiver, filterAirplaneMode);

        // Register the BroadcastReceiver for Screen Off events
        IntentFilter filterScreenOff = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(Myreceiver, filterScreenOff);
        IntentFilter filterScreenOnn = new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(Myreceiver, filterScreenOnn);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Myreceiver Myreceiver = new Myreceiver();
        // Unregister the BroadcastReceiver when the activity is destroyed
        unregisterReceiver(Myreceiver);
    }
}