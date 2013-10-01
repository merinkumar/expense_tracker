package com.merin.expense;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends Activity {

	private MyDBHelper dbHelper;
	private SQLiteDatabase db;
	//private Button ok_button; 
	private Button reset_button;
	private EditText email_edittext;
	private EditText user_edittext;
	private EditText pass_edittext;
	private EditText pass1_edittext;
	private String a;
	private String b;
	private String e;
	private String u;
	private boolean errorS = false;
	
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
		final MyDBHelper myDbAdaptor = new MyDBHelper(this);
		myDbAdaptor.openWrite();
		//sample1();
		
		ok_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = pass_edittext.getText().toString();
				b = pass1_edittext.getText().toString();
				e = email_edittext.getText().toString();
				u = user_edittext.getText().toString();
				
				editFileds();
				
				if (a.equals(b) && !errorS){
				//db = dbHelper.getWritableDatabase();
				ContentValues cv = new ContentValues();
				cv.put(MyDBHelper.COL_USERID, u);
				cv.put(MyDBHelper.COL_PASSWORD, a);
				cv.put(MyDBHelper.COL_EMAIL, e);
				
				long rCode = myDbAdaptor.insertrow(MyDBHelper.TABLE_USR,cv);
				if(rCode != -1){
					Toast.makeText(NewUserActivity.this, "user added", Toast.LENGTH_LONG).show();
					NewUserActivity.this.finish();
				}else{
					System.out.println("insert failed");
				}
				//db.insert(MyDBHelper.TABLE_USR, null, cv);
				}else{
					Toast.makeText(NewUserActivity.this, "incorrect details", Toast.LENGTH_LONG).show();
					System.out.println("pass different");
					
					
				}
			}
		});

		reset_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pass_edittext.setText("");
				pass1_edittext.setText("");
				email_edittext.setText("");
				user_edittext.setText("");
				
			}
		});
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_user, menu);
		return true;
	}
	
	public void editFileds(){
		
		if (e.equals(null) || (e == "") || (e.isEmpty())){
			Toast.makeText(NewUserActivity.this, "Enter email", Toast.LENGTH_LONG).show();
			errorS = true;
		}
		
		if (u.equals(null) || (u == "") || (u.isEmpty())){
			Toast.makeText(NewUserActivity.this, "Enter User ID", Toast.LENGTH_LONG).show();
			errorS = true;
			
		}
		
		if (a.equals(null) || (a == "") || (a.isEmpty())){
			Toast.makeText(NewUserActivity.this, "Password cannt be NULL", Toast.LENGTH_LONG).show();
			errorS = true;
		}
		
		
		
		if (b.equals(null) || (b == "") || (b.isEmpty())){
			Toast.makeText(NewUserActivity.this, "Password cannt be NULL", Toast.LENGTH_LONG).show();
			errorS = true;
		}


		
	}
	


}
