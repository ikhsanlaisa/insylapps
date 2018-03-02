package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.ikhsanlaisa.insylapps.R;
import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btnlogout)
    public void logout(){
        Hawk.deleteAll();
        startActivity(new Intent(AccountActivity.this, loginActivity.class));
        finish();
    }

    @Override
    public int getContent() {
        return R.layout.activity_account;
    }
}
