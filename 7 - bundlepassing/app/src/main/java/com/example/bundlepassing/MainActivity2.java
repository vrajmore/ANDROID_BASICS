package com.example.bundlepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageview;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageview = findViewById(R.id.imageView2);
        textview = findViewById(R.id.textView2);

        Intent i = getIntent();
        int getimage = i.getIntExtra("image",0);
        String gettext = i.getStringExtra("text");

        textview.setText(gettext);
        imageview.setImageResource(getimage);

    }
}