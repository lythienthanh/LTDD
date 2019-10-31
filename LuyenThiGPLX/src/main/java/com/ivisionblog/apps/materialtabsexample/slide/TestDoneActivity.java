package com.ivisionblog.apps.materialtabsexample.slide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ivisionblog.apps.materialtabsexample.Question.Question;
import com.ivisionblog.apps.materialtabsexample.R;
import com.ivisionblog.apps.materialtabsexample.content;
import com.ivisionblog.apps.materialtabsexample.main_activity;

import java.util.ArrayList;
import java.util.Queue;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin = new ArrayList<Question>();
    int numNoAns=0;
    int numTrue=0;
    int numFalse = 0;
    int totalScore = 0;
    TextView tv_numNoAns,tv_numTrue,tv_numFlase,tv_totalScore;
    Button btn_ThiLai,btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
        final Intent intent = getIntent();
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        checkResult();
        tv_numNoAns.setText(""+numNoAns);
        tv_numTrue.setText(""+numTrue);
        tv_numFlase.setText(""+numFalse);
        totalScore = numTrue*10;
        tv_totalScore.setText(""+totalScore);

        btn_ThiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestDoneActivity.this, content.class);
                startActivity(intent1);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestDoneActivity.this, main_activity.class);
                startActivity(intent1);
            }
        });
    }

    public void begin(){
        tv_numFlase = (TextView) findViewById(R.id.tv_false);
        tv_numNoAns = (TextView) findViewById(R.id.tv_noAns);
        tv_numTrue = (TextView) findViewById(R.id.tv_true);
        btn_ThiLai = (Button) findViewById(R.id.btn_thilai);
        btn_thoat = (Button) findViewById(R.id.btn_thoat);
        tv_totalScore = (TextView) findViewById(R.id.tv_totalPoint);
    }

    //pt check ket qua
    public void checkResult()
    {
        for(int i = 0 ; i < arr_QuesBegin.size();i++)
        {
            if(arr_QuesBegin.get(i).getTraloi().equals("") == true){
                numNoAns++;
            }else if(arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true){
                numTrue++;
            }else numFalse++;
        }

    }










}
