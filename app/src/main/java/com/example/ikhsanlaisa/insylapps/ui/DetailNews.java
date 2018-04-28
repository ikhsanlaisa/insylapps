package com.example.ikhsanlaisa.insylapps.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.NewsResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.thefinestartist.Base.getContext;

public class DetailNews extends BaseActivity {
    TextView title, isi;
    ImageView imgnews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = findViewById(R.id.title);
        isi = findViewById(R.id.isi);
        imgnews = findViewById(R.id.imgnewss);
        String judul = getIntent().getStringExtra("judul");
        String description = getIntent().getStringExtra("description");
        String foto = getIntent().getStringExtra("foto");

        title.setText(judul);
        isi.setText(description);
        Glide.with(DetailNews.this).load(Constant.BASE_URL_PHOTO + "news/" + foto).into(imgnews);

    }

    @Override
    public int getContent() {
        return R.layout.activity_detail_news;
    }
}
