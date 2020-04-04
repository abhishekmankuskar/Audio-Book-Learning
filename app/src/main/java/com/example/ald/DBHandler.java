package com.example.ald;

import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Trial.db";
    private static final String TABLE_NAME = "trial_table";
    private static final String COL_1 = "YEAR";
    private static final String COL_2 = "DEPARTMENT";
    private static final String COL_3 = "SUBJECT";
    private static final String COL_4 = "TOPIC";
    private static final String COL_5 = "AUDIOPATH";
    private static String path;
    private static CharArrayBuffer charArrayBuffer;

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL("CREATE TABLE "+TABLE_NAME+"(YEAR TEXT, DEPARTMENT TEXT, SUBJECT TEXT, TOPIC TEXT PRIMARY KEY, AUDIOPATH TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {
        sdb.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sdb);
    }

    boolean insertData(String year, String dept, String sub, String topic, String audiopath){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, year);
        contentValues.put(COL_2, dept);
        contentValues.put(COL_3, sub);
        contentValues.put(COL_4, topic);
        contentValues.put(COL_5, audiopath);

        long result =  db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    boolean updateData(String year, String dept, String sub, String topic, String audiopath) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, year);
        contentValues.put(COL_2, dept);
        contentValues.put(COL_3, sub);
        contentValues.put(COL_4, topic);
        contentValues.put(COL_5, audiopath);

        db.update(TABLE_NAME, contentValues, "Topic = ?", new String[]{topic});
        return true;
    }

    boolean deleteData(String topic) {
        SQLiteDatabase db = this.getWritableDatabase();
        Integer del = db.delete(TABLE_NAME, "Topic = ?", new String[]{topic});
        return del != 0;
    }

    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    boolean checkexists(String topic){
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_4+" = "+"'"+topic+"'";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            return true;
        }
        return false;
    }

    boolean checkempty(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        if(cursor.getCount() == 0){
            return true;
        }
        return false;
    }

    String searchPath(String Topic){
        SQLiteDatabase db = this.getReadableDatabase();
        if(checkexists(Topic)){
            Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL_5+" = ?", new String[]{Topic}, null);
            path = cursor.toString();
        }
        return path;
    }
}