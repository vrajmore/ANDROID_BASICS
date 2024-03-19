package com.example.viewpager;

import static java.util.EnumSet.range;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpager2;
    ArrayList<Viewpageritems> viewpageritemsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager2 = findViewById(R.id.viewPager2);

        int[] images = {R.drawable.m5, R.drawable.challengersrt, R.drawable.chevroletcamaro, R.drawable.mustang};
        String[] heading = {"BMW M5 COMP", "DODGE CHALLENGER SRT DEMON", "CHEVROLET CAMARO", "MUSTANG"};
        String[] description = {"111111111", "22222222222", "333333333333", "44444444444"};

        viewpageritemsArrayList = new ArrayList<>();

            for (int i = 0; i < images.length; i++) {

                Viewpageritems viewpageritems = new Viewpageritems(images[i],heading[i],description[i] );
                viewpageritemsArrayList.add(viewpageritems);
            }


        Vpadapter vpadapter = new Vpadapter(viewpageritemsArrayList);
        viewpager2.setAdapter(vpadapter);
        viewpager2.setClipToPadding(false);
        viewpager2.setClipChildren(false);
        viewpager2.setOffscreenPageLimit(2);
        viewpager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

}