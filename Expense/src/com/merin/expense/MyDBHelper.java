package com.merin.expense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{
private static String DB_USERID = "userDB.db";
	
	
	public MyDBHelper(Context context) {
		super(context, DB_USERID, null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table USERACC (USERID CHAR PRIMARY KEY, PASSWORD TEXT NOT NULL)";
		
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}

}
