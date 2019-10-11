package com.example.luyenthigplx;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BienBaoDuongBoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bien_bao_duong_bo);

        ArrayList<BienBaoDuongBo> arrayOfUsers = getMockupData();

        BienBaoDuongBoAdapter adapter = new BienBaoDuongBoAdapter(this, arrayOfUsers);

        ListView listView =  findViewById(R.id.lv_bienbaoduongbo);
        listView.setAdapter(adapter);
    }
    public ArrayList<BienBaoDuongBo> getMockupData() {
        String cammoto = "biển báo cấm báo đường cấm tất cả các loại môtô đi qua, trừ các xe môtô được ưu tiên theo quy định.";
        String camoto = "biển báo giao thông báo đường cấm tất cả các loại xe cơ giới kể cả môtô 3 bánh có thùng đi qua, trừ môtô hai bánh, xe gắn máy và các xe được ưu tiên theo quy định.";
        String camxexucvat = "Để báo đường cấm súc vật vận tải hàng hóa hoặc hành khách dù kéo xe hay chở trên lưng đi qua.";
        String[] names = {"Cấm Môtô","Cấm Ô Tô","Cấm Xe Súc Vật Kéo"};
        String[] hometowns = {cammoto,camoto,camxexucvat};
        int[] flag = {R.drawable.cammoto,R.drawable.camoto,R.drawable.camxesucvatkeo};


        ArrayList<BienBaoDuongBo> bienBaoDuongBos = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            BienBaoDuongBo BienBaoDuongBo = new BienBaoDuongBo(names[i], hometowns[i], flag[i]);
            bienBaoDuongBos.add(BienBaoDuongBo);
        }
        return bienBaoDuongBos;
    }
}
