package com.example.taskmayanksir;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.Manifest;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CarrierConfigManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.location.LocationListenerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;
    private static final String TAG = "tag";
    TextView out;
    static String data = "helllo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        out = findViewById(R.id.output);

        Log.d(TAG, "onCreate: ");
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

            Log.d(TAG, "seeking permission");
        } else {
            Toast.makeText(this, "Location Granted", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "permission granted");
        }

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Mylocationlistener mll = new Mylocationlistener();

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, mll);
        Log.d(TAG, "request gps update");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                Log.d(TAG, "run: running and updateing"+mll.getLatitude()+mll.getLongitude());
                out.setText("lati : " +mll.getLatitude()+" long : " + mll.getLongitude() );
                data = timeStamp
                        +" lati : "
                        + String.valueOf(mll.getLatitude())
                        +" long : "+String.valueOf(mll.getLongitude())
                        +" \n "+ "https://www.google.com/search?q="
                        +String.valueOf(mll.getLatitude())
                        +","
                        + String.valueOf(mll.getLongitude())
                        +"\n\n";
                writeDataToDownloads(MainActivity.this, "locc.txt", data);
            }
        },  2000);
    }

    private static boolean isExternalStorageWritable () {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static void writeDataToDownloads(Context context, String fileName, String content) {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadsDirectory, fileName);

        try {
            if (file.exists()) {
                Log.d(TAG, "File already exists: " + file.getAbsolutePath());
                FileOutputStream fos = new FileOutputStream(file, true);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(content);
                writer.newLine();
                writer.close();
                Log.d(TAG, "Data appended to the existing file.");
            } else {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(content);
                writer.close();
                Log.d(TAG, "Data written to a new file: " + file.getAbsolutePath());
            }
            Toast.makeText(context, "File saved to Downloads folder", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error writing file to Downloads folder", Toast.LENGTH_SHORT).show();
        }
    }
}