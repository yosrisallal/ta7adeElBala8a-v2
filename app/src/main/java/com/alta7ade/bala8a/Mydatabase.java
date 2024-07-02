package com.alta7ade.bala8a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Mydatabase   extends SQLiteOpenHelper {

    public static final String DB_NAME="Questions";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="questionsform";

    public static final String question="question";
    public static final String rightColumn ="rightColumn";
    public static final String leson="leson";
    public static final String false1="false1";
    public static final String false2="false2";
    public static final String false3="false3";
    public static final String category="category";
    ArrayList<questionform> Questions;
    ArrayList<Integer> ids;
    public Mydatabase( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE questionsform (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "question TEXT , rightColumn  TEXT ,leson TEXT,false1 TEXT,false2 TEXT,false3 TEXT,category TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS questionsform");
        onCreate(sqLiteDatabase);
    }
    
    public boolean insertquestionform(questionform questionform){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(question,questionform.getQuestion());
        contentValues.put(rightColumn,questionform.getRight());
        contentValues.put(leson,questionform.getLeson());
        contentValues.put(false1,questionform.getFalse1());
        contentValues.put(false2,questionform.getFalse2());
        contentValues.put(false3,questionform.getFalse3());
        contentValues.put(category,questionform.getcategory());
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result!=-1;
    }


    public long getquestionscount(){

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        return DatabaseUtils.queryNumEntries(sqLiteDatabase,TABLE_NAME);
    }

    public boolean deleteallquestions(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        int result=sqLiteDatabase.delete(TABLE_NAME,null,null);
        return result>0;
    }


    public ArrayList<questionform> getquestionwhereageequalto(int categoryquiz){
        Questions=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ids=new ArrayList<>();
        String[] subjects=Constants.rank1Subjects;
        if(categoryquiz==18){
            subjects=Constants.rank2Subjects;
        }
        if(categoryquiz==19){
            subjects=Constants.rank3Subjects;
        }
        for (String subject:subjects) {
            //TODO : GET HERE THE QUESTIONS where age equal to something
            Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM questionsform WHERE category=?",new String[]{subject});
            if (cursor.moveToFirst()) {
                do {
                    String QUESTION = cursor.getString((cursor.getColumnIndex(question)));
                    String  RIGHT= cursor.getString((cursor.getColumnIndex(rightColumn)));
                    String LESON=cursor.getString((cursor.getColumnIndex(leson)));
                    String FALSE1=cursor.getString((cursor.getColumnIndex(false1)));
                    String FALSE2=cursor.getString((cursor.getColumnIndex(false2)));
                    String FALSE3=cursor.getString((cursor.getColumnIndex(false3)));
                    String CATEGORY=cursor.getString((cursor.getColumnIndex(category)));
                    Questions.add(new questionform(FALSE1,FALSE2,FALSE3,LESON,QUESTION,RIGHT,CATEGORY));
                }while (cursor.moveToNext());
            }
        }
        return Questions;

    }


}


