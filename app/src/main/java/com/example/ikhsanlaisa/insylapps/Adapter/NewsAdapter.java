package com.example.ikhsanlaisa.insylapps.Adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.NewsResponse;
import com.example.ikhsanlaisa.insylapps.ui.DetailNews;
import com.example.ikhsanlaisa.insylapps.ui.NewsFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsResponse> newsResponses;

    public NewsAdapter(List<NewsResponse> newsResponses){
        this.newsResponses = newsResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cardnews)
        CardView cardView;
        @BindView(R.id.imgnews)
        ImageView imgnews;
        @BindView(R.id.newstitle)
        TextView newstitle;
        @BindView(R.id.listnews)
        LinearLayout itemnews;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.ViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext()).load(Constant.BASE_URL_PHOTO + "news/" + newsResponses.get(position).getFoto()).into(holder.imgnews);
        holder.newstitle.setText(newsResponses.get(position).getJudul());
        holder.itemnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailNews.class);
                intent.putExtra("judul", newsResponses.get(position).getJudul());
                intent.putExtra("description", newsResponses.get(position).getDescription());
                intent.putExtra("foto", newsResponses.get(position).getFoto());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return newsResponses.size();
    }
}
