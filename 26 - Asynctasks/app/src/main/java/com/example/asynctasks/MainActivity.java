package com.example.asynctasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonupload;
    private ProgressBar hori, circ;
    private TextView textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonupload = findViewById(R.id.button);
        hori = findViewById(R.id.progressBar);
        circ = findViewById(R.id.progressBar2);
        textv = findViewById(R.id.textView);

        circ.setProgress(50);
        textv.setText("Ready");

        Async async = new Async();
        buttonupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Async async = new Async();
                async.execute();
            }
        });
    }

    public class Async extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "As";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "pre execute code started");
            buttonupload.setEnabled(false);
            circ.setActivated(true);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textv.setText("loading task");
                    SystemClock.sleep(3000);
                }
            });
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "background started");
            for (int i = 0; i < 11; i++) {
                SystemClock.sleep(1000);
                Log.d(TAG, "doInBackground: "+i+"secs");
                int j = i*10;
                hori.setProgress(j);
                circ.setProgress(j);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textv.setText(j+"%");
                    }
                });
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Log.d(TAG, "post execute code started");
            buttonupload.setEnabled(true);
            circ.setActivated(false);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textv.setText("task finished");
                    SystemClock.sleep(1000);
                }
            });
        }
    }
}