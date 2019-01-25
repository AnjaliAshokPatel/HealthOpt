package com.vacreall.healthopt;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FetchRecordsActivity extends AppCompatActivity {

    private ImageView back_img;
    private Button search_diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_records);

        initUI();
    }

    private void initUI() {
        back_img = (ImageView)findViewById(R.id.back);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FetchRecordsActivity.this,MainActivity.class));
            }
        });

        /*search_diseases = (Button)findViewById(R.id.searchDiseases);
        search_diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FetchRecordsActivity.this,DiseasesFragment.class));
            }
        });*/
    }

    /*FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fm.beginTransaction();*/

}
