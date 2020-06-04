package com.example.mvptest.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mvptest.data.models.AccountRegisterCrudentials;
import com.example.mvptest.data.models.UserCrudentials;

public class DataBaseHelper extends SQLiteOpenHelper {
    private String LOG = "DataBaseHelper.class";
    private String USER_TABLE = "Users";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    // this ia called the firs time a a db is accessed there should be code in here to eate a new database.
    @Override
    public void onCreate(SQLiteDatabase db) { /* create the user table */
        String CreateTableQueries = "CREATE TABLE Users (fullname varchar(40), username varchar(15), password varchar(15));";
        db.execSQL(CreateTableQueries);
    }

    //this is called if the db version number changes. It prevents previous users apps from breaking when you change the dataabse design
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean createUserAccount(AccountRegisterCrudentials user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("fullname", user.getName());
        content.put("username", user.getUsername());
        content.put("password", user.getPassword());
        long success = db.insert("Users", null, content);
        if (success == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }

    /* function to see if user exists! */
    public boolean checkIfUserExists(UserCrudentials crudentials) {
        String query = "SELECT * from Users where username = '" + crudentials.getUsername() + "';"; //query for the user from the database
        SQLiteDatabase db = this.getReadableDatabase(); //only readable, not update or delete operations can be conducted
        Cursor cur = db.rawQuery(query, null); //cursor is a result set
        if (cur.moveToFirst()) { //check if there is a result for the user, if not then return null
            //check if password matches
            if (cur.getString(2).equals(crudentials.getPassword())) {
                db.close();
                return true;
            } else { //if doesnt match, set user object to be a NULL value
                Log.d(LOG, "But password does not match!");
                db.close();
                return false;
            }
        }
        db.close();
        return false;
    }
}
