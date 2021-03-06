package com.merin.expense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PwdActivity extends Activity {


    protected static final int COLOR_RED = 0xffff0000;
	
	



	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwd_activity);
        final MyDBHelper dbHelper = new MyDBHelper(this);
        dbHelper.openRead();    
        
        /* Now get reference to all the views and components  */
    	final EditText userEditText = (EditText) findViewById(R.id.user_edittext);
    	final EditText passEditText = (EditText) findViewById(R.id.pass_edittext);
    	Button okButton = (Button) findViewById(R.id.ok_button);
    	TextView fPassText = (TextView) findViewById(R.id.fpassText);
    	TextView nUserText = (TextView) findViewById(R.id.nuserText);
    	final TextView errorMtext = (TextView) findViewById(R.id.errorMsgText);
    	
    	
        okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean rCode = dbHelper.getuser(dbHelper.TABLE_USR, userEditText.getText().toString(), passEditText.getText().toString());
				if(rCode){
			    	Toast.makeText(PwdActivity.this, "user pass", Toast.LENGTH_LONG).show();
			    	userEditText.setText("");
			    	passEditText.setText("");
					Intent myIntent3 = new Intent(PwdActivity.this,MainActivity.class);
					PwdActivity.this.startActivity(myIntent3);
					finish();
				}else{
					errorMtext.setText("User ID / Pass incorrect");
					errorMtext.setTextColor(COLOR_RED);
				}
			}
		});
        
        fPassText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent myIntent1 = new Intent(PwdActivity.this,ForgotPass.class);
			PwdActivity.this.startActivity(myIntent1);
				
			}
		});
        
        nUserText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent myIntent2 = new Intent(PwdActivity.this,NewUserActivity.class);
			PwdActivity.this.startActivity(myIntent2);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pwd, menu);
        return true;
    }
    
}
