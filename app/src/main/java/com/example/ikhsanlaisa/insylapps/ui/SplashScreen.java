package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.orhanobut.hawk.Hawk;

public class SplashScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);



        ImageView lSplah = findViewById(R.id.logo_insyl);
        if (!Hawk.get(Constant.TOKEN,"ERROR").equals("ERROR")){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }
            }, 3000L);


//            startActivity(new Intent(loginActivity.this, HomeActivity.class));
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
