package com.merin.expense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PwdActivity extends Activity {



	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwd_activity);
        
        /* Now get reference to all the views and components  */
    	EditText userEditText = (EditText) findViewById(R.id.user_edittext);
    	EditText passEditText = (EditText) findViewById(R.id.pass_edittext);
    	Button okButton = (Button) findViewById(R.id.ok_button);
    	TextView fPassText = (TextView) findViewById(R.id.fpassText);
    	TextView nUserText = (TextView) findViewById(R.id.nuserText);
    	
    	
        okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
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
