package com.example.multis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    public static final String extraname = "com.example.multis.extraname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void openactivity(View v){
        Toast.makeText(this, "opening new activity ....", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this, MainActivity2.class);
        name=findViewById(R.id.editTextText);
        String nametext= name.getText().toString();
        intent.putExtra(extraname , nametext);
        startActivity(intent);
    }
}