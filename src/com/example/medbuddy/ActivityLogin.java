package com.example.medbuddy;

import com.example.medbuddy.db.DBHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.MotionEvent;
import android.view.inputmethod.*;
import android.content.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;


/**
 * 
 * @author hongyu
 *
 */

public class ActivityLogin extends Activity {
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);
    
    final EditText txt_userName = (EditText)findViewById(R.id.txt_userName);
    final EditText txt_password = (EditText)findViewById(R.id.txt_password);
    
    

    /*set active bar title*/
    this.setTitle("MedBuddy");
    
    /*Login Authentication*/
    Button butLogin = (Button)findViewById(R.id.but_login);
    butLogin.setOnClickListener(new OnClickListener(){
    	
    	@Override
    	public void onClick(View v){
    		String username = txt_userName.getText().toString();
    		String password = txt_password.getText().toString();
    		
    		try{
    			if(username.length() > 0 && password.length() > 0)
    			{
    				DBHelper db = new DBHelper(ActivityLogin.this);
    				db.open();
    				
    				if(db.LoginParent(username, password))
					{
						Toast.makeText(ActivityLogin.this,"Successfully Logged In As Parent", Toast.LENGTH_LONG).show();
						Intent myIntent = new Intent(v.getContext(), P_childList.class);
			            //pass parent username to the next activity
			            myIntent.putExtra("parent",txt_userName.getText().toString());
			            startActivityForResult(myIntent, 0);
					}
    				else if(db.LoginChild(username, password))
    				{
    					Toast.makeText(ActivityLogin.this,"Successfully Logged In As Child", Toast.LENGTH_LONG).show();
						Intent myIntent = new Intent(v.getContext(), C_mainActivity.class);
			            //pass parent username to the next activity
			            myIntent.putExtra("child",txt_userName.getText().toString());
			            startActivityForResult(myIntent, 0);
    				}
    				else{
						Toast.makeText(ActivityLogin.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
					}
					db.close();
    			}
    		}catch(Exception e)
    		{
    			Toast.makeText(ActivityLogin.this,e.getMessage(), Toast.LENGTH_LONG).show();
    		}
    	}
    });
    
    /*Forward to Sign Up Activity*/
    Button signUp = (Button) findViewById(R.id.but_signUp);
    signUp.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), RegisterActivity.class);
            startActivityForResult(myIntent, 0);
        }

    });
    
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
}