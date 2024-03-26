package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private FrameLayout framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv = findViewById(R.id.bottomNavigationView);
        framelayout = findViewById(R.id.framelayout);

        loadfragment(new HomeFragment());
        bnv.setSelectedItemId(R.id.home);


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home){
                    loadfragment(new HomeFragment());
                } else if (item.getItemId() == R.id.settings) {
                    loadfragment(new SettingsFragment());
                } else if (item.getItemId() == R.id.profile) {
                    loadfragment(new ProfileFragment());
                }
                return true;
            }
        });
    }
    public void loadfragment (Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.framelayout,fragment);
        ft.commit();
    }
}