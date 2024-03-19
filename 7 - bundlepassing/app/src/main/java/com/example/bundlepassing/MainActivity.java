package com.example.bundlepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageview;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageview = findViewById(R.id.imageView);
        textview = findViewById(R.id.textView);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        int img = imageview.getSourceLayoutResId();

        intent.putExtra("image",R.drawable.wall);
        intent.putExtra("text",textview.getText().toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}