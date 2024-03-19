package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button1=findViewById(R.id.button2);
        url=findViewById(R.id.editTextText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent youtu = new Intent(Intent.ACTION_SEARCH);
                    youtu.setPackage("com.google.android.youtube");
                    youtu.putExtra(SearchManager.QUERY, url.getText().toString());
                    startActivity(youtu);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Some Error Occured :- "+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Uri webpage = Uri.parse("https://www.google.com/search?q="+url.getText().toString());
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(webIntent);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Some Error Occured : - "+e, Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}




