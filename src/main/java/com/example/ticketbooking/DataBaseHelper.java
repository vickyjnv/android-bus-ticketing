package com.example.ticketbooking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(com.example.ticketbooking.Ticket1.DB_CREATE);

    }
    public void onUpgrade(SQLiteDatabase db, int _oldVersion, int _newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+"TEMPLATE");

        onCreate(db);
    }
}