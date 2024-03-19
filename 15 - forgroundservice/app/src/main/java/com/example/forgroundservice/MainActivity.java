package com.example.forgroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;

    private boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For Android Oreo and later versions
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            return notificationManager.areNotificationsEnabled();
        } else {
            // For versions prior to Oreo
            String enabledNotificationListeners = Settings.Secure.getString(
                    getContentResolver(),
                    "enabled_notification_listeners"
            );
            return enabledNotificationListeners != null && enabledNotificationListeners.contains(getPackageName());
        }
    }



    boolean serviceonoff;
    void startservice(){
        startForegroundService(new Intent(MainActivity.this, Foregroundservice.class));
        serviceonoff = true;
    }
    void stopservice(){
        stopService(new Intent(MainActivity.this, Foregroundservice.class));
        serviceonoff = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.button);
        play.setText("make service onn");

        if (!areNotificationsEnabled()) {
            // ask for permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
        }



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceonoff == true){
                    stopservice();
                    play.setText("make service onn");
                }else {
                    startservice();
                    play.setText("make service off");
                }
            }
        });
    }
}