package com.example.ikhsanlaisa.insylapps.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.example.ikhsanlaisa.insylapps.Response.ScoreResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ikhsanlaisa on 26/03/18.
 */

public class KlasemenAdapter extends RecyclerView.Adapter<KlasemenAdapter.ViewHolder> {
    List<KelasResponse> classList;

    public KlasemenAdapter(List<KelasResponse> classList) {
        this.classList = classList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.klass)
        TextView klass;
        @BindView(R.id.point)
        TextView point;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public KlasemenAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_klasemen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KlasemenAdapter.ViewHolder holder, int position) {
            holder.klass.setText(classList.get(position).getNama());
            holder.point.setText(String.valueOf(classList.get(position).getPoint()));
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }
}
