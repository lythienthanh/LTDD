package com.example.luyenthigplx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BienBaoDuongBoAdapter extends ArrayAdapter<BienBaoDuongBo> {
    public BienBaoDuongBoAdapter(@NonNull Context context, @NonNull ArrayList<BienBaoDuongBo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BienBaoDuongBo bienBaoDuongBo = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_bienbao_layout, parent, false);

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvHome = convertView.findViewById(R.id.tvHome);
        ImageView imgFlag = convertView.findViewById(R.id.imgFlag);

        tvName.setText(bienBaoDuongBo.name);
        tvHome.setText(bienBaoDuongBo.hometown);
        imgFlag.setImageResource(bienBaoDuongBo.flag);

        return convertView;
    }
}
