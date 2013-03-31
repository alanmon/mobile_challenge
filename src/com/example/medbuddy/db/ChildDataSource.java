package com.example.medbuddy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * ChildDataSource is a helper class to get child information from the database
 * @author hongyu
 *
 */

public class ChildDataSource {
	// Database fields
	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = { dbHelper.colChildIndex,
			dbHelper.colChildName };

	public ChildDataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	/**
	 * Open database
	 */
	public void open() {
		dbHelper.open();
	}

	/**
	 * Close database
	 */
	public void close() {
		dbHelper.close();
	}

	/**
	 * get all children's names from the database
	 * @return a list of children's name
	 */
	public List<Child> getAllChildNames() {
		List<Child> children = new ArrayList<Child>();

		Cursor cursor = dbHelper.fetchAllChilds();
		if(cursor != null)
		{
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Child child = cursorToChild(cursor);
				children.add(child);
				cursor.moveToNext();
			}
			// Make sure to close the cursor
			cursor.close();
		}
		
		return children;
	}
		
	public List<Map<String, Object>> getAllChild() {
		List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();

		Cursor cursor = dbHelper.fetchAllChilds();
		if(cursor != null)
		{
			cursor.moveToFirst();
			Map<String, Object> map = new HashMap<String, Object>();
			while (!cursor.isAfterLast()) {
				Child child = cursorToChild(cursor);

		        map.put("name", child.getName());
		        children.add(map);
				cursor.moveToNext();
			}
			// Make sure to close the cursor
			
			cursor.close();
		}
		
		return children;
	}
	/**
	 * get the current child the cursor is pointing to
	 * @param cursor 
	 * @return the child
	 */
	private Child cursorToChild(Cursor cursor) {
		Child child = new Child();
		child.setId(cursor.getLong(0));
		child.setName(cursor.getString(3));
		return child;
	}
}
