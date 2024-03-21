package com.example.studentsqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DataAccess dataAccess;
    StringBuilder sb = new StringBuilder();

    TextView name, gender, rollno, address, outputtext;
    Button submit, update;

    private Handler handler = new Handler();
    private Runnable runnable;

    private void updatedata(){
        runnable = new Runnable() {
            @Override
            public void run() {
                // Call your method here

                // Re-run the task after 1000 milliseconds (1 second)
                handler.postDelayed(this, 1000);
            }
        }; handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.namein);
        rollno = findViewById(R.id.rollin);
        address = findViewById(R.id.addressin);
        gender = findViewById(R.id.genderin);
        submit = findViewById(R.id.button);
        update = findViewById(R.id.button2);
        outputtext = findViewById(R.id.outputtext);

        dataAccess = new DataAccess(this);
        dataAccess.open();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long rowId = dataAccess.insertData(
                        name.getText().toString(),
                        Integer.parseInt(rollno.getText().toString()),
                        address.getText().toString(),
                        gender.getText().toString());
                name.setText("");
                rollno.setText("");
                address.setText("");
                gender.setText("");

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dataAccess.getAllData();
                // Handle the cursor, e.g., iterate through results
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("_id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int rollno = cursor.getInt(cursor.getColumnIndex("rollno"));
                    String address = cursor.getString(cursor.getColumnIndex("address"));
                    String gender = cursor.getString(cursor.getColumnIndex("gender"));
                    // Do something with the data (e.g., display it, process it)
                    Log.d("tag", "ID: " + id + ", Name: " + name + ", Age: " + rollno);

                    sb.append(id+"-")
                            .append(name+"-")
                            .append(rollno+"-")
                            .append(address+"-")
                            .append(gender+"-")
                            .append("\n");
                }
                outputtext.setText(sb);

            }
        });



    }

    @Override
    protected void onDestroy() {
        dataAccess.close();
        super.onDestroy();
    }
}
