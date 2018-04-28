package com.example.ikhsanlaisa.insylapps.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ikhsanlaisa.insylapps.Adapter.ScoreAdapter;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.ScoreResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreActivity extends BaseActivity {
    @BindView(R.id.recycler)
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
        Call<List<ScoreResponse>> getResponsecall = Api.getService().score();
        getResponsecall.enqueue(new Callback<List<ScoreResponse>>() {
            @Override
            public void onResponse(Call<List<ScoreResponse>> call, Response<List<ScoreResponse>> response) {
                if (response.isSuccessful()) {
                    List<ScoreResponse> scoreResponses = response.body();
                    Log.d("LOGGING_SCORE", "Jumlah data Kontak: " +
                            String.valueOf(scoreResponses.size()));
                    adapter = new ScoreAdapter(scoreResponses);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ScoreResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_score;
    }
}
