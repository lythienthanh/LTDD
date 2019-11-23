package com.ivisionblog.apps.materialtabsexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends FragmentPagerAdapter {
    private final List<Fragment> lstFragment=new ArrayList<>();
    private  final List<String> lstTitile=new ArrayList<>();
    public ViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitile.get(position);
    }

    @Override
    public int getCount() {
        return lstTitile.size();
    }
    public void AddFragment(Fragment fragment,String titile)
    {
        lstFragment.add(fragment);
        lstTitile.add(titile);

    }
}
