package com.example.ikhsanlaisa.insylapps.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;

import com.example.ikhsanlaisa.insylapps.R;

import java.util.ArrayList;

public class ScoreActivity extends BaseActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Score;
    private ArrayList<String> Img1;
    private ArrayList<String> Img2;
    private ArrayList<String> A;
    private ArrayList<String> B;

    String[] score = {"2-1", "2-3", "4-5"};

    String[] img1 = { "https://usatftw.files.wordpress.com/2016/05/logo-golden-state-warriors1.png?w=516&h=504", "https://usatftw.files.wordpress.com/2016/05/logo-golden-state-warriors1.png?w=516&h=504", "https://usatftw.files.wordpress.com/2016/05/logo-golden-state-warriors1.png?w=516&h=504"};
    String[] img2 = { "https://mk0slamonlinensgt39k.kinstacdn.com/wp-content/uploads/2010/09/cavs-new-logo1.jpg", "https://mk0slamonlinensgt39k.kinstacdn.com/wp-content/uploads/2010/09/cavs-new-logo1.jpg", "https://mk0slamonlinensgt39k.kinstacdn.com/wp-content/uploads/2010/09/cavs-new-logo1.jpg"};

    String[] a = {"Insyl BasketBall", "Insyl BasketBall", "Insyl BasketBall"};
    String[] b = {"SC Senin, 28 Maret 2018", "SC Senin, 28 Maret 2018", "SC Senin, 28 Maret 2018"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView rv = findViewById(R.id.recycler);
        Score = new ArrayList<>();
        Img1 = new ArrayList<>();
        Img2 = new ArrayList<>();
        A = new ArrayList<>();
        B = new ArrayList<>();

        DaftarItem();
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        adapter = new CustomAdapter(Score, A, B, Img1, Img2);
        rv.setAdapter(adapter);
    }

    private void DaftarItem() {
        for (int i = 0; i<score.length; i++){
            Score.add(score[i]);
            A.add(a[i]);
            B.add(b[i]);
            Img1.add(img1[i]);
            Img2.add(img2[i]);
        }
    }

    @Override
    public int getContent() {
        return R.layout.activity_score;
    }
}
