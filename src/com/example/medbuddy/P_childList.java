package com.example.medbuddy;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import com.example.medbuddy.db.Child;
import com.example.medbuddy.db.ChildDataSource;
import com.example.medbuddy.db.DBHelper;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;


import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.ListView;
import android.widget.SimpleAdapter;

public class P_childList extends ListActivity  {

	private ChildDataSource datasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p_child_list_main);
		ActionBar actionBar=getActionBar();
		actionBar.setTitle("Child List");
		actionBar.setDisplayHomeAsUpEnabled(true);
		datasource = new ChildDataSource(this);
        datasource.open();
        
        class AddchildListener implements android.view.View.OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(P_childList.this, Activity_p_add_child.class);
				startActivity(intent);
			}	
        }
       
        
        Button addChildButton=(Button)findViewById(R.id.b_addchild);
        addChildButton.setOnClickListener(new AddchildListener());
     
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity_child_listview,
                new String[]{"name"},
                new int[]{R.id.childName});
        setListAdapter(adapter);
        
        //List<com.example.medbuddy.db.Child> values = datasource.getAllChildNames();
        ListView listView=getListView();
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String name=(String) getData().get(arg2).get("title");
				 Intent intent=new Intent();
				 intent.putExtra("ChildName", name);
				 intent.setClass(P_childList.this,P_childContralPanel.class);
				 startActivity(intent);		
			}
        
        });
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.p_child_list, menu);
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
	

		
	
	private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        
        datasource = new ChildDataSource(this);
        datasource.open();
        
        
       
        List<Map<String, Object>> values = datasource.getAllChild();
 
    /*  Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "child1");
        map.put("info", "google 1");
        map.put("img", R.drawable.ic_launcher);
        list.add(map);
 
        map = new HashMap<String, Object>();
        map.put("title", "child2");
        map.put("info", "google 2");
        map.put("img", R.drawable.ic_launcher);
        list.add(map);
 
        map = new HashMap<String, Object>();
        map.put("title", "child3");
        map.put("info", "google 3");
        map.put("img", R.drawable.ic_launcher);
        list.add(map);
         */
        return values;
    }
}