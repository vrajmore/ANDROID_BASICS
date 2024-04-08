package com.example.taskmayanksir;

import android.location.Location;
import android.location.LocationListener;
import android.util.Log;

import androidx.annotation.NonNull;

public class Mylocationlistener implements LocationListener {
    private static final String TAG = "tag";
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        Log.d(TAG, "onLocationChanged: "+location.getLatitude());
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }
}
