package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ikhsanlaisa.insylapps.Constant;
import com.orhanobut.hawk.Hawk;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContent());

        ButterKnife.bind(this);
        Hawk.init(this).build();
    }


    public abstract int getContent();
}
