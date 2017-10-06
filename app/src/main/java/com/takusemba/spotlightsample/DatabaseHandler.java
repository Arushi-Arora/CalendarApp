package com.takusemba.spotlightsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hp on 7/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "TodosManager";

    // Contacts table name
    private static final String TABLE_TODOS = "todos";

    // Contacts Table Columns names
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DATE = "date";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TODOS + "("
                + KEY_TITLE + " TEXT," + KEY_DESCRIPTION + " TEXT,"
                + KEY_DATE + "TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOS);

        // Create tables again
        onCreate(db);
    }

    public void addTodo(TodoAdd todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, todo.getTitle());
        values.put(KEY_DESCRIPTION, todo.getDescription());
        // Inserting Row
        db.insert(TABLE_TODOS, null, values);
        db.close(); // Closing database connection
    }

    public ArrayList<TodoAdd> getTodos() {
        ArrayList<TodoAdd> contactList = new ArrayList<TodoAdd>();
        // Select All Query
        String selectQuery = "SELECT  title,description FROM " + TABLE_TODOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TodoAdd todoAdd = new TodoAdd();
                todoAdd.setTitle(cursor.getString(0));
                todoAdd.setDescription(cursor.getString(1));
//                todoAdd.setDate(cursor.getString(2));
                // Adding contact to list
                contactList.add(todoAdd);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}
