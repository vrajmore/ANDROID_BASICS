package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class Broadcastreceivermod extends BroadcastReceiver{
    Switch swit;
    boolean a;
    Broadcastreceivermod(Switch swit){
        this.swit = swit;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("com.example.testbroadcast.ACTION1")){
            a = intent.getBooleanExtra("switch",false);
            swit.setChecked(a);
        } else if (intent.getAction().equals("com.example.testbroadcast.ACTION2")) {
            int b = intent.getIntExtra("num1",0);
            int c = intent.getIntExtra("num2",0);
            int d = b + c;
            Toast.makeText(context, "sum is"+d, Toast.LENGTH_SHORT).show();
        }


    }
}
