package com.vacreall.healthopt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    private TextView signUpText;
    private Button btnsignIn;
    private EditText email,pass;
    public static final String PREFERENCE= "preference";

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email =(EditText)findViewById(R.id.edit_email);
        pass = (EditText)findViewById(R.id.edit_password);
        initUI();
    }

    private void initUI() {
        signUpText = (TextView)findViewById(R.id.signUpTextView);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this,SignUpActivity.class));
            }
        });

        btnsignIn = (Button)findViewById(R.id.btnSignIn);
        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db=new DatabaseHandler(SigninActivity.this, null, null, 2);
                String username=email.getText().toString();
                String password= pass.getText().toString();

                String StoredPassword =db.getregister(username);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(), StoredPassword+" Login Successfully", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = getSharedPreferences(PREFERENCE, MODE_PRIVATE).edit();
                    editor.putString("name",username);
                    editor.apply();


                    startActivity(new Intent(SigninActivity.this,FetchActivity.class));

                }
                else{
                    Toast.makeText(getApplicationContext(), "EmailId/Password incorrect", Toast.LENGTH_LONG).show();
                    email.setText("");
                    pass.setText("");
                }
            }
        });
    }
}
