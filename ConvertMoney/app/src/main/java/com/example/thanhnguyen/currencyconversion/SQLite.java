package com.example.thanhnguyen.currencyconversion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLite extends SQLiteOpenHelper {

    SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void TruyVanKhongTraVe(String sql)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    Cursor TruyVanTraVe(String sql)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.rawQuery(sql, null);
    }

    void InsertXe(String sql, String ten, String xuatxu, Integer gia, String hinh)
    {
        SQLiteDatabase db=getWritableDatabase();
//        String sql="Insert into Xe values (null,?,?,?)";
        SQLiteStatement statement=db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,ten);
        statement.bindString(2,xuatxu);
        statement.bindLong(3,gia);
        statement.bindString(4,hinh);
        statement.executeInsert();
    }
}
