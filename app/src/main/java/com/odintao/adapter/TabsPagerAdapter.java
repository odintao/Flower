package com.odintao.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.odintao.flower.FavActivity;
import com.odintao.flower.FirstActivity;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FirstActivity tab1 = new FirstActivity();
                return tab1;
            case 1:
                FavActivity tab2 = new FavActivity();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
