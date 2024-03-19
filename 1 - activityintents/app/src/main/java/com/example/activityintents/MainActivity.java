package com.example.activityintents;

import static android.content.Intent.ACTION_ALL_APPS;
import static android.content.Intent.ACTION_CALL;
import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button2);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openactivity2();
             }
         });

         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                implicitintent();
             }
         });
    }

    public void openactivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void implicitintent(){
//        Uri number = Uri.parse("https://www.youtube.com");
        Uri web = Uri.parse("https://www.youtube.com");
        Intent intent = new Intent(Intent.ACTION_VIEW , web);

        startActivity(intent);
    }
}