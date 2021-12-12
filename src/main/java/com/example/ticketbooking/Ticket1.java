package com.example.ticketbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Ticket1 {
    static final String DB_NAME = "Booking";
    static final int DB_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DB_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";
    //public static String DataBase_CREATE;



    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;
    public  Ticket1(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DB_NAME, null, DB_VERSION);
    }
    public  Ticket1 open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public  void insertEntry(String a, String b) {
        ContentValues Values = new ContentValues();
        // Assign values for each row.
        Values.put("USERNAME", a);
        Values.put("PASSWORD", b);

        // Insert the row into your table

        db.insert("LOGIN", null, Values);
    }

    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String pass= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return pass;
    }



}

