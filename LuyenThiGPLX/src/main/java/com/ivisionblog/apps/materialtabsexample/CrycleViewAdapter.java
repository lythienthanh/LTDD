package com.ivisionblog.apps.materialtabsexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CrycleViewAdapter extends RecyclerView.Adapter<CrycleViewAdapter.MyViewHolder> {
    Context mContext;
    List<lithuyet> mdata;

    public CrycleViewAdapter(Context mContext, List<lithuyet> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.itemlithuyet,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mdata.get(position).getName());
        holder.tv_phone.setText(mdata.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_phone;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name= (TextView) itemView.findViewById(R.id.txt_cry1);
            tv_phone= (TextView) itemView.findViewById(R.id.txt_cry2);
        }
    }
}

