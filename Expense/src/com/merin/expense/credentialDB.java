package com.merin.expense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class credentialDB extends SQLiteOpenHelper{

	public credentialDB(Context context) {
		super(context, "userDB.db", null, 1);
		
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
