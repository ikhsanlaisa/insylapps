package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.example.ikhsanlaisa.insylapps.model.Data;
import com.example.ikhsanlaisa.insylapps.Response.RegisterResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class registerActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    @BindView(R.id.uname)
    EditText uname;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.kelass)
    Spinner spregis;

    int id;
    List<KelasResponse> kelasResponses;

    @OnClick(R.id.sign_up)
    void SignIn(){
        startActivity(new Intent(registerActivity.this, loginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inispinnerregis();
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
            Api.getService().register(uname.getText().toString(), email.getText().toString(), password.getText().toString(), registerActivity.this.id).enqueue(new Callback<RegisterResponse<Data>>() {
                @Override
                public void onResponse(Call<RegisterResponse<Data>> call, Response<RegisterResponse<Data>> response) {
                    if (response.isSuccessful()){
                        uname.setText(null);
                        email.setText(null);
                        password.setText(null);
                        Toast.makeText(registerActivity.this, "Data anda berhasil disimpan", Toast.LENGTH_LONG).show();
                    }else
                        Toast.makeText(registerActivity.this, "Data gagal disimpan", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<RegisterResponse<Data>> call, Throwable t) {

                }
            });
    }

    private void inispinnerregis(){
        Api.getService().kelas().enqueue(new Callback<List<KelasResponse>>() {
            @Override
            public void onResponse(Call<List<KelasResponse>> call, Response<List<KelasResponse>> response) {
                if (response.isSuccessful()){
                    kelasResponses = response.body();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < kelasResponses.size(); i++){
                        listSpinner.add(kelasResponses.get(i).getNama());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(registerActivity.this,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spregis.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<KelasResponse>> call, Throwable t) {

            }
        });
        spregis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
                registerActivity.this.id = kelasResponses.get(position).getId();
                Toast.makeText(registerActivity.this, "Data anda berhasil disimpan" + id, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_register;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedName = parent.getItemAtPosition(position).toString();
        id = kelasResponses.get(position).getId();
        Toast.makeText(registerActivity.this, "Kamu memilih kelas " + id, Toast.LENGTH_SHORT).show();
    }
}
