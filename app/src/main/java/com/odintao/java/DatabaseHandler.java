package com.odintao.java;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.odintao.model.ObjectFav;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 4/17/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Flower";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Favorite";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //จะเริ่มทำงานทันทีที่มีการเรียกใช้คลาสนี้ แต่จะสร้างครั้งแรกที่ยังไม่มีฐานข้อมูลเท่านั้น ถ้าแก้ไขฐานข้อมูลใหม่
        // ก็จะไม่มีการเรียกซ้ำอีกครั้ง ต้องใช้ onUpgrade แทน หรือจะลบแอพฯแล้วลงใหม่ก็ได้
        db.execSQL("CREATE TABLE Favorite(id INTEGER PRIMARY KEY,imgname TEXT,imageurl TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void AddtoFavorite(ObjectFav paramPojo)
    {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        String query = "SELECT  id FROM " + TABLE_NAME +" where imgname='"+paramPojo.getImageName()+"'";
        Cursor cursor = localSQLiteDatabase.rawQuery(query, null);
        // 3. go over each row, build football and add it to list
        boolean hasObject = false;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                hasObject = true;
            }
            cursor.close();
        }

        if(!hasObject) { // not exits insert new
            localContentValues.put("imgname", paramPojo.getImageName());
            localContentValues.put("imageurl", paramPojo.getImageurl());
            localSQLiteDatabase.insert("Favorite", null, localContentValues);
            localSQLiteDatabase.close();
        }else{
            localSQLiteDatabase.delete("Favorite","imgname='"+paramPojo.getImageName()+"'",null);
        }
    }

    public List<ObjectFav> getAllData()
    {
        ArrayList localArrayList = new ArrayList();
        Cursor localCursor = getWritableDatabase().rawQuery("SELECT  * FROM Favorite", null);
        if (localCursor.moveToFirst()) {
            do
            {
                ObjectFav localPojo = new ObjectFav();
                localPojo.setId(Integer.parseInt(localCursor.getString(0)));
                localPojo.setImageName(localCursor.getString(1));
                localPojo.setImageurl(localCursor.getString(2));
                localArrayList.add(localPojo);
            } while (localCursor.moveToNext());
        }
        return localArrayList;
    }
}
