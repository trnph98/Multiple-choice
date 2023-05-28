package com.example.tracnghiemv1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;
    private static QuestionController instance;



    public QuestionController(Context context) {

        dbHelper = new DBHelper(context);
    }
    public QuestionController() {

    }
    public static QuestionController Instance(Context context){
        if (instance == null) instance = new QuestionController(context);
        return QuestionController.instance;
    }

    public ArrayList<Question> getQuestion(int num_exam, String subject){
        ArrayList<Question> lsData = new ArrayList<Question>();
        SortedList sortedList = new SortedList();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //err
        Cursor cursor = (Cursor) db.rawQuery("SELECT * FROM toan ORDER BY RANDOM() LIMIT 35",null);
        cursor.moveToFirst();//duyệt từ dòng đầu tiên
        do {
            Question item;
             item = new Question(cursor.getInt(0),
                     cursor.getString(1),
                     cursor.getString(2),
                     cursor.getString(3),
                     cursor.getString(4),
                     cursor.getString(5),
                     cursor.getString(6),
                     cursor.getString(7),
                     cursor.getInt(8),
                     cursor.getString(9),"");
            lsData.add(item);
            sortedList.add(item);
        }while (cursor.moveToNext());
        sortedList.setSortStrategy(new QuestionSort());
        sortedList.sort();
        return sortedList.getItems();
    }


    public Cursor getSearchQuestion(String key){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //err
        Cursor cursor = (Cursor) db.rawQuery("SELECT * FROM toan WHERE question LIKE '%"+key+"%'",null);

        if (cursor != null)
            cursor.moveToFirst();//duyệt từ dòng đầu tiên
        return cursor;
    }
}
