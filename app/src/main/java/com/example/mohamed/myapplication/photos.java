package com.example.mohamed.myapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.os.Bundle;

public class photos extends FragmentActivity {
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        viewpager = (ViewPager) findViewById(R.id.pager2);
        PagerAdapter2 padapter = new PagerAdapter2(getSupportFragmentManager());
        viewpager.setAdapter(padapter);

    }
}
