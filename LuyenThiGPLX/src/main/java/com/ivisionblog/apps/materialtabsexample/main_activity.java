package com.ivisionblog.apps.materialtabsexample;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ivisionblog.apps.materialtabsexample.Question.DBHelper;

import java.io.IOException;

public class main_activity extends AppCompatActivity {
    ViewFlipper v_flipper;
    Button btn_BienBaoDuongBo;
    Button btn_thisathach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_BienBaoDuongBo = (Button) findViewById(R.id.bienbao);
        btn_BienBaoDuongBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhBienBao = new Intent(main_activity.this, BienBaoDuongBo_Activity.class);
                startActivity(mhBienBao);
            }
        });
        btn_thisathach = (Button) findViewById(R.id.thisathach);
        btn_thisathach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhBienBao = new Intent(main_activity.this, content.class);
                startActivity(mhBienBao);
            }
        });

        DBHelper db = new DBHelper(this);
        //load auto slide
        int images[] = {R.mipmap.s1, R.mipmap.s2, R.mipmap.s3, R.mipmap.s4};

        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);

        //for loop
        for (int i = 0; i < images.length; i++) {
            flipperimages(images[i]);
        }

        for (int image : images)
            flipperimages(image);
        //Phương thức xoa database viết vào hàm MainActivity
        try {
            db.deleteDataBase();
            //Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "loi", Toast.LENGTH_SHORT).show();
        }
    }

    public void flipperimages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000); //4sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}
