package com.vacreall.healthopt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button mSignin;

    private EditText Name,Email,Password,ConfirmPassword,Mobile;
    RadioGroup radioSexGroup;
    RadioButton radioSexButton;
    DatabaseHandler db;
    TextView t_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name= (EditText)findViewById(R.id.edit_name);
        Email =(EditText)findViewById(R.id.edit_emailid);
        Mobile =(EditText)findViewById(R.id.edit_mobile);
        Password=(EditText)findViewById(R.id.edit_password);
        ConfirmPassword =(EditText)findViewById(R.id.edit_confirmpassword);
        radioSexGroup = (RadioGroup) findViewById(R.id.radio_gender);

        initUI();
    }

    private void initUI() {

        t_signIn = (TextView)findViewById(R.id.signIn);
        t_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,SigninActivity.class));
            }
        });
        mSignin = (Button)findViewById(R.id.signUpTextView);
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                String edfirst = Name.getText().toString();
                String edemail = Email.getText().toString();
                String edmobile = Mobile.getText().toString();
                String edpass = Password.getText().toString();
                String edConf = ConfirmPassword.getText().toString();
                String radiogender= radioSexButton.getText().toString();




                if(edConf.equals(edpass) ){


                    db = new DatabaseHandler(SignUpActivity.this, null, null, 2);
                    Registerdata reg = new Registerdata();

                    reg.setName(edfirst);
                    reg.setEmailId(edemail);
                    reg.setMobNo(edmobile);
                    reg.setPassword(edpass);
                    reg.setGenderName(radiogender);
                    db.addregister(reg);

                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else{

                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                    Password.setText("");
                    ConfirmPassword.setText("");
                    startActivity(new Intent(SignUpActivity.this,SignUpActivity.class));
                }
            }
        });
    }


}
