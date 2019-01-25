package com.vacreall.healthopt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CustomersDbAdapter {

    public static final String KEY_ROWID = "rowid";
    public static final String KEY_DISEASE= "disease";
    public static final String KEY_SYMTOMS = "symtoms";
    public static final String KEY_CATEGORY= "category";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_SEARCH = "searchData";

    private static final String TAG = "DiseaseDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "DiseaseData";
    private static final String FTS_VIRTUAL_TABLE = "CustomerInfo";
    private static final int DATABASE_VERSION = 1;

    //Create a FTS3 Virtual Table for fast searches
    private static final String DATABASE_CREATE =
            "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE + " USING fts3(" +
                    KEY_DISEASE + "," +
                    KEY_SYMTOMS + "," +
                    KEY_CATEGORY + "," +
                    KEY_DESCRIPTION + "," +
                    KEY_SEARCH +" )";



    private final SearchDisease mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(SearchDisease context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }
    }

    public CustomersDbAdapter(SearchDisease ctx) {
        this.mCtx = ctx;
    }

    public CustomersDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }


    public long createCustomer(String disease , String symtoms, String category, String description) {

        ContentValues initialValues = new ContentValues();
        String searchValue =   symtoms;
        initialValues.put(KEY_DISEASE, disease);
        initialValues.put(KEY_SYMTOMS, symtoms);
        initialValues.put(KEY_CATEGORY, category);
        initialValues.put(KEY_DESCRIPTION, description);
        initialValues.put(KEY_SEARCH, searchValue);

        return mDb.insert(FTS_VIRTUAL_TABLE, null, initialValues);
    }


    public Cursor searchCustomer(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        String query = "SELECT docid as _id," +
                KEY_DISEASE + "," +
                KEY_SYMTOMS + "," +
                KEY_CATEGORY + "," +
                KEY_DESCRIPTION +
                " from " + FTS_VIRTUAL_TABLE +
                " where " +  KEY_SEARCH + " MATCH '" + inputText + "';";
        Log.w(TAG, query);
        Cursor mCursor = mDb.rawQuery(query,null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }


    public boolean deleteAllCustomers() {

        int doneDelete = 0;
        doneDelete = mDb.delete(FTS_VIRTUAL_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

}
