package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.auth0.android.jwt.JWT;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.LoginResponse;
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.service.Api;
import com.orhanobut.hawk.Hawk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends BaseActivity {
    JWT jwt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//        boolean isExpired = jwt.isExpired(10);

        ImageView lSplah = findViewById(R.id.logo_insyl);

//        if (!Hawk.get(Constant.TOKEN, "ERROR").equals("ERROR") == jwt.isExpired(10)){
//            Api.getService().refresh().enqueue(new Callback<LoginResponse<Data>>() {
//                @Override
//                public void onResponse(Call<LoginResponse<Data>> call, Response<LoginResponse<Data>> response) {
//                    if (response.isSuccessful()){
//                        Toast.makeText(SplashScreen.this, "berhasil", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginResponse<Data>> call, Throwable t) {
//                        Toast.makeText(SplashScreen.this, "gagal", Toast.LENGTH_LONG).show();
//                }
//            });
//        }else
            if (!Hawk.get(Constant.TOKEN,"ERROR").equals("ERROR")){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }
            }, 3000L);
        }else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, loginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
//            startActivity(new Intent(loginActivity.this, loginActivity.class));
                    startActivity(intent);
                }
            }, 3000L);
        }
    }

    @Override
    public int getContent() {
        return R.layout.activity_splash_screen;
    }
}
