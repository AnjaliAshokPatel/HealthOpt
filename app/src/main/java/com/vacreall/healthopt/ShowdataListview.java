package com.vacreall.healthopt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class ShowdataListview extends AppCompatActivity {
    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Disease = new ArrayList<String>();
    private ArrayList<String> Symtom = new ArrayList<String>();
    private ArrayList<String> Description = new ArrayList<String>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata_listview);
        lv = (ListView) findViewById(R.id.lstvw);
    }
    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }
    private void displayData() {
        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  UserDetails",null);
        Id.clear();
        Disease.clear();
        Symtom.clear();
        Description.clear();
        if (cursor.moveToFirst()) {
            do {
                Id.add(cursor.getString(cursor.getColumnIndex("Id")));
                Disease.add(cursor.getString(cursor.getColumnIndex("Disease")));
                Symtom.add(cursor.getString(cursor.getColumnIndex("Symtom")));
                Description.add(cursor.getString(cursor.getColumnIndex("Description")));
            } while (cursor.moveToNext());
        }
        CustomAdapter ca = new CustomAdapter(ShowdataListview.this,Id, Disease,Symtom,Description);
        lv.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();
    }
}
