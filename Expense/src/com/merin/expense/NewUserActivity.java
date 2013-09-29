package com.merin.expense;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends Activity {

	private MyDBHelper dbHelper;
	private SQLiteDatabase db;
	//private Button ok_button; 
	private Button reset_button;
	private EditText email_edittext;
	private EditText user_edittext;
	private EditText pass_edittext;
	private EditText pass1_edittext;
	
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
		
		Button ok_button = (Button) findViewById(R.id.nuser_ok_button);
		reset_button = (Button) findViewById(R.id.nuser_reset_button);
		email_edittext = (EditText) findViewById(R.id.email_edittext);
		user_edittext = (EditText) findViewById(R.id.user_edittext);
		pass_edittext = (EditText) findViewById(R.id.pass_edittext);
		pass1_edittext = (EditText) findViewById(R.id.pass_edittext1);
		
		dbHelper = new MyDBHelper(this);
		//sample1();
		
		ok_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String a = pass_edittext.getText().toString();
				String b = pass1_edittext.getText().toString();
				
				if (a.equals(b)){
				db = dbHelper.getWritableDatabase();
				ContentValues cv = new ContentValues();
				cv.put(MyDBHelper.COL_USERID, user_edittext.getText().toString());
				cv.put(MyDBHelper.COL_PASSWORD, pass_edittext.getText().toString());
				cv.put(MyDBHelper.COL_EMAIL, email_edittext.getText().toString());
				db.insert(MyDBHelper.TABLE_USR, null, cv);
				}else{
					System.out.println("pass different");
				}
			}
		});

		reset_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
