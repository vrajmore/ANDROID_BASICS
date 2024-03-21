package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageid = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
        String[] name = {
                "ron",
                "jhon",
                "kon",
                "don"
        };
        String[] msg = {
                "hello world",
                "world kik",
                "epsm",
                "hello"
        };
        String[] time = {
                "9:12",
                "9:25",
                "9:34",
                "9:56"
        };

        ArrayList<User> userarraylist = new ArrayList<>();
        for (int i = 0; i < imageid.length; i++) {
            User user = new User(name[i], msg[i], time[i], imageid[i]);
            userarraylist.add(user);
        }



        Listadapter listadapter = new Listadapter(MainActivity.this, userarraylist);
        binding.listview.setAdapter(listadapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });

    }
}