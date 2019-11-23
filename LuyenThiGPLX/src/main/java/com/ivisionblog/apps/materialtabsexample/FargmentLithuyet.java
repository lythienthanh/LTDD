package com.ivisionblog.apps.materialtabsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FargmentLithuyet extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<lithuyet> lithuyetList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lithuyetList=new ArrayList<>();
        lithuyetList.add(new lithuyet("Khái niệm và quy tắc","1. Câu khái niệm 'phương tiện giao thông cơ giới đường bộ' chọn ' kể cả xe máy điện."));
        lithuyetList.add(new lithuyet(null,"2.Câu khía niệm 'Phương tiện giao thông thô sơ đường bộ' chọn 'Kể cả xe máy' "));
        lithuyetList.add(new lithuyet("Hệ thống biển báo","Đối với các câu có biển báo hiệu lệnh được đặt trước ngã ba,ngã tư. Chọn câu 1 nếu câu hỏi 1 dòng, câu 3 nếu câu hỏi có 2 dòng." +
                "Biển báo cấm máy kéo thì không cấm ô tô tải và ngược lại." +
                "Biển báo cấm rẽ trái thì không cấm quay đầu và biển cấm quay đầu thì không cấm rẽ trái."));
        lithuyetList.add(new lithuyet("Sa hình","Đối với câu hỏi liên quan đến việc điều khiển của CSGT, CSGT giơ tay thẳng lên thì các loại xe phải đứng lại, đưa 1 hoặc 2 tay giang ngang thì xe trước và đằng sau phải đứng lại." +
                "Đường giao nhau có các vòng xuyến nhường bên trái, không có vòng xuyến nhường bên phải" +
                "Xe nào đã vào ngã tư thì xe đó có quyền ưu tiền đi trước cao nhất"));
    }

    public FargmentLithuyet() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frm_li_thuyet,container,false);
        recyclerView= (RecyclerView) v.findViewById(R.id.lythuyet_recycle);
        CrycleViewAdapter crycleViewAdapter=new CrycleViewAdapter(getContext(),lithuyetList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(crycleViewAdapter);
        return v;

    }

    
}
