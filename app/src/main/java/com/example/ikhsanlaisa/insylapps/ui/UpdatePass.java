package com.example.ikhsanlaisa.insylapps.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.UserResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePass extends BaseActivity {
    EditText edtpass;
    Button btnpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        edtpass = findViewById(R.id.edtpass);
        btnpass = findViewById(R.id.btnpass);
        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api.getService().updatepassword(edtpass.getText().toString()).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful()){
                            edtpass.setText(null);
                            Toast.makeText(UpdatePass.this,"berhasil", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                });
            }
        });

    }

    @Override
    public int getContent() {
        return R.layout.activity_update_pass;
    }
}
