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
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.model.RegisterResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class registerActivity extends BaseActivity{
    @BindView(R.id.uname)
    EditText uname;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;

    @OnClick(R.id.sign_up)
    void SignIn(){
        startActivity(new Intent(registerActivity.this, loginActivity.class));
    }

    @OnClick(R.id.register)
    public void register(){
        if (uname.getText().toString().isEmpty())
            uname.setError("Harus diisi ");
        else if (email.getText().toString().isEmpty())
            email.setError("Harus diisi ");
        else if (password.getText().toString().isEmpty())
            password.setError("Harus diisi ");
        else
            Api.getService().register(uname.getText().toString(), email.getText().toString(), password.getText().toString()).enqueue(new Callback<RegisterResponse<Data>>() {
                @Override
                public void onResponse(Call<RegisterResponse<Data>> call, Response<RegisterResponse<Data>> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(registerActivity.this, "Data anda berhasil disimpan", Toast.LENGTH_LONG).show();
                    }else
                        Toast.makeText(registerActivity.this, "Data gagal disimpan", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<RegisterResponse<Data>> call, Throwable t) {

                }
            });

    }
    @Override
    public int getContent() {
        return R.layout.activity_register;
    }


}
