package com.ivisionblog.apps.materialtabsexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exam) {
        super(context, 0,exam);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_gidview,parent,false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_sode);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageIcon);

        Exam p= getItem(position);
        if(p != null) {
            tvName.setText(""+p.getName());
            imgIcon.setImageResource(R.mipmap.icon_de);
        }
        return convertView;
    }
}
