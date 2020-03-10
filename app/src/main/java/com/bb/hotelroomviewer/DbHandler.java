package com.bb.hotelroomviewer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "hoteldb";
    private static final String TABLE_Guests = "guestdetails";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LOC = "location";
    private static final String COLUMN_DESG = "designation";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Guests + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
                + COLUMN_LOC + " TEXT,"
                + COLUMN_DESG + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Guests);

        onCreate(db);
    }

    void insertUserDetails(String name, String location, String designation) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(COLUMN_NAME, name);
        cValues.put(COLUMN_LOC, location);
        cValues.put(COLUMN_DESG, designation);

        long newRowId = db.insert(TABLE_Guests, null, cValues);
        db.close();
    }
    public void DeleteGuest(int guestid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Guests, COLUMN_ID+" = ?",new String[]{String.valueOf(guestid)});
        db.close();
    }
}
