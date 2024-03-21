package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kg = Double.parseDouble(editText.getText().toString());
                double pound = kg * 2.205;
                textView.setText("THE WEIGHT IN POUNDS IS:- "+ pound);
                Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "VALUE HAS BEEN CONVERTED", Toast.LENGTH_SHORT).show();

            }
        });
    }


}