package com.odintao.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.odintao.flower.FavActivity;
import com.odintao.flower.FirstActivity;

/**
 * Created by Odin on 4/22/2016.
 */
public class SimplePagerAdapter extends FragmentPagerAdapter  {

    public static final String ARGS_POSITION = "name";
    public static final int NUM_PAGES = 2;

    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if((position==0)) {
            fragment = new FirstActivity();
        }else{
            fragment = new FavActivity();
        }
        Bundle args = new Bundle();
        args.putInt(ARGS_POSITION, position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 1) {
            return "favorite" ;
        }else {
            return "category" ;
        }
    }
//    private final int[] ICON_INDICATOR = { R.drawable.ic_action_good
//            , R.drawable.ic_action_group
//            };
//    private final int NUM_ITEMS = 2;
//
//    public SimplePagerAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    public int getIconResId(int index) {
//        return ICON_INDICATOR[index];
//    }
//
//    public int getCount() {
//        return NUM_ITEMS;
//    }
//
//    public Fragment getItem(int position) {
//        if(position == 0)
//            return new FirstActivity();
//        else if(position == 1)
//            return TwoFragment.newInstance();
//
//        return null;
//    }
}
