package com.example.ghkgkf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial view พูกตัวแปล
        initialView();

        //Controller ทำให้วิวสามารคริกได้
        controller();

    }   // Main Method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPasswprd);
        textView = (TextView) findViewById(R.id.textNewRegis);
        button = (Button) findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View v) {

        //For TextView
        if (v == textView) {
            // intent to SignUp
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

        //For button
        if (v == button) {
            // Get Value From EditText
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("") || passwordString.equals("")) {
                //Have Space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Have Space", "Please Fill All Every Blank");

            } else {
                //No Space
                checkUserAnPass();

            }

        }

    }

    private void checkUserAnPass() {
        try {

        } catch (Exception e) {
            Log.d("27AprilV1", "e checkUser ==> " + e.toString());
        }
    }
}   // Main Class นี้คือคาสหลัก นะจ้ะ
