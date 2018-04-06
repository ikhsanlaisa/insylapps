package com.example.ikhsanlaisa.insylapps.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ikhsanlaisa.insylapps.Adapter.KontakAdapter;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KontakResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KontakActivity extends BaseActivity {
    @BindView(R.id.konrecycler)
    RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaftarItem();
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
    }

    private void DaftarItem() {
        Call<List<KontakResponse>> getKontakResponse = Api.getService().kontak();
        getKontakResponse.enqueue(new Callback<List<KontakResponse>>() {
            @Override
            public void onResponse(Call<List<KontakResponse>> call, Response<List<KontakResponse>> response) {
                if (response.isSuccessful()) {
                    List<KontakResponse> kontakResponses = response.body();
                    Log.d("LOGGING_SCORE", "Jumlah data Kontak: " +
                            String.valueOf(kontakResponses.size()));
                    adapter = new KontakAdapter(kontakResponses);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<KontakResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_kontak;
    }
}
