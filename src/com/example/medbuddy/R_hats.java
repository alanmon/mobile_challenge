package com.example.medbuddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class R_hats extends ListFragment {
 
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getData(),R.layout.activity_r_event,
                  new String[]{"title","info","img"},
                  new int[]{R.id.title,R.id.info,R.id.img});
          setListAdapter(adapter);
     }
     
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        
         return inflater.inflate(R.layout.r_event_bg, container, false);
     }
     
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "Movie-Crood");
         map.put("info", "300 points");
         map.put("img", R.drawable.reward_croods);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Movie-OZ");
         map.put("info", "300 points");
         map.put("img", R.drawable.reward_croods);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Wii-Lego City");
         map.put("info", "1000 points");
         map.put("img", R.drawable.reward_lego);
         list.add(map);
         
         map = new HashMap<String, Object>();
         map.put("title", "Wii-Just Dance 4");
         map.put("info", "1200 points");
         map.put("img", R.drawable.reward_just_dance);
         list.add(map);
          
         return list;
     }
      
     public void onListItemClick(ListView parent, View v,   
     int position, long id)   
     {            
   
     }    

	
}
