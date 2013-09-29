package com.merin.expense;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper {
private static final String DB_NAME = "exptracker.db";
private static int    DB_VERSION = 1;
public static String TABLE_USR = "USERCRED";
public static String TABLE_EXP = "EXPTRACKER";
public static String COL_USERID = "USERID";
public static String COL_PASSWORD = "PASSWORD";
public static String COL_EMAIL = "EMAIL";
private final static String CREATE_USER_TABLE = "create table if not exists "+TABLE_USR+" ("+COL_USERID+" CHAR PRIMARY KEY, "+COL_PASSWORD+" TEXT NOT NULL, "+COL_EMAIL+" CHAR)";
private final static String CREATE_EXP_TABLE =  "create table if not exists "+TABLE_EXP+" (USERID CHAR PRIMARY KEY, PASSWORD TEXT NOT NULL)";	
private final static String TAG = "merin-tag";

		
	

    private static class DatabaseHelper extends SQLiteOpenHelper {
	public DatabaseHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
			// TODO Auto-generated constructor stub
		}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
		try {
			db.execSQL(CREATE_USER_TABLE);
			db.execSQL(CREATE_EXP_TABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG, e.toString());  
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MyDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
		
        db.execSQL("DROP TABLE IF EXISTS USERCRED");
        db.execSQL("DROP TABLE IF EXISTS EXPTRACKER");        
        onCreate(db);
		
	}
    
/*	public void insert(String tname,ContentValues values){
		
	}*/
	
	public ContentValues read(String table_name,String key){
		return null;
		
	}
	


}
    
    //ADD THE OTHER DB HANDLER METHODS BELOW
    
    
}