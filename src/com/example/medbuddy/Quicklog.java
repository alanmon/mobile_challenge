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

public class Quicklog extends ListFragment {
 
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getData(),R.layout.list_log,
                  new String[]{"title","info","img","button"},
                  new int[]{R.id.log_title,R.id.log_info,R.id.log_img,R.id.log_button});
          setListAdapter(adapter);
     }
     
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        
         return inflater.inflate(R.layout.activity_history, container, false);
     }
     
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "Adderall");
         map.put("info", "Taken at 8:00am");
         map.put("img", R.drawable.med1);
         map.put("button", R.drawable.confirm);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Ritalin");
         map.put("info", "Taken at 10:00am");
         map.put("img", R.drawable.med2);
         map.put("button", R.drawable.confirm);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Vyvanse");
         map.put("info", "Taken at 10:48am");
         map.put("img", R.drawable.med3);
         map.put("button", R.drawable.missed);
         list.add(map);
          
         return list;
     }
      
     public void onListItemClick(ListView parent, View v,   
     int position, long id)   
     {            
   
     }    

	
}