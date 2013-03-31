package com.example.medbuddy;


import android.os.Bundle;
import android.os.SystemClock;
import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class C_mainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_main_interface);
		//requestWindowFeature(Window.FEATURE_NO_TITLE); 
		
		ActionBar actionBar = getActionBar();
        actionBar.setTitle("Medbuddy");
        actionBar.setDisplayHomeAsUpEnabled(true); //go back to the parent activity
        
		final ImageView avatar = (ImageView)findViewById(R.id.image_avatar);
		
		ImageButton b_rewardShop = (ImageButton)findViewById(R.id.b_reward_shop);
		 b_rewardShop.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View view) {
		            Intent myIntent = new Intent(view.getContext(), RewardShop.class);
		            startActivityForResult(myIntent, 0);
		        }

		    });
		 ImageView quizTimer = (ImageView)findViewById(R.id.quiztimer);
		 quizTimer.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View view) {
		            Intent myIntent = new Intent(view.getContext(), C_quiz.class);
		            startActivityForResult(myIntent, 0);
		        }
		 });
		 //click the take med area, then perform eat med
		 LinearLayout layout_takemedLayout = (LinearLayout)findViewById(R.id.takemed);
		 layout_takemedLayout.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View view) {
		            avatar.setImageResource(R.drawable.monster2);
		        }
		 });
		 
		 avatar.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View view) {
		        	//SystemClock.sleep(2000);
		        	avatar.setImageResource(R.drawable.monster3);
		            //long time = SystemClock.elapsedRealtime();
		            //long stop = time+3000;
		            //int i =0;
		            /*
		            while(stop > SystemClock.elapsedRealtime())
		            {

		            	i++;
		            	Toast.makeText(C_mainActivity.this,Integer.toString(i), Toast.LENGTH_LONG).show();
		            }
		            Toast.makeText(C_mainActivity.this,"out", Toast.LENGTH_LONG).show();
		            */
		            //SystemClock.sleep(3000);
		            //avatar.setImageResource(R.drawable.monster1);
		        }
		 });
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_main, menu);
		return true;
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

}
