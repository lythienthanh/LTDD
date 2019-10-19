package com.ivisionblog.apps.materialtabsexample;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ivisionblog.apps.materialtabsexample.slide.ScreenSlideActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class chuyen_main_chondethi_fr extends Fragment {

    Button btn_start;
    public chuyen_main_chondethi_fr() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent i =new Intent(getActivity(), ScreenSlideActivity.class);
        startActivity(i);
        return inflater.inflate(R.layout.fragment_chuyen_main_chondethi_fr, container, false);
    }
}
