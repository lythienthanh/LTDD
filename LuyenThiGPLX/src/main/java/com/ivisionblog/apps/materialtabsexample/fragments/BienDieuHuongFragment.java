package com.ivisionblog.apps.materialtabsexample.fragments;

/**
 * Created by root on 10/3/17.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivisionblog.apps.materialtabsexample.R;
import com.ivisionblog.apps.materialtabsexample.adapter.BienBaoAdapter;
import com.ivisionblog.apps.materialtabsexample.modal.BienBao;

import java.util.ArrayList;

public class BienDieuHuongFragment extends Fragment{

private RecyclerView mRecyclerview;

public BienDieuHuongFragment() {
        // Required empty public constructor
        }

public static BienCamFragment newInstance() {
        BienCamFragment fragment = new BienCamFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
        }

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_customer, container, false);
        }

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerview = (RecyclerView) getActivity().findViewById(R.id.customerlist);

        BienBaoAdapter bienBaoAdapter = new BienBaoAdapter(generateData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(bienBaoAdapter);
}

private ArrayList<BienBao> generateData(){
        ArrayList<BienBao> bienBaos = new ArrayList<>();

        bienBaos.add(new BienBao("Hướng đi phải theo","Các xe chỉ được đi thẳng (trừ xe được quyền ưu tiên theo quy định)",R.mipmap.cac_xe_chi_duoc_di_thang));
        Log.e("size", bienBaos.size()+"");
        return bienBaos;
        }
}

