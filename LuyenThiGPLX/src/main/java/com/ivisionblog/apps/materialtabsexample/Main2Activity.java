package com.ivisionblog.apps.materialtabsexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout= (TabLayout) findViewById(R.id.tablayout_id);
        viewPager= (ViewPager) findViewById(R.id.viewpager_id);
        adapter=new ViewAdapter(getSupportFragmentManager());
        //add
        adapter.AddFragment(new FargmentLithuyet(),"Học lí thuyết");
        adapter.AddFragment(new FragmentThuchanh(),"Học thực hành");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
