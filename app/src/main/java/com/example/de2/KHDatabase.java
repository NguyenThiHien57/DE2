package com.example.de2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class KHDatabase extends SQLiteOpenHelper {

    public KHDatabase(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cauTruyVAn = "CREATE TABLE IF NOT EXISTS KH(ID INTEGER PRIMARY KEY AUTOINCREMENT,tenKH text,soLuong text,Nguon text,Dich text )";
        db.execSQL(cauTruyVAn);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ThemKH(KHModel KHnew) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenKH", KHnew.getTenKH());
        values.put("soLuong", KHnew.getSoLuong());
        values.put("Nguon", KHnew.getNguon());
        values.put("Dich", KHnew.getDich());

        try {
            database.insert("KH", null, values);
        } catch (Exception e) {
            Log.d("TAG", "ThemKH" + e.getMessage());
        }
        database.close();
    }
    public Cursor HT(){
        String layDL = "SELECT * FROM KH";
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(layDL,null);
    }
//    public int XoaKH(int ID) {
//        SQLiteDatabase database = getWritableDatabase();
//        return database.delete(TABLE_NAME, ID + "  = ? ", new String[]{String.valueOf(ID)});
//    }
}
