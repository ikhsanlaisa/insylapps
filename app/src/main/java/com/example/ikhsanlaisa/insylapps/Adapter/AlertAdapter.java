package com.example.ikhsanlaisa.insylapps.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.MatchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    List<MatchResponse> matchResponses;

    public AlertAdapter(List<MatchResponse> matchResponses) {
        this.matchResponses = matchResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.teams1)
        TextView team_1;
        @BindView(R.id.teams2)
        TextView team_2;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.cabor)
        TextView cabor;
        @BindView(R.id.loc)
        TextView place;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlertAdapter.ViewHolder holder, int position) {
        holder.team_1.setText(String.valueOf(matchResponses.get(position).getTim1()));
//        holder.team_1.setText(matchResponses.get(position).);
        holder.team_2.setText(String.valueOf(matchResponses.get(position).getTim2()));
        holder.date.setText(matchResponses.get(position).getDate());
        holder.cabor.setText(String.valueOf(matchResponses.get(position).getCabor()));
        holder.place.setText(matchResponses.get(position).getTempat());
    }

    @Override
    public int getItemCount() {
        return matchResponses.size();
    }
}
