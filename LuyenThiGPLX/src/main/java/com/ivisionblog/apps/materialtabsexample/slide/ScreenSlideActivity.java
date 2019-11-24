package com.ivisionblog.apps.materialtabsexample.slide;

import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivisionblog.apps.materialtabsexample.Question.Question;
import com.ivisionblog.apps.materialtabsexample.Question.QuestionController;
import com.ivisionblog.apps.materialtabsexample.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScreenSlideActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 8;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;


    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */

    private PagerAdapter mPagerAdapter;
    TextView tv_kiemtra,tv_timer,tv_xemdiem;
    public int check_Ans = 0;
    ImageView img_exam_clock;
    //CSDL
    QuestionController questionController;
    ArrayList<Question> arr_Ques;
    CountDownTimer timer;
    int num_exam;
    int phanthi; //0 chon de thi || 1 chon hoc ly thuyet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        timer = new CounterClass(60*1000,1000); //60s moi buoc nhay la 1s

        Intent intent = getIntent();
        num_exam = intent.getIntExtra("num_exam",0);
        if(num_exam == 0)
        {
            num_exam = intent.getIntExtra("num_exam1",0);
            questionController = new QuestionController(this);
            arr_Ques=new ArrayList<Question>();
            arr_Ques = questionController.getQuestions(num_exam,"lythuyet");
            tv_xemdiem = (TextView) findViewById(R.id.tvScore);
            tv_timer = (TextView) findViewById(R.id.tvTimer);
            tv_timer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            tv_kiemtra = (TextView) findViewById(R.id.tvKiemTra);
            tv_kiemtra.setVisibility(View.GONE);
            tv_timer.setVisibility(View.GONE);
            resultlythuyet();

        }else{
            questionController = new QuestionController(this);
            arr_Ques=new ArrayList<Question>();
            arr_Ques = questionController.getQuestions(num_exam,"thisathach");
            tv_xemdiem = (TextView) findViewById(R.id.tvScore);
            tv_timer = (TextView) findViewById(R.id.tvTimer);
            tv_timer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            tv_kiemtra = (TextView) findViewById(R.id.tvKiemTra);
            tv_kiemtra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns();
                }
            });
            tv_xemdiem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(ScreenSlideActivity.this,TestDoneActivity.class);
                    intent1.putExtra("arr_Ques",arr_Ques);
                    startActivity(intent1);
                }
            });
            timer.start();
        }

    }

    public ArrayList<Question> getdata() {
        return arr_Ques;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position,check_Ans);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
    public void checkAns(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_ans_dialog);
        dialog.setTitle("Danh sách câu trả lời");

        check_ans_adapter check_ans_adapter = new check_ans_adapter(arr_Ques,this);
        GridView gvListQues = (GridView) dialog.findViewById(R.id.gvlsQues);
        gvListQues.setAdapter(check_ans_adapter);
        gvListQues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
        Button btn_cancel,btn_finish;
        btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btn_finish = (Button) dialog.findViewById(R.id.btn_finish);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //dong
            }
        });
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                result();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void result()
    {
        check_Ans = 1;
        //load background
        if(mPager.getCurrentItem() >= 4) mPager.setCurrentItem(mPager.getCurrentItem() -4);
        else if(mPager.getCurrentItem() <= 4) mPager.setCurrentItem(mPager.getCurrentItem() + 4);


        tv_xemdiem.setVisibility(View.VISIBLE); //hien thi
        tv_kiemtra.setVisibility(View.GONE);
    }

    public void resultlythuyet()
    {
        check_Ans = 1;
        //load background
        if(mPager.getCurrentItem() >= 4) mPager.setCurrentItem(mPager.getCurrentItem() -4);
        else if(mPager.getCurrentItem() <= 4) mPager.setCurrentItem(mPager.getCurrentItem() + 4);


//        tv_xemdiem.setVisibility(View.VISIBLE); //hien thi
//        tv_kiemtra.setVisibility(View.GONE);
    }

    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */

        //millisInFuture 60s x 1000milisecon
        //countDownInterval 1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tv_timer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tv_timer.setText("00:00");  //SetText cho textview hiện thị thời gian.
        }
    }










}
