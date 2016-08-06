package com.sundayliu.demo.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mUserName;
    EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = (EditText)findViewById(R.id.et_username);
        mPassword = (EditText)findViewById(R.id.et_password);

        Button login = (Button)findViewById(R.id.btn_login);
        login.setOnClickListener(this);
    }

    public boolean isValidInfo(String username, String password){
        return false;
    }

    public void onClick(View v){

        if (v.getId() == R.id.btn_login)
        {
            String username = mUserName.getText() + "";
            String password = mPassword.getText() + "";
            if (isValidInfo(username, password)){
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
            }

        }

    }
}
