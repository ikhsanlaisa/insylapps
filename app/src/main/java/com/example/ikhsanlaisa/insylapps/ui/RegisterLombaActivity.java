package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.CaborResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterLombaActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    Spinner spcabor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            spcabor = findViewById(R.id.spcabor);

        inispinnercabor();
    }

    private void inispinnercabor() {
        Api.getService().cabor().enqueue(new Callback<List<CaborResponse>>() {
            @Override
            public void onResponse(Call<List<CaborResponse>> call, Response<List<CaborResponse>> response) {
                if (response.isSuccessful()) {
                    List<CaborResponse> caborResponses = response.body();
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
    }

    @Override
    public int getContent() {
        return R.layout.activity_register_lomba;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedName = parent.getItemAtPosition(position).toString();

        Toast.makeText(RegisterLombaActivity.this, "Kamu memilih kelas " + selectedName, Toast.LENGTH_SHORT).show();

    }
}
