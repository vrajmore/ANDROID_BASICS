package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.i1){
            Toast.makeText(this, "CLICKED ITEM 1", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.i2){
            Toast.makeText(this, "CLICKED ITEM 2", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.i3){
            Toast.makeText(this, "CLICKED ITEM 3", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.i4){
            Toast.makeText(this, "CLICKED ITEM 4", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.i5){
            Toast.makeText(this, "CLICKED ITEM 5", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}