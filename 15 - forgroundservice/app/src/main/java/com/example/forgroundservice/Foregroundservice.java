package com.example.forgroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class Foregroundservice extends Service {

    String channelid = "FOREGS";
    MediaPlayer mp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mp.setLooping(true);
        mp.start();



        NotificationChannel Channel = new NotificationChannel(channelid, channelid, NotificationManager.IMPORTANCE_HIGH);
        getSystemService(NotificationManager.class).createNotificationChannel(Channel);
        Notification.Builder Notification = new Notification.Builder(this, channelid)
                .setContentTitle("music")
                .setContentText("music is playing")
                .setChannelId(channelid)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setOngoing(true);

        startForeground(1001, Notification.build(), ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
