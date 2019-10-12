package com.ivisionblog.apps.materialtabsexample.adapter;

/**
 * Created by root on 10/3/17.
 */


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivisionblog.apps.materialtabsexample.R;
import com.ivisionblog.apps.materialtabsexample.modal.BienBao;

import java.util.ArrayList;

/**
 * Created by root on 9/3/17.
 */

public class BienBaoAdapter extends RecyclerView.Adapter<BienBaoAdapter.ContactsHolder> {

    private ArrayList<BienBao> mBienBaos;
    private FragmentManager mFm;

    public BienBaoAdapter(ArrayList<BienBao> bienBaos){
        mBienBaos = bienBaos;
    }

    @Override
    public ContactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.single_contact, parent, false);

        ContactsHolder viewHolder = new ContactsHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsHolder holder, int position) {
        BienBao contact = mBienBaos.get(position);

        holder.mPhoneView.setText(contact.getmContent());
        holder.mContactsNameView.setText(contact.getmName());
        holder.mimgFlag.setImageResource(contact.getMhinh());
    }

    @Override
    public int getItemCount() {
        return mBienBaos.size();
    }


    public static class ContactsHolder extends RecyclerView.ViewHolder{

        TextView mContactsNameView;
        TextView mPhoneView;
        ImageView mimgFlag;
        public ContactsHolder(View itemView) {
            super(itemView);
            mContactsNameView = (TextView) itemView.findViewById(R.id.nameView);
            mPhoneView = (TextView) itemView.findViewById(R.id.phoneNumberView);
            mimgFlag = (ImageView) itemView.findViewById(R.id.mhinh);
        }

    }
}

