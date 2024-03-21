package com.example.pendingintent;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Retrieve data from the intent
        if (getIntent().hasExtra("EXTRA_MESSAGE")) {
            String message = getIntent().getStringExtra("EXTRA_MESSAGE");

            // Display the message in a TextView
            TextView resultTextView = findViewById(R.id.resultTextView);
            resultTextView.setText(message);
        }
    }
}