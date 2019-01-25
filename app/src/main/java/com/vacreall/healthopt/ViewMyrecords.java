package com.vacreall.healthopt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewMyrecords extends AppCompatActivity {

    public static final String PREFERENCE= "preference";

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_myrecords);

        mSharedPreferences = getSharedPreferences(PREFERENCE, SigninActivity.MODE_PRIVATE);
        String restoredText = mSharedPreferences.getString("name", null);
    }

}**/
public class ViewMyrecords extends AppCompatActivity implements View.OnClickListener {
    Controllerdb db =new Controllerdb(this);
    SQLiteDatabase database;
    EditText Disease,Symtoms,Description;
    Button Submitdatabtn,Showdatabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_myrecords);
        Disease= (EditText) findViewById(R.id.etDisease);
        Symtoms= (EditText) findViewById(R.id.etSymtoms);
        Description= (EditText) findViewById(R.id.etDescription);
        Submitdatabtn= (Button) findViewById(R.id.btnSave);
        Showdatabtn=(Button) findViewById(R.id.btnShow);
        Submitdatabtn.setOnClickListener(this);
        Showdatabtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btnSave)
        {
            database=db.getWritableDatabase();
            database.execSQL("INSERT INTO UserDetails(Disease,Symtom,Description)VALUES('"+Disease.getText()+"','"+Symtoms.getText()+"','"+Description.getText()+"')" );
            Toast.makeText(this,"Data Inserted To Sqlite Database",Toast.LENGTH_LONG).show();
        }
        else  if(v.getId()==R.id.btnShow)
        {
            Intent intent=new Intent(this,ShowdataListview.class);
            startActivity(intent);

        }
    }
}
