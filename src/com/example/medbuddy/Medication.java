package com.example.medbuddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Medication extends ListFragment {
	 public Button addmedButton;
	 public android.view.View.OnClickListener onClickListener;
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getData(),R.layout.activity_medication_list,
                  new String[]{"title","info","img"},
                  new int[]{R.id.title,R.id.info,R.id.img});
          setListAdapter(adapter);
         /* addmedButton=(Button)getActivity().findViewById(R.id.b_addmed);
          onClickListener=new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getActivity(), Activity_p_add_child.class);
				startActivity(intent);
			}
		};*/

          
          
     }
     
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
    	 
    	 	View view=inflater.inflate(R.layout.activity_medication_main, container, false);
    	 	Button addmedButton=(Button)view.findViewById(R.id.b_addmed);
    	 	
            onClickListener=new android.view.View.OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Intent intent=new Intent();
  				intent.setClass(getActivity(), Add_Medication.class);
  				startActivity(intent);
  			}
  		};
  			addmedButton.setOnClickListener(onClickListener);
    	 	return view;
     }
     
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "Adderall");
         map.put("info", "9:00am 3:00pm");
         map.put("img", R.drawable.med1);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Ritalin");
         map.put("info", "12:00pm");
         map.put("img", R.drawable.med2);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Vyvanse");
         map.put("info", "12:00pm 6:00pm");
         map.put("img", R.drawable.med3);
         list.add(map);
          
         return list;
     }
      
     public void onListItemClick(ListView parent, View v,   
     int position, long id)   
     {            
   
     }    

	
}