package com.ivisionblog.apps.materialtabsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.ivisionblog.apps.materialtabsexample.modal.BienBao;

public class main_activity extends AppCompatActivity {
    ViewFlipper v_flipper;
    Button btn_BienBaoDuongBo;

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
        int images[] = {R.mipmap.s1,R.mipmap.s2,R.mipmap.s3,R.mipmap.s4};

        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);

        //for loop
        for(int i = 0 ; i < images.length;i++)
        {
            flipperimages(images[i]);
        }

        for(int image: images)
            flipperimages(image);
    }
    public void flipperimages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000); //4sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}
