package com.example.ikhsanlaisa.insylapps.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KontakResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ikhsanlaisa on 27/03/18.
 */

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewHolder> {
    List<KontakResponse> kontakResponses;

    public KontakAdapter(List<KontakResponse> kontakResponses) {
        this.kontakResponses = kontakResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgkon)
        ImageView imgkon;
        @BindView(R.id.namekon)
        TextView namekon;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.hp)
        TextView hp;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public KontakAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kontak, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KontakAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(Constant.BASE_URL_PHOTO + "kontak/" + kontakResponses.get(position).getFoto()).into(holder.imgkon);
        holder.namekon.setText(kontakResponses.get(position).getNama());
        holder.email.setText(kontakResponses.get(position).getEmail());
        holder.hp.setText(kontakResponses.get(position).getNo_telp());
    }

    @Override
    public int getItemCount() {
        return kontakResponses.size();
    }
}

