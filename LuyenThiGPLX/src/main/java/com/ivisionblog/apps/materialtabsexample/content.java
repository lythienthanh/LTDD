package com.ivisionblog.apps.materialtabsexample;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivisionblog.apps.materialtabsexample.Question.DBHelper;

import java.io.IOException;

public class content extends AppCompatActivity {
    Button x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        DBHelper DB = new DBHelper(this);
        try {
            DB.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = (Button) findViewById(R.id.btn_Start);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x.setVisibility(View.GONE);//an btn
                FragmentManager manager = getSupportFragmentManager();
                chuyen_main_chondethi_fr frment = new chuyen_main_chondethi_fr();
                manager.beginTransaction().replace(R.id.container,frment).commit();
            }
        });
    }





}
