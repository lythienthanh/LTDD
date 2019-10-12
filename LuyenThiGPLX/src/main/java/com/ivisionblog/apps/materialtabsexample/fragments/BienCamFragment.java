package com.ivisionblog.apps.materialtabsexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivisionblog.apps.materialtabsexample.R;
import com.ivisionblog.apps.materialtabsexample.adapter.BienBaoAdapter;
import com.ivisionblog.apps.materialtabsexample.modal.BienBao;

import java.util.ArrayList;

public class BienCamFragment extends Fragment {

    private RecyclerView mRecyclerview;

    public BienCamFragment() {
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
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerview = (RecyclerView) getActivity().findViewById(R.id.contactlist);

        BienBaoAdapter bienBaoAdapter = new BienBaoAdapter(generateData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(bienBaoAdapter);
    }

    private ArrayList<BienBao> generateData(){
        ArrayList<BienBao> bienBaos = new ArrayList<>();

        bienBaos.add(new BienBao("Cấm Môtô","biển báo cấm báo đường cấm tất cả các loại môtô đi qua, trừ các xe môtô được ưu tiên theo quy định",R.mipmap.cam_moto));
        bienBaos.add(new BienBao("Cấm Ô Tô","biển báo giao thông báo đường cấm tất cả các loại xe cơ giới kể cả môtô 3 bánh có thùng đi qua, trừ môtô hai bánh, xe gắn máy và các xe được ưu tiên theo quy định.",R.mipmap.cam_oto));
        bienBaos.add(new BienBao("Cấm Xe Súc Vật Kéo","Để báo đường cấm súc vật vận tải hàng hóa hoặc hành khách dù kéo xe hay chở trên lưng đi qua.",R.mipmap.cam_xesucvatkeo));
        return bienBaos;
    }
}
