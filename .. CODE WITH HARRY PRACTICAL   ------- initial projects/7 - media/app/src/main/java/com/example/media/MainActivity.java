package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer;
    private Button play, pause, playpause;
    private TextView name;
    private SeekBar seekbar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        name = findViewById(R.id.textView);
        seekbar = findViewById(R.id.seekBar);
        playpause = findViewById(R.id.playpause);

        name.setText("songs");

//        mediaplayer = MediaPlayer.create(this,R.raw.hum);
//

           mediaplayer = new MediaPlayer();
        try {
            mediaplayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/pinguin-radio-d46f3.appspot.com/o/tracks%2FyC8xep55WUjDuOw4xMHN%2FyC8xep55WUjDuOw4xMHN_1671730223996?alt=media&token=baae16e5-3a15-4e82-80b0-7bd01fed7e47");
//
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaplayer) {
                Toast.makeText(MainActivity.this, "Ready", Toast.LENGTH_SHORT).show();
                mediaplayer.start();
                seekbar.setMax(mediaplayer.getDuration());

            }
        });
        mediaplayer.prepareAsync();


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaplayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.pause();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.start();
            }
        });

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaplayer.isPlaying()){
                    mediaplayer.pause();
                    playpause.setText("play");
                }else {
                    mediaplayer.start();
                    playpause.setText("pause");
                }
            }
        });
    }
}