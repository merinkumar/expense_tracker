package com.merin.expense;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class NewUserActivity extends Activity {

	private MyDBHelper dbHelper;
	private SQLiteDatabase db;
	  private String[] allColumns = { MyDBHelper.COL_USERID,MyDBHelper.COL_PASSWORD,MyDBHelper.COL_EMAIL };
	
	/*
	public NewUserActivity(Context context) {
		dbHelper = new MyDBHelper(context);


	}
*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_user);
		dbHelper = new MyDBHelper(this);
		sample1();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_user, menu);
		return true;
	}
	
	public void sample1(){
		db = dbHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(MyDBHelper.COL_USERID, "merin");
		cv.put(MyDBHelper.COL_PASSWORD, "test");
		cv.put(MyDBHelper.COL_EMAIL, "talktomerin@gmail.com");
		db.insert(MyDBHelper.TABLE_USR, null, cv);
		
		//Cursor cursor = db.query(MyDBHelper.TABLE_USR,allColumns, MyDBHelper.COL_USERID + " = merin",null,null,null,null);
		Cursor cursor = db.query(true, MyDBHelper.TABLE_USR, allColumns, null, null, null, null, null, null, null);
		if(cursor != null){
			cursor.moveToFirst();
			System.out.println(cursor.getString(0));
			System.out.println(cursor.getString(1));
			System.out.println(cursor.getString(2));
		}
	}

}
