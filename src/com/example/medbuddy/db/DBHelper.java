package com.example.medbuddy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper
{
	/*Database information*/
	static final String dbName="medbuddy";
	private static final int DATABASE_VERSION = 1;
	
	/*Parent Table*/
	static final String parentTable="Parents";
	static final String colParentIndex="parentIndex";
	static final String colParentUserID="puserID";
	static final String colParentPassword="ppassword";
	static final String colEmail="email";
	static final String colName="Name";
	static final String colPhoneNum="phoneNum";

	/*Child Table*/
	static final String childTable="Children";
	static final String colChildIndex="childIndex";
	static final String colChildName="childName";
	static final String colChildAge="childAge";
	static final String colChildUserID="cuserID";
	static final String colChildPassword="cpassword";
	static final String colRewardPoint="rewardPoint";
	static final String colPendingPoint="pendingPoint";
	
	/*Avatar Table*/
	static final String avatarTable="Avatars";
	static final String colAvatarID="avatarID";
	static final String colHealth="health";
	static final String colClean="clean";
	static final String colFun="fun";
	
	/*Medication Table*/
	static final String medicationTable="Medications";
	static final String colMedID="medID";
	static final String colMedName="name";
	static final String colMedAmount="amount";
	static final String colMedDosage="dosage";
	static final String colMedForm="form";
	static final String colMedStatus="status";

	/*Reward Item Table*/
	static final String rewardItemTable="RewardItems";
	static final String colRWItemIndex="itemIndex";
	static final String colRWItemName="itemName";
	static final String colRWPoint="points";
	static final String colDescription="desprition";
	
	/*Reminder Table*/
	static final String reminderTable="Reminder";
	static final String colReminderID="reminderID";
	static final String colTime="time";
	
	/*Parent Child Relation Table*/
	static final String ParentChildRelateTable="ParentChildRelation";
	static final String PCRParentIndex="pcrParentIndex";
	static final String PCRChildIndex="pcrChildIndex";
	static final String PCRMedID="pcrMedID";
	
	/*Child Avatar Table*/
	static final String ChildAvatarRelateTable="ChildAvatarRelation";
	static final String CARChildIndex="carChildIndex";
	static final String CARAvatarID="carAvatarID";
	
	/*Child Reward Item Table*/
	static final String childRewardTable="ChildRewardRelation";
	static final String CRRChildIndex="crrChildIndex";
	static final String CRRItemIndex="crrItemIndex";
	
	/*Medication Reminder Table*/
	static final String MedReminderRelateTable="MedicationReminderRelation";
	static final String MRRMedID="mrrMedID";
	static final String MRRReminderID="mrrReminderID";

	private static final String DATABASE_CREATE =
		"create table users (_id integer primary key autoincrement, "
		+ "username text not null, "
		+ "password text not null);";

	private Context context = null;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBHelper(Context ctx)
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, dbName, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			/*create  parent table*/
			db.execSQL("CREATE TABLE " + parentTable + "(" 
					+ colParentIndex + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colParentUserID + " TEXT, "
					+ colParentPassword + " TEXT, "
					+ colEmail + " TEXT, "
					+ colName + " TEXT, "
					+ colPhoneNum + " TEXT);");
			
			/*create child table*/
			db.execSQL("CREATE TABLE " + childTable + "("
					+ colChildIndex + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colChildUserID + " TEXT, "
					+ colChildPassword + " TEXT, "
					+ colChildName + " TEXT, "
					+ colChildAge + " INTEGER, "
					+ colRewardPoint + " INTEGER, "
					+ colPendingPoint + " INTEGER);");
			
			/*create avatar table*/
			db.execSQL("CREATE TABLE " + avatarTable + "("
					+ colAvatarID + " INTEGER PRIMARY KEY, "
					+ colHealth + " INTEGER, "
					+ colClean + " INTEGER, "
					+ colFun + " INTEGER);");
			
			/*create medication table*/
			db.execSQL("CREATE TABLE " + medicationTable + "("
					+ colMedID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colMedName + " TEXT, "
					+ colMedAmount + " INTEGER, "
					+ colMedDosage + " TEXT, "
					+ colMedForm + " TEXT, "
					+ colMedStatus + " TEXT);");
			
			/*create reward item table*/
			db.execSQL("CREATE TABLE " + rewardItemTable + "("
					+ colRWItemIndex + " INTEGER PRIMARY KEY, "
					+ colRWItemName + " TEXT, "
					+ colRWPoint + " INTEGER, "
					+ colDescription + " TEXT);");
			
			/*create reminder table*/
			db.execSQL("CREATE TABLE " + reminderTable +"("
					+ colReminderID + " INTEGER PRIMARY KEY, "
					+ colTime + " TEXT);");
					
			/*crate parent child relation table*/
			db.execSQL("CREATE TABLE " + ParentChildRelateTable + "("
					+ PCRParentIndex + " INTEGER PRIMARY KEY, "
					+ PCRChildIndex + " INTEGER, "
					+ PCRMedID + " INTEGER);");
			
			/*create child avatar relation table*/
			db.execSQL("CREATE TABLE " + ChildAvatarRelateTable + "("
					+ CARChildIndex + " INTEGER PRIMARY KEY, "
					+ CARAvatarID + " INTEGER);");
			
			/*create child reward relation table*/
			db.execSQL("CREATE TABLE " + childRewardTable + "("
					+ CRRChildIndex + " INTEGER PRIMARY KEY, "
					+ CRRItemIndex + " INTEGER);");
			
			/*create medication reminder table*/
			db.execSQL("CREATE TABLE " + MedReminderRelateTable + "("
					+ MRRMedID + " INTEGER PRIMARY KEY, "
					+ MRRReminderID + " INTEGER);");
			
			
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			 db.execSQL("DROP TABLE IF EXISTS "+parentTable);
			 db.execSQL("DROP TABLE IF EXISTS "+childTable);
			 db.execSQL("DROP TABLE IF EXISTS "+avatarTable);
			 db.execSQL("DROP TABLE IF EXISTS "+medicationTable);
			 db.execSQL("DROP TABLE IF EXISTS "+rewardItemTable);
			 db.execSQL("DROP TABLE IF EXISTS "+reminderTable);
			 db.execSQL("DROP TABLE IF EXISTS "+ParentChildRelateTable);
			 db.execSQL("DROP TABLE IF EXISTS "+ChildAvatarRelateTable);
			 db.execSQL("DROP TABLE IF EXISTS "+childRewardTable);
			 db.execSQL("DROP TABLE IF EXISTS "+MedReminderRelateTable);
			 
			 onCreate(db);
			
		}
	}    

	public void open() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
	}

	public void close()
	{
		DBHelper.close();
	}    

	/**
	 * insert parent user
	 * @param email
	 * @param username
	 * @param password
	 * @param phoneNum
	 * @param name
	 * @return -1 with error, otherwise, not -1
	 */
	public long insertParent(String email, String username, String password, String phoneNum, String name)
	{
		ContentValues initialValues = new ContentValues();  
		initialValues.put(colEmail, email); 
        initialValues.put(colParentUserID, username);  
        initialValues.put(colParentPassword, password);  
        initialValues.put(colPhoneNum, phoneNum);
        initialValues.put(colName, name); 
       // return db.insertOrThrow(parentTable, null, initialValues);
        return db.insert(parentTable, null, initialValues);  
	}

	/**
	 * insert a child user
	 * @param username
	 * @param password
	 * @param name
	 * @param age
	 * @return -1 with error, otherwise, not -1
	 */
	//TODO:update relation table
	public long insertChild(String username, String password, String name, String age)
	{
		ContentValues initialValues = new ContentValues(); 
		initialValues.put(colChildUserID, username);
		initialValues.put(colChildPassword, password);
		initialValues.put(colChildName, name);
		initialValues.put(colChildAge, age);
		return db.insert(childTable, null, initialValues); 
	}
	
	/**
	 * 
	 * @param medName
	 * @param medAmount
	 * @param medDosage
	 * @param medForm
	 * @return
	 */
	public long insertMedicine(String medName, String medAmount, String medDosage, String medForm)
	{
		ContentValues initialValues = new ContentValues(); 
		initialValues.put(colMedName, medName);
		initialValues.put(colMedAmount, Integer.parseInt(medAmount));
		initialValues.put(colMedDosage, medDosage);
		initialValues.put(colMedForm, medForm);
		initialValues.put(colMedStatus, false);
		return db.insert(medicationTable, null, initialValues); 
	}
	
	/**
	 * Login authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean LoginParent(String username, String password) {
		Cursor mCursor = db.rawQuery("SELECT * FROM " + parentTable + " WHERE puserID=? AND ppassword=?", new String[]{username,password});  
        if (mCursor != null) {  
            if(mCursor.getCount() > 0)  
            {  
                return true;  
            }  
        }  
     return false; 
	}

	/**
	 * fetch all children from the database
	 * @return the cursor point to the first child
	 */
	public Cursor fetchAllChilds() {
        return db.query(childTable, new String[] {colChildIndex, colChildName, colChildAge,
                colChildUserID, colChildPassword}, null, null, null, null, null);
		//return null;
    }

	public Cursor fetchAllMeds() {
		Cursor cur = db.rawQuery("SELECT "+ colMedID + " as _id, " + colMedName + " from "+medicationTable, new String[]{});
		return cur;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean LoginChild(String username, String password) {
		Cursor mCursor = db.rawQuery("SELECT * FROM " + childTable + " WHERE cuserID=? AND cpassword=?", new String[]{username,password});  
        if (mCursor != null) {  
            if(mCursor.getCount() > 0)  
            {  
                return true;  
            }  
        }  
     return false; 
	}
	
}
