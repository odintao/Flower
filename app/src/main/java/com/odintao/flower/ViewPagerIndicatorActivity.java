package com.odintao.flower;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.odintao.adapter.SimplePagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

/**
 * Created by Odin on 4/22/2016.
 */
public class ViewPagerIndicatorActivity extends AppCompatActivity {

    private TitlePageIndicator mTitlePageIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_titlepage);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTitlePageIndicator = (TitlePageIndicator) findViewById(R.id.titles);

        SimplePagerAdapter adapter =
                new SimplePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        mTitlePageIndicator.setViewPager(mViewPager);
    }
}