package com.example.medbuddy;

import com.example.medbuddy.db.DBHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity_p_add_child extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_add_child);
	    
	    ActionBar actionBar = getActionBar();
        actionBar.setTitle("Add Child User");

        actionBar.setDisplayHomeAsUpEnabled(true); //go back to the parent activity

        
        Bundle extras = getIntent().getExtras();
    	String value = null;
    	if(extras !=null) {
    	value = extras.getString("parent");
    	}
    	Toast.makeText(Activity_p_add_child.this, "ADD is Selected", Toast.LENGTH_SHORT).show();
    	Toast.makeText(Activity_p_add_child.this, value, Toast.LENGTH_SHORT).show();
    	
    	Button doneButton=(Button)findViewById(R.id.childregisterbutton);
    	doneButton.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Activity_p_add_child.this, "Done is Selected", Toast.LENGTH_SHORT).show();
	        	DBHelper db = new DBHelper(Activity_p_add_child.this);
	        	final EditText txt_username = (EditText)findViewById(R.id.txt_ac_username);
	            final EditText txt_password = (EditText)findViewById(R.id.txt_ac_password);
	            final EditText txt_confirmpassword = (EditText)findViewById(R.id.txt_ac_confirmpassword);
	            final EditText txt_name = (EditText)findViewById(R.id.txt_ac_name);
	         
	            String username = txt_username.getText().toString();
	            String password = txt_password.getText().toString();
	            String confirmpassword = txt_confirmpassword.getText().toString();
	            String name = txt_name.getText().toString();

	        	if(check(username, password, confirmpassword))
	        		db.open();
	        		long i = db.insertChild(username, password, name, null);
	        		if(i != -1)
            		{
            			Toast.makeText(Activity_p_add_child.this,"Register Successfully", Toast.LENGTH_LONG).show();
            			Intent myIntent = new Intent(Activity_p_add_child.this, P_childList.class);
			            startActivityForResult(myIntent, 0);
            		}
            		else
            			Toast.makeText(Activity_p_add_child.this,"Error", Toast.LENGTH_LONG).show();
				
				
				
			/*	Intent intent=new Intent();
				intent.setClass(Activity_p_add_child.this,P_childList.class);
				
				
				startActivity(intent);*/
				
			}
		});

	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, P_childList.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	       
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	/**
	 * Check the information user entered in
	 * @param username - user name
	 * @param password - password
	 * @param confirmPassword - confirm password, should match password
	 * @return false if any of these information is empty or password does not match, otherwise true
	 */
	private boolean check(String username, String password, String confirmPassword)
	{
		if(username.isEmpty())
		{
			Toast.makeText(Activity_p_add_child.this,"Username could not be empty", Toast.LENGTH_LONG).show();
			return false;
		}
		else if(password.isEmpty())
		{
			Toast.makeText(Activity_p_add_child.this,"Password could not be empty", Toast.LENGTH_LONG).show();
			return false;
		}
		else if(confirmPassword.isEmpty() || !password.matches(confirmPassword))
		{
			Toast.makeText(Activity_p_add_child.this,"Password does not match", Toast.LENGTH_LONG).show();
			return false;
		}
		else
			return true;
	}
}

