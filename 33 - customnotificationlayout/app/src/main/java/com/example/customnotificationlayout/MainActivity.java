package com.example.customnotificationlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "VrajMoore";
    Button button;
    private static final String CHANNEL_ID = "channel1";
    CharSequence name = "Channel Name";
    String description = "Channel Description";
    int importance = NotificationManager.IMPORTANCE_HIGH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button3);


        if (!areNotificationsEnabled()) {
            // ask for permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
        }


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);

//        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

// Get the layouts to use in the custom notification
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notilayout);
        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.notibiglayout);

// Apply the layouts to the notification.

        Context context = getApplicationContext();



//        PendingIntent intent = PendingIntent.getBroadcast(context,100,new Intent(this, MainActivity.class), -1);

        Intent intent = new Intent(this, MainActivity2.class);
        PendingIntent intent1 = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_MUTABLE);

        Notification customNotification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .addAction(R.drawable.ic_launcher_foreground,"send", intent1)
                .build();




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Button  click");
                notificationManager.notify(666, customNotification);
            }
        });

    }


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
}