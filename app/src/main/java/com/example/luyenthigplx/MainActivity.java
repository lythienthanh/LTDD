package com.example.luyenthigplx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    Button btn_BienBaoDuongBo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_BienBaoDuongBo = (Button) findViewById(R.id.bienbao);

        btn_BienBaoDuongBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhBienBao = new Intent(MainActivity.this,BienBaoDuongBoActivity.class);
                startActivity(mhBienBao);
            }
        });
        int images[] = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4};

        v_flipper = findViewById(R.id.v_flipper);

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
