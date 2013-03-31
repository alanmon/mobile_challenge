package com.example.medbuddy;

import com.example.medbuddy.db.DBHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;

public class RegisterActivity extends Activity {
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Register");
        actionBar.setDisplayHomeAsUpEnabled(true); //go back to the parent activity

        final EditText txt_email = (EditText)findViewById(R.id.txt_email);
        final EditText txt_userName = (EditText)findViewById(R.id.txt_pUsername);
        final EditText txt_password = (EditText)findViewById(R.id.txt_pPassword);
        final EditText txt_confirmPassword = (EditText)findViewById(R.id.txt_confirmPassword);
        final EditText txt_phoneNum = (EditText)findViewById(R.id.txt_phoneNum);
        final EditText txt_name = (EditText)findViewById(R.id.txt_name);
        
        Button signUp = (Button) findViewById(R.id.but_signUp);
        signUp.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v){
        		
        		String email = txt_email.getText().toString();
        		String username = txt_userName.getText().toString();
        		String password = txt_password.getText().toString();
        		String confirmPassword = txt_confirmPassword.getText().toString();
        		String phoneNum = txt_phoneNum.getText().toString();
        		String name = txt_name.getText().toString();
        		
        		if(check(email, username, password, confirmPassword))
        		{
        			DBHelper db = new DBHelper(RegisterActivity.this);
            		db.open();
            		long i = db.insertParent(email, username, password, phoneNum, name);
            		if(i != -1)
            		{
            			Toast.makeText(RegisterActivity.this,"Register Successfully", Toast.LENGTH_LONG).show();
            			Intent myIntent = new Intent(v.getContext(), ActivityLogin.class);
			            startActivityForResult(myIntent, 0);
            		}
            		else
            			Toast.makeText(RegisterActivity.this,"Error", Toast.LENGTH_LONG).show();
        		}  		
        	}
        });
        
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, ActivityLogin.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	/**
	 * Hide the soft keyboard when edittext or button is not focused.
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {

	    View v = getCurrentFocus();
	    boolean ret = super.dispatchTouchEvent(event);

	    if (v instanceof EditText) {
	        View w = getCurrentFocus();
	        int scrcoords[] = new int[2];
	        w.getLocationOnScreen(scrcoords);
	        float x = event.getRawX() + w.getLeft() - scrcoords[0];
	        float y = event.getRawY() + w.getTop() - scrcoords[1];

	        Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
	        if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) { 

	            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	            imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
	        }
	    }
	return ret;
	}
	
	/**
	 * Check the information user entered in
	 * @param email - email address
	 * @param username - user name
	 * @param password - password
	 * @param confirmPassword - confirm password, should match password
	 * @return false if any of these information is empty or password does not match, otherwise true
	 */
	private boolean check(String email, String username, String password, String confirmPassword)
	{
		if(email.isEmpty())
		{
			Toast.makeText(RegisterActivity.this,"Email could not be empty", Toast.LENGTH_LONG).show();
			return false;
		}
		else if(username.isEmpty())
		{
			Toast.makeText(RegisterActivity.this,"Username could not be empty", Toast.LENGTH_LONG).show();
			return false;
		}
		else if(password.isEmpty())
		{
			Toast.makeText(RegisterActivity.this,"Password could not be empty", Toast.LENGTH_LONG).show();
			return false;
		}
		else if(confirmPassword.isEmpty() || !password.matches(confirmPassword))
		{
			Toast.makeText(RegisterActivity.this,"Password does not match", Toast.LENGTH_LONG).show();
			return false;
		}
		else
			return true;
	}
}
