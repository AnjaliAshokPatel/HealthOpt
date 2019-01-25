package com.vacreall.healthopt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FetchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        
        initUI();
    }

    private void initUI() {
        LinearLayout lnrlayout = (LinearLayout)findViewById(R.id.fetchBtnLinear);
        lnrlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FetchActivity.this,MainActivity.class));
            }
        });


    }
}
