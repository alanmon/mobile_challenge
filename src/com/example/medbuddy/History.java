package com.example.medbuddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class History extends ListFragment {
	private List<String> list = new ArrayList<String>();
	   private ListView listView = null;
	private List<String> listTag = new ArrayList<String>();
	private GroupListAdapter groupListAdapter=null;
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          //SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getData(),R.layout.activity_medication_list,
            //      new String[]{"title","info","img"},
              //    new int[]{R.id.title,R.id.info,R.id.img});
          setData();
          groupListAdapter=new GroupListAdapter(getActivity(), list, listTag);
          setListAdapter(groupListAdapter);
     }
     
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        
         return inflater.inflate(R.layout.activity_history, container, false);
     }
     
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "G1");
         map.put("info", "google 1");
         map.put("img", R.drawable.btn_history);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "G2");
         map.put("info", "google 2");
         map.put("img", R.drawable.btn_log);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "G3");
         map.put("info", "google 3");
         map.put("img", R.drawable.btn_med);
         list.add(map);
          
         return list;
     }
      
     public void onListItemClick(ListView parent, View v,   
     int position, long id)   
     {            
   
     }    
     
     public void setData(){
         list.add("March 23 2013");
         listTag.add("March 23 2013");
         list.add("Ritalin              Taken at 10:00am");
         list.add("Adderall            Taken at 10:13pm");
         list.add("March 22 2013");
         listTag.add("March 22 2013");
         list.add("Ritalin              Taken at 10:00am");
         list.add("Adderall            Missed");
         list.add("Vyvasan            Taken at 3:30pm");
        
         list.add("March 21 2013");
         listTag.add("March 21 2013");
         list.add("Ritalin              Taken at 10:00am");
         list.add("Adderall            Taken at 10:15pm");
 }
     private static class GroupListAdapter extends ArrayAdapter<String>{
         
         private List<String> listTag = null;
         public GroupListAdapter(Context context, List<String> objects, List<String> tags) {
             super(context, 0, objects);
             this.listTag = tags;
         }
          
         @Override
         public boolean isEnabled(int position) {
             if(listTag.contains(getItem(position))){
                 return false;
             }
             return super.isEnabled(position);
         }
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             View view = convertView;
             if(listTag.contains(getItem(position))){
                 view = LayoutInflater.from(getContext()).inflate(R.layout.list_tag_layout, null);
                 TextView textView = (TextView) view.findViewById(R.id.group_list_item_text);
                 textView.setText(getItem(position));
             }else{                    
                 view = LayoutInflater.from(getContext()).inflate(R.layout.list_history, null);
                 TextView textView = (TextView) view.findViewById(R.id.list_history);
                 textView.setText(getItem(position));
             }
             
             return view;
         }
     }
	
}