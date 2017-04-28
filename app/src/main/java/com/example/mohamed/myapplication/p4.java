package com.example.mohamed.myapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.os.Bundle;

public class p4 extends FragmentActivity {
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);
        viewpager = (ViewPager) findViewById(R.id.pager);
         PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padapter);

    }
}
