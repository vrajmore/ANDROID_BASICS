package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText enter;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        enter = findViewById(R.id.editTextText2);
        text = findViewById(R.id.textView2);

        SharedPreferences sp = getSharedPreferences("mypref", MODE_PRIVATE);

        StringBuilder names = new StringBuilder();
        names.append(sp.getString("name",""));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enter.getText().toString().isEmpty()){
                    names.append(enter.getText().toString() + "\n");
                }else {
                    Toast.makeText(MainActivity.this, "text field is empty", Toast.LENGTH_SHORT).show();
                }
                text.setText(names.toString());
                SharedPreferences.Editor ed = sp.edit();

                ed.putString("name",String.valueOf(names));
                ed.apply();
                enter.setText(null);

            }
        });
        text.setText(sp.getString("name","no value" ));
//        text.setText(sp.getString("name","no value"));



    }
}