package com.vacreall.healthopt;

import java.util.Calendar;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SearchDisease extends Activity implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener {

    private ListView mListView;
    private SearchView searchView;
    private CustomersDbAdapter mDbHelper;

    private TextView diseaseText;
    private TextView symtomsText;
    private TextView categoryText;
    private TextView descriptionText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_disease);

        searchView = (SearchView) findViewById(R.id.search);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        mListView = (ListView) findViewById(R.id.list);
        //inspectionDate = (TextView) findViewById(R.id.inspectionDate);
        //displayDate();

        mDbHelper = new CustomersDbAdapter(this);
        mDbHelper.open();

        //Clean all Customers
        mDbHelper.deleteAllCustomers();
        //Add some Customer data as a sample
        mDbHelper.createCustomer("Disease: AHINI FLU", "Cooled", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "High Fever", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Cough", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Joint Pain", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Lack of Appetite", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Lethargy", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Muscle Pains", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Soar Throat", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");
        mDbHelper.createCustomer("Disease: AHINI FLU", "Vomiting", "Category: Infectious", "Description: Similar to seasonal flue, such as sudden fever (usually above 38C)");

        mDbHelper.createCustomer("Disease: Anemia", "Chest Pain", "Category: Hematologic", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Anemia", "Weakness", "Category: Hematologic", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Anemia", "Fast Breathing", "Category: Hematologic", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Anemia", "Difficulty Breathing", "Category: Hematologic", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Anemia", "Fatigue", "Category: Hematologic", "Description: Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Anemia", "Dizziness", "Category: Hematologic", "Description: The main symptoms of anemia is having low red blood cell count.");

        mDbHelper.createCustomer("Disease: Appendicitis", "Abdominal cramps", "Category: Gastroinal", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Appendicitis", "Abdominal pain", "Category: Gastroinal", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Appendicitis", "Fever", "Category: Gastroinal", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Appendicitis", "Lack of appetite", "Category: Gastroinal", "Description: The main symptoms of anemia is having low red blood cell count.");
        mDbHelper.createCustomer("Disease: Appendicitis", "Vomit", "Category: Gastroinal", "Description: The main symptoms of anemia is having low red blood cell count.");


        mDbHelper.createCustomer("Disease: Asthama", "Accelerated pulse", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Cough", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Difficulty breathing", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Fast breathing", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Soar throat", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Throat inch", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");
        mDbHelper.createCustomer("Disease: Asthama", "Wheezing", "Respiratory", "Description: Chronic disease charaterized by episodes of airflow obstruction");


        mDbHelper.createCustomer("Disease: Cold", "Cough", "Infectious", "Description: Runny nose, nasal congestion and sneezing");
        mDbHelper.createCustomer("Disease: Cold", "Headache", "Infectious", "Description: Runny nose, nasal congestion and sneezing");
        mDbHelper.createCustomer("Disease: Cold", "Sneezing", "Infectious", "Description: Runny nose, nasal congestion and sneezing");
        mDbHelper.createCustomer("Disease: Cold", "Fever", "Infectious", "Description: Runny nose, nasal congestion and sneezing");


        mDbHelper.createCustomer("Disease: Constipation", "Vomit", "Gastroinal", "Description: Person has three bowel movements or less in a week");
        mDbHelper.createCustomer("Disease: Constipation", "Abdominal pain", "Gastroinal", "Description: Person has three bowel movements or less in a week");
        mDbHelper.createCustomer("Disease: Constipation", "Sickness", "Gastroinal", "Description: Person has three bowel movements or less in a week");
        mDbHelper.createCustomer("Disease: Constipation", "Small feces", "Gastroinal", "Description: Person has three bowel movements or less in a week");


        mDbHelper.createCustomer("Dehydration", "Headache", "Others", "Condition that can occur when the loss of body fluids, especially water");
        mDbHelper.createCustomer("Dehydration", "Thirst", "Others", "Condition that can occur when the loss of body fluids, especially water");
        mDbHelper.createCustomer("Dehydration", "Fatigue", "Others", "Condition that can occur when the loss of body fluids, especially water");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDbHelper  != null) {
            mDbHelper.close();
        }
    }

    public boolean onQueryTextChange(String newText) {
        showResults(newText + "*");
        return false;
    }

    public boolean onQueryTextSubmit(String query) {
        showResults(query + "*");
        return false;
    }

    public boolean onClose() {
        showResults("");
        return false;
    }

    private void showResults(String query) {

        Cursor cursor = mDbHelper.searchCustomer((query != null ? query.toString() : "@@@@"));

        if (cursor == null) {
            //
        } else {
            // Specify the columns we want to display in the result
            String[] from = new String[] {
                    CustomersDbAdapter.KEY_DISEASE,
                    CustomersDbAdapter.KEY_SYMTOMS,
                    CustomersDbAdapter.KEY_CATEGORY,
                    CustomersDbAdapter.KEY_DESCRIPTION
            };

            // Specify the Corresponding layout elements where we want the columns to go
            int[] to = new int[] {R.id.disease,
                    R.id.symtoms,
                    R.id.category,
                    R.id.description};

            // Create a simple cursor adapter for the definitions and apply them to the ListView
            SimpleCursorAdapter customers = new SimpleCursorAdapter(this,R.layout.customerresult, cursor, from, to);
            mListView.setAdapter(customers);

            // Define the on-click listener for the list items
            mListView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Get the cursor, positioned to the corresponding row in the result set
                    Cursor cursor = (Cursor) mListView.getItemAtPosition(position);

                    // Get the state's capital from this row in the database.
                    String disease = cursor.getString(cursor.getColumnIndexOrThrow("disease"));
                    String symtoms = cursor.getString(cursor.getColumnIndexOrThrow("symtoms"));
                    String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
                    String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

                    //Check if the Layout already exists
                    LinearLayout customerLayout = (LinearLayout)findViewById(R.id.customerLayout);
                    if(customerLayout == null){
                        //Inflate the Customer Information View
                        LinearLayout leftLayout = (LinearLayout)findViewById(R.id.rightLayout);
                        View customerInfo = getLayoutInflater().inflate(R.layout.customerinfo, leftLayout, false);
                        leftLayout.addView(customerInfo);
                    }

                    //Get References to the TextViews
                    diseaseText = (TextView) findViewById(R.id.disease);
                    symtomsText = (TextView) findViewById(R.id.symtoms);
                    categoryText = (TextView) findViewById(R.id.category);
                    descriptionText = (TextView) findViewById(R.id.description);

                    // Update the parent class's TextView
                    diseaseText.setText(disease);
                    symtomsText.setText(symtoms);
                    categoryText.setText(category);
                    descriptionText.setText(description);

                    searchView.setQuery("",true);
                }
            });
        }
    }


}

