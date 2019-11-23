package com.ivisionblog.apps.materialtabsexample;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ivisionblog.apps.materialtabsexample.Question.sqllite;

import java.util.ArrayList;


public class tracuu_2 extends AppCompatActivity {
    sqllite db1;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<TracuuAdapter> lv=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tracuu_2);
        db1=new sqllite(this,"quanly.sqlite",null,1);
        db1.QueryData("CREATE TABLE IF NOT EXISTS TRACUU2(Id INTEGER PRIMARY KEY AUTOINCREMENT,Thongtin TEXT,MucPhat TEXT)");
        Cursor dataTraCuu=db1.GetData("SELECT * FROM TRACUU2");
        listView= (ListView) findViewById(R.id.list_tracuu);
        adapter=new ArrayAdapter<TracuuAdapter>(this,0,lv){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView=inflater.inflate(R.layout.lv_tra_cuu,null);
                TextView tvName= (TextView) convertView.findViewById(R.id.txt_1);
                TextView tvPhat= (TextView) convertView.findViewById(R.id.txt_2);
                TracuuAdapter a= lv.get(position);
                tvName.setText(a.getName());
                tvPhat.setText(a.getMucphat());
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        LoadData();
    }
    private void LoadData()
    {
        lv.clear();
        String sql="SELECT * FROM TRACUU2";

        Cursor cursor=db1.GetData(sql);
        cursor.moveToNext();
        while (!cursor.isAfterLast())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String phat=cursor.getString(2);
            TracuuAdapter u=new TracuuAdapter();
            u.setId(id);
            u.setName(name);
            u.setMucphat(phat);
            lv.add(u);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();



    }

}
