package com.tutorialscache.tabslayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link views
        getViews();

        //setting toolbar
        initializeToolBar();

        //adapter setup
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        //attaching fragments to adapter
        pagerAdapter.addFragment(new ActionMoviesFragment(),"Action");
        pagerAdapter.addFragment(new ComedyMoviesFragment(),"Comedy");
        pagerAdapter.addFragment(new DramaMoviesFragment(),"Drama");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //setting icons
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movie_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_movie_white_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_movie_white_24dp);
    }

    private void getViews() {
        toolbar = findViewById(R.id.toolBar);
        tabLayout = findViewById(R.id.mTabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private void initializeToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Awesome Hollywood Movies");

     }
}
