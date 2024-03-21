package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView title,amount,output,totalout;
    private Button add, update;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.editTextText);
        amount = findViewById(R.id.editTextNumber);
        output = findViewById(R.id.output);
        totalout = findViewById(R.id.total);
        add = findViewById(R.id.add);
        update = findViewById(R.id.button2);

        Databasehelper databasehelper = Databasehelper.getDB(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() && amount.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "enter data", Toast.LENGTH_SHORT).show();
                }else {
                databasehelper.expenceDao().insertData(new Dailyexpense(title.getText().toString(), Integer.parseInt(amount.getText().toString())));
                }
                title.setText("");
                amount.setText("");
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Dailyexpense> dailyexpenses = (ArrayList<Dailyexpense>) databasehelper.expenceDao().showAllData();
                StringBuilder sb = new StringBuilder();
                int total = 0;

                for (int i = 0; i < dailyexpenses.size(); i++) {
                    total += dailyexpenses.get(i).getAmount();

                    Log.d(TAG, "expense title:-"+ dailyexpenses.get(i).getTitle()+" expense amount:-"+ dailyexpenses.get(i).getAmount());
                    sb.append("expense title:-"+ dailyexpenses.get(i).getTitle()+"\n expense amount:-"+ dailyexpenses.get(i).getAmount());
                    sb.append("\n\n");
                totalout.setText("TOTAL EXPENSE:- " + String.valueOf(total));
                }
                output.setText(sb);
                Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });



    }
}