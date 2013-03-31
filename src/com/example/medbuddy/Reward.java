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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Reward extends ListFragment {
 
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getData(),R.layout.activity_medication_list,
                  new String[]{"title","info","img"},
                  new int[]{R.id.title,R.id.info,R.id.img});
          setListAdapter(adapter);
     }
     
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
    	 
    	 View v=inflater.inflate(R.layout.activity_reward, container, false);
    	 Button addmedButton=(Button)v.findViewById(R.id.b_addrew);
 	 	
         OnClickListener onClickListener=new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getActivity(), Add_Reward.class);
				startActivity(intent);
			}
		};
			addmedButton.setOnClickListener(onClickListener);
         return v;
     }
     
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "Toy-Lego");
         map.put("info", "300 points");
         map.put("img", R.drawable.reward_lego);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Movie-Croods");
         map.put("info", "200 points");
         map.put("img", R.drawable.reward_croods);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Wii Game-Just Dance 4");
         map.put("info", "350 points");
         map.put("img", R.drawable.reward_just_dance);
         list.add(map);
          
         return list;
     }
      
     public void onListItemClick(ListView parent, View v,   
     int position, long id)   
     {            
   
     }    

	
}
