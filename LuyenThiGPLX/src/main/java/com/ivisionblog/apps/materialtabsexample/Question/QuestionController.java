package com.ivisionblog.apps.materialtabsexample.Question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {

        dbHelper = new DBHelper(context);
    }
    public ArrayList<Question> getQuestions(int num_exam,String subject){
        ArrayList<Question> lsda = new ArrayList<Question>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tracnghiem where num_exam='"+num_exam+"' and subject='"+subject+"'",null);
        int c = cursor.getCount();
        cursor.moveToFirst();
        do{
            Question item;
            item = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9));
            lsda.add(item);
        }while (cursor.moveToNext());
        return lsda;
    }
}
