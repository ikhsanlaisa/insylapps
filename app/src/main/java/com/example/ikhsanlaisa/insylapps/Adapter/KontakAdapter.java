package com.example.ikhsanlaisa.insylapps.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.example.ikhsanlaisa.insylapps.ui.KontakActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thefinestartist.utils.content.ContextUtil.startActivity;

/**
 * Created by ikhsanlaisa on 27/03/18.
 */

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewHolder> {
    List<KontakResponse> kontakResponses;

    public KontakAdapter(List<KontakResponse> kontakResponses) {
        this.kontakResponses = kontakResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.telp)
        ImageView imgtlpn;
        @BindView(R.id.surel)
        ImageView surel;
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
    public void onBindViewHolder(KontakAdapter.ViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext()).load(Constant.BASE_URL_PHOTO + "kontak/" + kontakResponses.get(position).getFoto()).into(holder.imgkon);
        holder.namekon.setText(kontakResponses.get(position).getNama());
        holder.email.setText(kontakResponses.get(position).getEmail());
        holder.hp.setText(kontakResponses.get(position).getNo_telp());
        holder.imgtlpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    String number = kontakResponses.get(position).getNo_telp();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + number));
                    view.getContext().startActivity(intent);
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

            }
        });

        holder.surel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = kontakResponses.get(position).getNo_telp();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:" + number));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kontakResponses.size();
    }
}

