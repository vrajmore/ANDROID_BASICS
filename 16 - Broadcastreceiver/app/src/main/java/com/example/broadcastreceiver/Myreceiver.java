package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Handler;

public class Myreceiver extends BroadcastReceiver {
    Handler handler;

    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "broadcast received", Toast.LENGTH_SHORT).show();


        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            if (isAirplaneModeOn) {
                Toast.makeText(context, "Airplane mode is ON", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Airplane mode is OFF", Toast.LENGTH_LONG).show();
            }
        }

//         Check if the screen has been turned off
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            Toast.makeText(context, "Screen turned offfffffffffffffffffffffffff", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "onReceive: Screen offf");

        }
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Toast.makeText(context, "Screen turned onnnnnnnnnnnnnnnnnnnnnnnn", Toast.LENGTH_LONG).show();
            Log.d("TAG", "onReceive: Screen onnnnnnnnnn");
        }
    }
}
