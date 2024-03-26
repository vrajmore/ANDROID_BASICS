package com.example.videomedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public SurfaceView screen;
    private SeekBar seekbar;
    private Button playpause, back, forward;
    private TextView duration;

    private MediaPlayer mp;
    private Handler handler = new Handler();
    private Runnable runnable;
    int delayMillis;


    private void butclickanim(View view){
        view.setScaleX(0.9f);
        view.setScaleY(0.9f);
        Handler handler = new Handler();
                handler.postDelayed(() -> {
                    view.setScaleX(1);
                    view.setScaleY(1);
                }, delayMillis = 100);
    }
    private String formatDuration(int milliseconds) {
        int seconds = (milliseconds / 1000) % 60;
        int minutes = (milliseconds / (1000 * 60)) % 60;
        int hours = (milliseconds / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    private void updateSeekBar() {
        runnable = new Runnable() {
            @Override
            public void run() {
                if (mp != null) {
                    int currentPosition = mp.getCurrentPosition();
                    seekbar.setProgress(currentPosition);
                    duration.setText(formatDuration(currentPosition) + "/" + formatDuration(mp.getDuration()));
                }
                handler.postDelayed(this, 1000); // Update every 1 second (adjust as needed)
            }
        };
        handler.postDelayed(runnable, 1000); // Start updating immediately
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.surfaceView);
        seekbar = findViewById(R.id.seekBar);
        playpause = findViewById(R.id.playpause);
        duration = findViewById(R.id.duration);
        back = findViewById(R.id.back);
        forward = findViewById(R.id.forward);


        mp = MediaPlayer.create(this, R.raw.hum);


        screen.setKeepScreenOn(true);
        SurfaceHolder sh = screen.getHolder();

        sh.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mp.setDisplay(sh);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        updateSeekBar();



        mp.start();

        playpause.setText("pause");



        seekbar.setMax(mp.getDuration());
        duration.setText(  formatDuration(mp.getCurrentPosition())+"/"+formatDuration(mp.getDuration()));
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mp.seekTo(progress);
                    duration.setText(  formatDuration(progress)+"/"+formatDuration(mp.getDuration()));

                }
                int current = mp.getCurrentPosition();
                seekBar.setProgress(current);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butclickanim(v);
                if (mp.isPlaying()){
                    mp.pause();
                    playpause.setText("play");
                }else{
                    mp.start();
                    playpause.setText("pause");
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butclickanim(v);
                mp.seekTo(mp.getCurrentPosition()-10000);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butclickanim(v);
                mp.seekTo(mp.getCurrentPosition()+10000);
            }
        });
    }

}