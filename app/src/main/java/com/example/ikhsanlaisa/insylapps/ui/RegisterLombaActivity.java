package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.CaborResponse;
import com.example.ikhsanlaisa.insylapps.Response.RegisLombaResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterLombaActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    EditText uname, email;
    Spinner spcabor;
    Button regis;
    List<CaborResponse> caborResponses;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            spcabor = findViewById(R.id.spcabor);
            uname = findViewById(R.id.uname);
            email = findViewById(R.id.email);
            regis = findViewById(R.id.regis);

            regis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Api.getService().regis(id).enqueue(new Callback<RegisLombaResponse>() {
                        @Override
                        public void onResponse(Call<RegisLombaResponse> call, Response<RegisLombaResponse> response) {
                            if (response.isSuccessful()){
                                uname.setText(null);
                                email.setText(null);
                                Toast.makeText(RegisterLombaActivity.this,"berhasil", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisLombaResponse> call, Throwable t) {

                        }
                    });
                }
            });
        inispinnercabor();
    }

    private void inispinnercabor() {
        Api.getService().cabor().enqueue(new Callback<List<CaborResponse>>() {
            @Override
            public void onResponse(Call<List<CaborResponse>> call, Response<List<CaborResponse>> response) {
                if (response.isSuccessful()) {
                    caborResponses = response.body();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < caborResponses.size(); i++) {
                        listSpinner.add(caborResponses.get(i).getCabor());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterLombaActivity.this,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spcabor.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CaborResponse>> call, Throwable t) {

            }
        });

        spcabor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RegisterLombaActivity.this.id = caborResponses.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_register_lomba;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedName = parent.getItemAtPosition(position).toString();
        id = caborResponses.get(position).getId();
        Toast.makeText(RegisterLombaActivity.this, "Kamu memilih kelas " + selectedName, Toast.LENGTH_SHORT).show();

    }
}
