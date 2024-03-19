package com.example.custombroadcastsend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class Receivermodule extends BroadcastReceiver {
    Switch swt;
    Receivermodule(Switch swt){
        this.swt = swt;
    }
    @Override
    public void onReceive(Context context, Intent intent) {


        if ("com.example.custombroadcastsend.CUSTOM_ACTION".equals(intent.getAction())) {
            boolean switchmod = intent.getBooleanExtra("message",false);
            if (switchmod == false) {
                swt.setChecked(false);
                Toast.makeText(context, "switch OFF", Toast.LENGTH_LONG).show();

            } else {
                swt.setChecked(true);
                Toast.makeText(context, "switch ON", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show();
        }

    }

}
