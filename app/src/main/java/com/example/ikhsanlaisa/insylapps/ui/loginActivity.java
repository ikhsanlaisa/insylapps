package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.Response.LoginResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;
import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class loginActivity extends BaseActivity {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;

    @OnClick(R.id.sign_up)
    void signUp() {
        startActivity(new Intent(loginActivity.this, registerActivity.class));
    }

    @OnClick(R.id.login_button)
    public void login() {
        if (email.getText().toString().isEmpty())
            email.setError("Harus diisi ");
        else if (password.getText().toString().isEmpty())
            password.setError("Harus diisi ");
        else
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
                        Intent intent = new Intent(loginActivity.this, MenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(intent);
//            startActivity(new Intent(loginActivity.this, HomeFragment.class));
                    }else{
                        Intent intent = new Intent(loginActivity.this, loginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
//            startActivity(new Intent(loginActivity.this, loginActivity.class));
                        startActivity(intent);
                    }
//                    startActivity(new Intent(loginActivity.this, HomeFragment.class));
                } else {
                    Toast.makeText(loginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(loginActivity.this, response.body().error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse<Data>> call, Throwable t) {

            }

        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_login;

    }


}
