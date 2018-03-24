package com.example.ikhsanlaisa.insylapps.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ikhsanlaisa on 22/03/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<String> arrayListScore;
    private ArrayList<String> arrayListCabor;
    private ArrayList<String> arrayListPlace;
    private ArrayList<String> arrayListImg1;
    private ArrayList<String> arrayListImg2;
    private Context context;

    CustomAdapter(ArrayList<String> arrayListScore, ArrayList<String> arrayListCabor, ArrayList<String> arrayListPlace,
                  ArrayList<String> arrayListImg1, ArrayList<String> arrayListImg2){
        this.arrayListScore = arrayListScore;
        this.arrayListCabor = arrayListCabor;
        this.arrayListPlace = arrayListPlace;
        this.arrayListImg1 = arrayListImg1;
        this.arrayListImg2 = arrayListImg2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView score, cabor, place;
        private ImageView img1, img2;
        private LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);

            score = itemView.findViewById(R.id.scores);
            cabor = itemView.findViewById(R.id.cabors);
            place = itemView.findViewById(R.id.tempat);
            img1 = itemView.findViewById(R.id.team1);
            img2 = itemView.findViewById(R.id.team2);
        }
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_score, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        final String sc = arrayListScore.get(position);
        final String cb = arrayListCabor.get(position);
        final String pl = arrayListPlace.get(position);
        final String im1 = arrayListImg1.get(position);
        final String im2 = arrayListImg2.get(position);

        holder.score.setText(sc);
        holder.cabor.setText(cb);
        holder.place.setText(pl);
        Picasso.with(context).load(im1).resize(60, 60).into(holder.img1);
        Picasso.with(context).load(im2).resize(60, 60).into(holder.img2);

    }

    @Override
    public int getItemCount() {
        return arrayListCabor.size();
    }
}
