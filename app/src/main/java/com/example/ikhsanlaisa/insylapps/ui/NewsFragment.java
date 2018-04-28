package com.example.ikhsanlaisa.insylapps.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ikhsanlaisa.insylapps.Adapter.KontakAdapter;
import com.example.ikhsanlaisa.insylapps.Adapter.NewsAdapter;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KontakResponse;
import com.example.ikhsanlaisa.insylapps.Response.NewsResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

                DaftarItem();
                rv = view.findViewById(R.id.recyclernews);
        layoutManager = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        return view;
    }

    private void DaftarItem() {
        Call<List<NewsResponse>> getNewsResponse = Api.getService().news();
        getNewsResponse.enqueue(new Callback<List<NewsResponse>>() {
            @Override
            public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                if (response.isSuccessful()) {
                    List<NewsResponse> newsResponses = response.body();
                    Log.d("LOGGING_SCORE", "Jumlah data news: " +
                            String.valueOf(newsResponses.size()));
                    adapter = new NewsAdapter(newsResponses);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<NewsResponse>> call, Throwable t) {

            }
        });
    }

}
