package com.example.ikhsanlaisa.insylapps.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;

import butterknife.OnClick;


public class registerActivity extends AppCompatActivity{

    ProgressDialog dialog;
    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        nama = findViewById(R.id.uname);
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);
//        Register = findViewById(R.id.register);
//        pd = new ProgressDialog(this);
        signin = findViewById(R.id.sign_up);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registerActivity.this, loginActivity.class));
            }
        });



    }



}
