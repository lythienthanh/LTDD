package com.ivisionblog.apps.materialtabsexample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ivisionblog.apps.materialtabsexample.fragments.BienCamFragment;
import com.ivisionblog.apps.materialtabsexample.fragments.BienDieuHuongFragment;

public class BienBaoDuongBo_Activity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienbaoduongbo);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Biển Báo Đường Bộ");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addFragmentsToViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void addFragmentsToViewPager(ViewPager viewPager) {
        TabsFragmentPager_BBDB_Adapter adapter = new TabsFragmentPager_BBDB_Adapter(getSupportFragmentManager());
        adapter.addFragment(new BienDieuHuongFragment(), "Điều Hướng");
        adapter.addFragment(new BienCamFragment(), "Biển Báo Cấm");
        viewPager.setAdapter(adapter);
    }

}
