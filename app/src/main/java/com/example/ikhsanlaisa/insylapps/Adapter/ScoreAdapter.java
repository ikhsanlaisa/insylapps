package com.example.ikhsanlaisa.insylapps.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.ScoreResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ikhsanlaisa on 26/03/18.
 */

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {
    List<ScoreResponse> scoreList;

    public ScoreAdapter(List<ScoreResponse> scoreResponses) {
        this.scoreList = scoreResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.team1)
        TextView team_1;
        @BindView(R.id.team2)
        TextView team_2;
        @BindView(R.id.scores)
        TextView score;
        @BindView(R.id.cabors)
        TextView cabor;
        @BindView(R.id.tempat)
        TextView place;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ScoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_score, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScoreAdapter.ViewHolder holder, int position) {
        for (ScoreResponse score : scoreList) {
            holder.team_1.setText(score.tim1.getNama());
            holder.team_2.setText(score.tim2.getNama());
            holder.score.setText(scoreList.get(position).getScore());
            holder.cabor.setText(score.cabor.getCabor());
            holder.place.setText(scoreList.get(position).getTempat());
        }
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }
}
