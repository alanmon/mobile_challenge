package com.example.medbuddy;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class C_quiz extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_quiz);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		LinearLayout answer1 = (LinearLayout)findViewById(R.id.answer1);
		answer1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent myIntent = new Intent(view.getContext(), C_mainActivity.class);
	            startActivityForResult(myIntent, 0);
	        }
	    });
		LinearLayout answer2 = (LinearLayout)findViewById(R.id.answer2);
		answer2.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent myIntent1 = new Intent(view.getContext(), C_mainActivity.class);
	            startActivityForResult(myIntent1, 0);
	        }

	    });
		LinearLayout answer3 = (LinearLayout)findViewById(R.id.answer3);
		answer3.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent myIntent2 = new Intent(view.getContext(), C_mainActivity.class);
	            startActivityForResult(myIntent2, 0);
	        }

	    });
		LinearLayout answer4 = (LinearLayout)findViewById(R.id.answer4);
		answer4.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	//TextView points = (TextView)findViewById(R.id.points);
	        	//String temp = points.getText().toString();
	        	//int c_point = Integer.parseInt(temp)+50;
	        	//points.setText(Integer.toString(c_point));
	            Intent myIntent3 = new Intent(view.getContext(), C_mainActivity.class);
	            startActivityForResult(myIntent3, 0);
	        }

	    });
	   
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
