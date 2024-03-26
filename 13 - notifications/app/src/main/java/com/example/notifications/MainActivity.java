package com.example.notifications;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        if (!areNotificationsEnabled()) {
            // ask for permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
        }

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        String channelid = "channel1";

        Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.star)
                    .setLargeIcon(largeIconBitmap)
                    .setContentTitle("hello")
                    .setContentText("HELLOWORLD")
                    .setChannelId(channelid)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(channelid, "channel", NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.star)
                    .setLargeIcon(largeIconBitmap)
                    .setContentTitle("hello")
                    .setContentText("HELLOWORLD")
                    .build();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(100, notification);

            }
        });

    }

}