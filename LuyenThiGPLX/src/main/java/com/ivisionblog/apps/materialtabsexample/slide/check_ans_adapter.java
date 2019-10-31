package com.ivisionblog.apps.materialtabsexample.slide;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ivisionblog.apps.materialtabsexample.Question.Question;
import com.ivisionblog.apps.materialtabsexample.R;

import java.util.ArrayList;

public class check_ans_adapter extends BaseAdapter {

    ArrayList lisdata;
    LayoutInflater inflater;

    public check_ans_adapter(ArrayList lisdata, Context context) {
        this.lisdata = lisdata;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lisdata.size();
    }

    @Override
    public Object getItem(int position) {
        return lisdata.get(position); //lay vi tri
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data = (Question) getItem(position);
        Viewhoder hoder;
        if(convertView == null){
            hoder = new Viewhoder();
            convertView = inflater.inflate(R.layout.item_griview_ans,null);
            hoder.tv_numans= (TextView) convertView.findViewById(R.id.tv_Numans);
            hoder.tv_yourans= (TextView) convertView.findViewById(R.id.tv_ans);
            convertView.setTag(hoder);
        }else
        {
            hoder= (Viewhoder) convertView.getTag();

        }
        int i = position+1;
        hoder.tv_numans.setText("Câu "+i+":");
        hoder.tv_yourans.setText(data.getTraloi());
        return convertView;
    }

    private  static class Viewhoder{
        TextView tv_numans,tv_yourans;

    }
}
