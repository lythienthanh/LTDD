package com.ivisionblog.apps.materialtabsexample;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ivisionblog.apps.materialtabsexample.Question.DBHelper;
import com.ivisionblog.apps.materialtabsexample.Question.Question;
import com.ivisionblog.apps.materialtabsexample.Question.sqllite;

import java.io.IOException;
import java.util.ArrayList;

public class main_activity extends AppCompatActivity {
    sqllite db1;
    ViewFlipper v_flipper;
    Button btn_BienBaoDuongBo;
    Button btn_thisathach;
    Button btn_tracuu;
    Button btn_meothi;
    Button btn_lythuyet;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<TracuuAdapter> lv=new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_lythuyet = (Button) findViewById(R.id.btn_hoclythuyet);
        btn_lythuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lythuyet = new Intent(main_activity.this, conten_lythuyet.class);
                startActivity(lythuyet);
            }
        });
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
        btn_tracuu= (Button) findViewById(R.id.tracuu);
        btn_tracuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhtraCuu=new Intent(main_activity.this,tracuu_2.class);
                startActivity(mhtraCuu);
            }
        });
        btn_meothi= (Button) findViewById(R.id.meothi);
        btn_meothi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhmeothi=new Intent(main_activity.this,Main2Activity.class);
                startActivity(mhmeothi);
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



        //them du lieu
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Không chú ý quan sát, điều khiển xe quá tốc độ quy định gây tai nạn giao thông','MỨC PHẠT: 2.000.000-3.000.000 và tước giấy phép sử dụng 2 tháng')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Không giảm tốc độ hoặc không nhường đường khi điều khiển xe chạy từ trong ngõ, đường nhánh ra đường chính','MỨC PHẠT:100.000-200.000')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Điều khiển xe chạy tốc độ thấp mà không đi bên phải phần đường xe chạy gây cản trở giao thông','MỨC PHẠT:100.000-200.000')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Điều khiển xe chạy quá tốc độ quy định từ 5 km/h đến dưới 10km/h','MỨC PHẠT:100.000-200.000')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Điều khiển xe chạy dưới tốc độ tối thiểu trên những đoạn đường bộ có quy định tốc độ tối thiểu cho phép','200.000-400.000')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Đua xe mô tô, xe gắn máy, xe máy điện trái phép','MỨC PHẠT:1.000.000-2.000.000 -TƯỚC QUYỂN SỬ DỤNG GIẤY PHÉP LÁI XE 4 THÁNG VÀ TỊCH THU PHƯƠNG TIỆN')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100mililit máu hoặc vượt quá 0.25 miligam đến 0.4 miligam/1 lít khí thở','MỨC PHẠT:500.000-1.000.000 VÀ TƯỚC GIẤY PHÉP 1 THÁNG -GÂY TAI NẠN SẼ BỊ TƯỚC QUYỀN 2 THÁNG-ĐỂ NGĂN CHẶN NGAY VI PHẠM HÀNH CHÍNH NGƯỜI CÓ THẨM QUYỀN XỬ PHẠT ĐƯỢC PHÉP TẠM DỮ PHƯƠNG TIỆN 7 NGÀY TRƯỚC KHI RA QUYẾT ĐỊNH')");
//        db1.QueryData("INSERT INTO TRACUU2 VALUES(null,'Không chấp hành yêu cầu kiểm tra về chất ma túy, nồng độ cồn của người kiểm soát giao thông hoặc người thi hành công vụ','MỨC PHẠT:2.000.000-3.000.000 VÀ TƯỚC QUYỀN SỬ DỤNG GIẤY PHÉP LÁI XE 2 THÁNG - ĐỂ NGĂN CHẶN VI PHẠM HÀNH CHÍNH NGƯỜI CÓ THẨM QUYỀN XỬ PHẠT ĐƯỢC PHÉP TẠM DỮ PHƯƠNG TIỆN ĐẾN 7 NGÀY TRƯỚC KHI RA QUYẾT ĐỊNH SỬ PHẠT')");



        //select
//        Cursor dataTraCuu=db1.GetData("SELECT * FROM TRACUU2");
//        while(dataTraCuu.moveToNext())
//        {
//            String ten=dataTraCuu.getString(1);
//            Toast.makeText(this,ten,Toast.LENGTH_SHORT).show();
//
//
//        }
//            listView= (ListView) findViewById(R.id.list_tracuu);
//            adapter=new ArrayAdapter<TracuuAdapter>(this,0,lv){
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//                convertView=inflater.inflate(R.layout.lv_tra_cuu,null);
//                TextView tvName= (TextView) convertView.findViewById(R.id.txt_1);
//                TextView tvPhat= (TextView) convertView.findViewById(R.id.txt_2);
//                TracuuAdapter a= lv.get(position);
//                tvName.setText(a.getName());
//                tvPhat.setText(a.getMucphat());
//
//
//
//                return convertView;
//            }
//        };
//        listView.setAdapter(adapter);
//        LoadData();
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
//    private void LoadData()
//    {
//        lv.clear();
//        String sql="SELECT * FROM TRACUU2";
//
//        Cursor cursor=db1.GetData(sql);
//        cursor.moveToNext();
//        while (!cursor.isAfterLast())
//        {
//            int id=cursor.getInt(0);
//            String name=cursor.getString(1);
//            String phat=cursor.getString(2);
//            TracuuAdapter u=new TracuuAdapter();
//            u.setId(id);
//            u.setName(name);
//            u.setMucphat(phat);
//            lv.add(u);
//            cursor.moveToNext();
//        }
//        adapter.notifyDataSetChanged();
//
//
//
//    }

}
