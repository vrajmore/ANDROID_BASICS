package com.example.fullmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class PlaySong extends AppCompatActivity {
    private TextView textview;
    private ImageView previous,play,next;
    private ArrayList<File> songs;
    private MediaPlayer mediaplayer;
    String textcontent;
    int position;
    private SeekBar seekbar;
    Thread updateseekbar;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaplayer.stop();
        mediaplayer.release();
        updateseekbar.interrupt();
    }
    private void butclickanim(View view){
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        Handler handler = new Handler();
        int delayMillis;
        handler.postDelayed(() -> {
            view.setScaleX(1);
            view.setScaleY(1);
        }, delayMillis = 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        play=findViewById(R.id.play);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        textview=findViewById(R.id.textView3);
        seekbar=findViewById(R.id.seekBar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        songs = (ArrayList) bundle.getParcelableArrayList("songlist");
        textcontent = intent.getStringExtra("currentsong");
        textview.setText(textcontent);
        position= intent.getIntExtra("position", 0);
        Uri uri = Uri.parse(songs.get(position).toString());
        mediaplayer = MediaPlayer.create(this, uri);
        mediaplayer.start();
        seekbar.setMax(mediaplayer.getDuration());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaplayer.seekTo(seekbar.getProgress());
            }
        });
        updateseekbar = new Thread(){
            @Override
            public void run() {
                int currentposition = 0;
                try {
                    while (currentposition<mediaplayer.getDuration()){
                        currentposition = mediaplayer.getCurrentPosition();
                        seekbar.setProgress(currentposition);
                        sleep(800);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        updateseekbar.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butclickanim(v);
                if (mediaplayer.isPlaying()){
                    mediaplayer.pause();
                }else {
                    mediaplayer.start();
                }
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.stop();
                mediaplayer.release();
                if (position!=0){
                    position = position-1;
                }else {
                    position = songs.size()-1;
                }
                Uri uri = Uri.parse(songs.get(position).toString());
                mediaplayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaplayer.start();
                seekbar.setMax(mediaplayer.getDuration());
                textcontent = songs.get(position).getName().toString();
                textview.setText(textcontent);
                butclickanim(v);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.stop();
                mediaplayer.release();
                if (position != songs.size()-1){
                    position = position + 1;
                }else {
                    position = 0;
                }
                Uri uri = Uri.parse(songs.get(position).toString());
                mediaplayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaplayer.start();
                seekbar.setMax(mediaplayer.getDuration());
                textcontent = songs.get(position).getName().toString();
                textview.setText(textcontent);
                butclickanim(v);
            }
        });
    }
}