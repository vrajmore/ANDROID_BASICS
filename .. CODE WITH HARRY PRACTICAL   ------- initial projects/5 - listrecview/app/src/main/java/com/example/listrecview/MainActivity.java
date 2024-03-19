package com.example.listrecview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arr[] = {"item1","item2","item3","item4","item5","item6","item7","item8","item9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
//        listView.setAdapter(ad);
        vAdapter ad = new vAdapter(this, R.layout.myvlayout,arr);
        listView.setAdapter(ad);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "you clicked "+position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}