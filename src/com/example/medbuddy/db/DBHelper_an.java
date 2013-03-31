package com.example.medbuddy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_an
{
	/*Database information*/
	static final String dbName="medbuddy";
	private static final int DATABASE_VERSION = 1;
	
	/*Parent Table*/
	static final String parentTable="Parents";
	static final String colParentID="ParentID";
	static final String colParentUserName="ParentUserName";
	static final String colParentPassword="ParentPassword";
	static final String colEmail="Email";
	static final String colParentFirstName="ParentFirstName";
	static final String colParentLastName="ParentLastName";
	static final String colPPhoneNum="ParentPhoneNum";
	static final String colPNewUser = "NewUser";

	/*Child Table*/
	static final String childTable="Children";
	static final String colChildID="ChildID";
	static final String colChildUserName = "ChildUserName";
	static final String colChildPassword="ChildPassword";
	static final String colChildFirstName="ChildFirstName";
	static final String colChildLastName="ChildLastName";
	static final String colChildAge="ChildAge";
//static final String colCPhoneNum="CphoneNum";
	static final String colRewardPoint="RewardPoint";
	static final String colIDParent="IDParent";	
	static final String colCNewUser = "NewUser";
	
	/*Avatar Table*/
	static final String avatarTable="Avatars";
	static final String colAvatarID="AvatarID";
	static final String colHealth="Health";
	static final String colIDChildAvatar="IDChild";
	
	/*Prescription Table*/
	static final String prescriptionTable="Prescriptions";
	static final String colPrescriptionID="PrescriptionID";
	static final String colMedName="MedName";
//static final String colMedAmount="MedAmount";
	static final String colMedFrequency = "MedFrequency";
	static final String colMedDosage="MedDosage";
	static final String colDuration="Duration";
	static final String colMedDescription="MedDescription";
	static final String colIDChildPrescription="IDChild";

	/*MedUsage Table*/
	static final String MedUsageTable="MedUsage";
	static final String colMedUsageID="MedUsageID";
	static final String colDatetime="Datetime";
	static final String colIDPrescription="colIDPrescription";
	static final String colStatus="Status";
	
	/*Reward Item Table*/
	static final String rewardItemTable="RewardItem";
	static final String colRWItemID="ItemID";
	static final String colRWItemName="ItemName";
	static final String colRWPoint="Points";
	static final String colRWDescription="Desprition";
	static final String colIDChildRW="IDChild";
	

	private static final String DATABASE_CREATE =
		"create table users (_id integer primary key autoincrement, "
		+ "username text not null, "
		+ "password text not null);";

	private Context context = null;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBHelper_an(Context ctx)
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
					+ colParentID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colParentUserName + " TEXT, "
					+ colParentPassword + " TEXT, "
					+ colEmail + " TEXT, "
					+ colParentFirstName + " TEXT, "
					+ colParentLastName + " TEXT, "
					+ colPPhoneNum + " TEXT, "
					+ colPNewUser + "BOOLEAN);");
			
			/*create child table*/
			db.execSQL("CREATE TABLE " + childTable + "("
					+ colChildID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colChildUserName + " TEXT, "
					+ colChildPassword + " TEXT, "
					+ colChildFirstName + " TEXT, "
					+ colChildLastName + " TEXT, "
					+ colChildAge + " INTEGER, "
					+ colRewardPoint + " INTEGER, "
//+ colCPhoneNum + "TEXT, "
					+ colIDParent + "INTEGER, "
					+ colCNewUser + " BOOLEAN);");
			
			/*create avatar table*/
			db.execSQL("CREATE TABLE " + avatarTable + "("
					+ colAvatarID + " INTEGER PRIMARY KEY, "
					+ colHealth + " INTEGER, "
					+ colIDChildAvatar + " INTEGER);");

			
			/*create prescription table*/
			db.execSQL("CREATE TABLE " + prescriptionTable + "("
					+ colPrescriptionID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ colMedName + " TEXT, "
//+ colMedAmount + " INTEGER, "
					+ colMedFrequency + " TEXT, "
					+ colMedDosage + " INTEGER, "
					+ colDuration + " INTEGER, "
					+ colIDChildPrescription + "INTEGER, "
					+ colMedDescription + " TEXT);");
			
			/*create MedUsageTable table*/
			db.execSQL("CREATE TABLE " + MedUsageTable + "("
					+ colMedUsageID + " INTEGER PRIMARY KEY, "
					+ colDatetime + " TEXT, "
					+ colIDPrescription + " INTEGER, "
					+ colStatus + " INTEGER);");
			
			/*create reward item table*/
			db.execSQL("CREATE TABLE " + rewardItemTable + "("
					+ colRWItemID + " INTEGER PRIMARY KEY, "
					+ colRWItemName + " TEXT, "
					+ colRWPoint + " INTEGER, "
					+ colIDChildRW + "INTEGER,"
					+ colRWDescription + " TEXT);");	
			
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			 db.execSQL("DROP TABLE IF EXISTS "+parentTable);
			 db.execSQL("DROP TABLE IF EXISTS "+childTable);
			 db.execSQL("DROP TABLE IF EXISTS "+avatarTable);
			 db.execSQL("DROP TABLE IF EXISTS "+prescriptionTable);
			 db.execSQL("DROP TABLE IF EXISTS "+rewardItemTable);
			 db.execSQL("DROP TABLE IF EXISTS "+MedUsageTable);
			 
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
	 * @param firstName
	 * @param lastName
	 * @return -1 with error, otherwise, not -1
	 */
	public long insertParent(String username, String email, String password, String firstName, String lastName, String phoneNum)
	{
		if(username == "null" || password =="null" || email == "null"){
			return -1;
		}
		else{
			ContentValues initialValues = new ContentValues();  
	        initialValues.put(colParentUserName, username);  
	        initialValues.put(colParentPassword, password);  
			initialValues.put(colEmail, email); 
			initialValues.put(colParentFirstName, firstName);
			initialValues.put(colParentLastName, lastName);
	        initialValues.put(colPPhoneNum, phoneNum);
	        initialValues.put(colPNewUser, true); 
	       // return db.insertOrThrow(parentTable, null, initialValues);
	        return db.insert(parentTable, null, initialValues);  
		}
	}

	/**
	 * insert a child user
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return -1 with error, otherwise, not -1
	 */
	//TODO:update relation table
	public long insertChild( String username, String password, String firstName, String lastName, String age, Integer rewardPoint, Integer parentID)
	{
		if(username == "null" || password == "null" || parentID == 0){
			return -1;
		}
		else{
			ContentValues initialValues = new ContentValues(); 
			initialValues.put(colChildUserName, username);
			initialValues.put(colChildPassword, password);
			initialValues.put(colChildFirstName, firstName);
			initialValues.put(colChildLastName, lastName);
			initialValues.put(colChildAge, age);
			initialValues.put(colRewardPoint, rewardPoint);
			initialValues.put(colIDParent, parentID);
			initialValues.put(colCNewUser, true); 
			return db.insert(childTable, null, initialValues); 
		}
	}
	
	/**
	 * 
	 * @param medName
	 * @param medFrequency
	 * @param medDosage
	 * @param medForm
	 * @return
	 */
	public long insertPrescription(String medName, Integer medFrequency, Integer medDosage, Integer duration, String description, Integer IDChild)
	{
		ContentValues initialValues = new ContentValues(); 
		initialValues.put(colMedName, medName);
//initialValues.put(colMedAmount, medAmount);
		initialValues.put(colMedFrequency, medFrequency);
		initialValues.put(colMedDosage, medDosage);
		initialValues.put(colDuration, duration);
		initialValues.put(colMedDescription, description);
		initialValues.put(colIDChildPrescription, IDChild);
		return db.insert(prescriptionTable, null, initialValues); 
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
        return db.query(childTable, new String[] {colChildID, colChildFirstName, colChildLastName, colChildAge,
        		colChildPassword, colRewardPoint}, null, null, null, null, null);
		//return null;
    }

	public Cursor fetchAllMeds() {
		Cursor cur = db.rawQuery("SELECT "+ colPrescriptionID + " as _id, " + colMedName + " from "+prescriptionTable, new String[]{});
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

