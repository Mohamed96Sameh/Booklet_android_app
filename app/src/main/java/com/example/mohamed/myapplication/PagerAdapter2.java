package com.example.mohamed.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter2 extends FragmentPagerAdapter {

    public PagerAdapter2(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:

                return new Fragment11();
            case 1:
                return new Fragment22();
            case 2:
                return new Fragment33();
            case 3:
                return new Fragment44();

            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 4;
    }


}