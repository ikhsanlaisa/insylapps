package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.model.LoginResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;
import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class loginActivity extends BaseActivity {
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.password)
    TextView password;

    @OnClick(R.id.sign_up)
    void signUp() {
        startActivity(new Intent(loginActivity.this, registerActivity.class));
    }

    @OnClick(R.id.login_button)
    void login() {
        Api.getService().login(email.getText().toString(), password.getText().toString()).enqueue(new Callback<LoginResponse<Data>>() {

            @Override
            public void onResponse(Call<LoginResponse<Data>> call, Response<LoginResponse<Data>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(loginActivity.this, "Oke", Toast.LENGTH_SHORT).show();
                    Log.d("ini tokennya ", response.body().data.token );
                    Hawk.put(Constant.DATA, response.body().data);
                    Hawk.put(Constant.TOKEN, "Bearer " + response.body().data.token);
                    Hawk.put(Constant.USER, response.body().data.user);
//                    Hawk.put(Constant.ROLE, response.body().data.user.roles);
                    Log.d("Token", Hawk.get(Constant.TOKEN, ""));
                    Log.d("ini tokennya ", response.body().data.token );
                    if (!Hawk.get(Constant.TOKEN,"ERROR").equals("ERROR")){
                        startActivity(new Intent(loginActivity.this, AccountActivity.class));
                    }else{
                        startActivity(new Intent(loginActivity.this, loginActivity.class));
                    }
//                    startActivity(new Intent(loginActivity.this, AccountActivity.class));
                } else {
                    Toast.makeText(loginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(loginActivity.this, response.body().error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse<Data>> call, Throwable t) {

            }

        });
//        Api.getService().login(email.getText().toString(), password.getText().toString()).enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//                Log.d("INITOL", "onResponse");
//                if (response.isSuccessful()) {
//                    Log.d("INITOL", "successfull");
//                    Toast.makeText(loginActivity.this, Constant.TAG_SUCCESS, Toast.LENGTH_LONG).show();
//                    Hawk.put(Constant.DATA, response.body().data);
//                    Hawk.put(Constant.TOKEN, "Bearer " + response.body().data.token);
//                    Hawk.put(Constant.USER, response.body().data.user);
//                    Hawk.put(Constant.ROLE, response.body().data.user.roles);
//                    Log.d("clik", response.body().data.token);
//                    startActivity(new Intent(loginActivity.this, AccountActivity.class));
//                } else if (response.code() == 401) {
//                    Toast.makeText(loginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                Log.e("Failure", t.getMessage());
//                Toast.makeText(loginActivity.this, Constant.TAG_NETWORK, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_login;
    }

}
