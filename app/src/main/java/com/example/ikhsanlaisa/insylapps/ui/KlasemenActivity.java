package com.example.ikhsanlaisa.insylapps.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.Adapter.KlasemenAdapter;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KlasemenActivity extends BaseActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaftarItem();
        rv = findViewById(R.id.rvklasemen);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
    }

    private void DaftarItem() {
        Api.getService().kelas().enqueue(new Callback<List<KelasResponse>>() {
            @Override
            public void onResponse(Call<List<KelasResponse>> call, Response<List<KelasResponse>> response) {
                if (response.isSuccessful()) {
                    List<KelasResponse> kelas = response.body();
                    Toast.makeText(KlasemenActivity.this, "Berhasil", Toast.LENGTH_LONG).show();
                    adapter = new KlasemenAdapter(kelas);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<KelasResponse>> call, Throwable t) {
                Toast.makeText(KlasemenActivity.this, "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_klasemen;
    }
}
