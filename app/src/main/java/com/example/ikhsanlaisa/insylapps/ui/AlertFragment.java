package com.example.ikhsanlaisa.insylapps.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ikhsanlaisa.insylapps.Adapter.AlertAdapter;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.MatchResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragment extends Fragment {
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_alert, container, false);
        DaftarItem();
        rv = view.findViewById(R.id.recyclermatch);
        layoutManager = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        return view;
    }

    private void DaftarItem() {
        Api.getService().match().enqueue(new Callback<List<MatchResponse>>() {
            @Override
            public void onResponse(Call<List<MatchResponse>> call, Response<List<MatchResponse>> response) {
                if (response.isSuccessful()) {
                    List<MatchResponse> matchResponses = response.body();
                    Log.d("LOGGING_SCORE", "Jumlah data news: " +
                            String.valueOf(matchResponses.size()));
                    adapter = new AlertAdapter(matchResponses);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MatchResponse>> call, Throwable t) {

            }
        });
    }

}
