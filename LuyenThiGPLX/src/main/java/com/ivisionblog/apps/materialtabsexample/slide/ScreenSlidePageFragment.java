package com.ivisionblog.apps.materialtabsexample.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ivisionblog.apps.materialtabsexample.Question.Question;
import com.ivisionblog.apps.materialtabsexample.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Question> arr_Ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_checkAns = "checkAns";
    private int mPageNumber;//vi tri trang hien tai
    public int checkAns;//bien kiem tra

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView image;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView) rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        image = (ImageView) rootView.findViewById(R.id.image_dethi);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lay data tu ScreenSlideActivity sang fragment
        arr_Ques = new ArrayList<Question>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = screenSlideActivity.getdata();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_checkAns);
    }

    public static ScreenSlidePageFragment create(int pageNumber,int checkAns) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_checkAns,checkAns);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu: " + (mPageNumber + 1));
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
        radA.setText(getitem(mPageNumber).getAns_a());
        radB.setText(getitem(mPageNumber).getAns_b());
        radC.setText(getitem(mPageNumber).getAns_c());
        radD.setText(getitem(mPageNumber).getAns_d());


        int[] img = {R.drawable.s3,R.drawable.s4,R.drawable.s3,R.drawable.s4,R.drawable.s3,R.drawable.s4,R.drawable.s3,R.drawable.s4};
        for(int i = 0 ; i < arr_Ques.size() ; i++) {
            image.setImageResource(img[mPageNumber]);
        }

        if(checkAns != 0)
        {
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getitem(mPageNumber).getResult().toString());
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getitem(mPageNumber).choiceid = checkedId;
                getitem(mPageNumber).setTraloi(getchoiID(checkedId));
            }
        });
    }

    public Question getitem(int posotion){
        return arr_Ques.get(posotion);
    }

    //lay gia tri check chuyen thi dap an
    private String getchoiID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

    //kiem tra cau dung,doi mau background neu dung
    private void getCheckAns(String ans){
        if(ans.equals("A") == true)
            radA.setBackgroundColor(Color.RED);
        else if(ans.equals("B") == true)
            radB.setBackgroundColor(Color.RED);
        else if(ans.equals("C") == true)
            radC.setBackgroundColor(Color.RED);
        else if(ans.equals("D") == true)
            radD.setBackgroundColor(Color.RED);
        else ;
    }





}
