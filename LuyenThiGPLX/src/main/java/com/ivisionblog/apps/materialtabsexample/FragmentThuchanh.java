package com.ivisionblog.apps.materialtabsexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentThuchanh extends Fragment {
    RecyclerView recyclerView;
    List<thuchanh> thuchanhList;
    View v;

    public FragmentThuchanh() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frm_thuc_hanh,container,false);
        recyclerView= (RecyclerView) v.findViewById(R.id.thuchanh_recycle);
        RecycleViewAdapter crycleViewAdapter=new RecycleViewAdapter(getContext(),thuchanhList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(crycleViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thuchanhList=new ArrayList<>();
        thuchanhList.add(new thuchanh("Giới thiệu","Hiện nay trong việc thi bằng lái xe máy thì pần thì thực hành chấm điểm tự động bằng chíp do máy tự động chấm điểm nên việc thi thực hành tủ lệ trượt nhiều hơn so với trước,Qua quá trình tổ chức thi sát hạch qua rất nhiều học viên đúc kết ra môt số mẹo cần chuẩn bị trước để thi đảm bảo 100%."));
        thuchanhList.add(new thuchanh("Bài 1: Chạy theo vòng số 8","Khi nghe gọi tên vào thi thực hành bài thi sát hạch lái xe mô tô thí sinh nhận xe đội mũ bảo hiểm , gạt chống xe và nổ máy đưa xe vào vị trí xuất phát.Trong phần thi" +
                "số 1thi sinh phải nhớ nguyên tắc vào 8 ra 3, phải chạy đủ vòng. Nên chạy với tốc độ vừa phỉa trong suốt lộ trình." +
                "Khi nghe hiệu lệnh của người chấm thi thí sinh bắt đầu phần thi số 1 của bài thi thực hành thì sát hạch lái xe mô tô." +
                "Gài số vào hình, xuất phát rẽ phải đi 1 vòng số 8 theo mũi tên đỏ sau đó vòng ra cửa số 2 theo hướng mũi tên xanh. "));
        thuchanhList.add(new thuchanh("Bài 2: Đi vào đường hẹp","Trong phần này đường đi khá hẹp nên các bạn thí sinh cần lưu ý chỉ nên đi với tốc độ vừa phải, và đi giữa đường để tránh bị chạm vạch"));
        thuchanhList.add(new thuchanh("Bài 3: Chạy đường quanh co","Trong phần 3 của bài thi thực hành thi sát hạch lái xe mô tô, thi sinh nên nahyr ga đều đặn để xe chạy nhịp nhàng. Phần thi này đòi hỏi học viên cần có kỹ thuật đi vòng cua"));
        thuchanhList.add(new thuchanh("Bài 4: Chạy đường quanh co","Đầy là phần thi thực hành cuối cùng. Các thí sinh phải giữ vững tay lái không nên đi với tốc độ quá chậm vì sẽ dễ ngã xe ảnh hưởng đến bài thi."));
    }
}
