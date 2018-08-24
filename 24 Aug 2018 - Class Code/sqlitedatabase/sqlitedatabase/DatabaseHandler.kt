package com.bmpl.sqlitedatabase_nishamohit

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*

//SQLite --> Sqliteopenhelper class --> abstract --> two abstract --> one method used to create table and second method is used to upgrade database
class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME , null, DATABASE_VERSION) {

    // DatabaseHandler(Context context){
        // super(context, DAtabase_name, null, DatabaseVersion)
    // }

    companion object {
        private val DATABASE_NAME = "mydatabase"
        private val TABLE_NAME = "user_details"
        private val DATABASE_VERSION = 1
        private val COLUMN_NAME = "Name"
        private val COLUMN_ID = "ID"
        private val COLUMN_PHN = "PHONE_NO"

                                    // Create table
        private val CREATE_TABLE = "Create table " + TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY_KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHN + " INTEGER )"

        private val DROP_TABLE = "DROP TABLE $TABLE_NAME IF EXISTS"
    }



//    constructor(context: Context){
//        super(context, DATABASE_NAME, null, DATABASE_VERSION)
//    }

    // create your table here
    // crud operation --> insert, query, // method --> query execute -->
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE)    // predefined (String --> convert -->sql query)
    }

    // upgrade your table here
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        sqLiteDatabase.execSQL(DROP_TABLE)
    }

    //CRUD --> Create , Read, Delete, Update
    fun addDetails(details: Details) {
        //insert -->
        val contentValues = ContentValues() //contentvalue  sqlitedatabse database --> insert() --> contentvalues
        val name = details.name
        val phn = details.phn
        val id = details.id

        Log.i("Database Handler", name)

        contentValues.put(COLUMN_ID, id) // key--> Column name and value
        contentValues.put(COLUMN_NAME, name) // NULL
        contentValues.put(COLUMN_PHN, phn)
        //
        // open database for writing data into it -> opening a connection for writing data
        // step-1: connection establish
        val sqLiteDatabase : SQLiteDatabase = this.writableDatabase //

        // step-2: write data
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues)

        // step-3: close the connection
        sqLiteDatabase.close()
    }

    internal fun readData(): List<Details>
    {
        val arrayList = ArrayList<Details>()

        val sqLiteDatabase = this.readableDatabase
        val readQuery = "Select * from $TABLE_NAME"
        // Cursor --> Predefined Interface
        var cursor : Cursor = sqLiteDatabase.rawQuery(readQuery, null) // ContentProvider --> Content Resolver and Content Values and Cursor
    // -1 --> Cursor --> RESULT_SET -->size --> 0  --> Predefiend Interface
        // --> 0 --> -1 cursor-->
        //cursor --> 0
        while (cursor.moveToNext()) {
            val details = Details()
            details.id = cursor.getInt(0) // 1
            details.name = cursor.getString(1) // row ->0  col -> 1
            details.phn = java.lang.Long.parseLong(cursor.getString(2))
            //details.setId(Integer.parseInt(id));
            //details.setName(name);
            arrayList.add(details) //0--> {id:"", name: "", phn:""}
        }
        return arrayList
    }

    internal fun updateData(details: Details) {
        val sqLiteDatabase = this.writableDatabase

        val contentValues = ContentValues()
        //contentValues.put(COLUMN_ID, details.id)    // 1001
        contentValues.put(COLUMN_NAME, details.name) // ram/ mohan
        contentValues.put(COLUMN_PHN, details.phn)  // 9855444554
        // update table_name where                                   //where id == 1001
        sqLiteDatabase.update(TABLE_NAME, contentValues, "id=?",
                arrayOf(details.id.toString()))
        sqLiteDatabase.close()
    }

    fun deleteData(details: Details) {
        val sqLiteDatabase = this.writableDatabase
        sqLiteDatabase.delete(TABLE_NAME, "id=? ", arrayOf(details.id.toString()))
        sqLiteDatabase.close()
    }
}