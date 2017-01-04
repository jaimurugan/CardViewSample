package com.mallow.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Company: Mallow Technology
 * Created by bhagya on 03/01/17.
 */
public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder> {

    private List<News> newses;
    private Context context;

    public RecyclerViewAdapter(List<News> newses, Context context) {
        super();
        this.newses = newses;
        this.context = context;
    }

    // 自定义ViewHolder类
    static class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView news_photo;
        TextView news_title;
        TextView news_desc;
        Button share;
        Button readMore;

        public NewsViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            news_photo = (ImageView) itemView.findViewById(R.id.news_photo);
            news_title = (TextView) itemView.findViewById(R.id.news_title);
            news_desc = (TextView) itemView.findViewById(R.id.news_desc);
            share = (Button) itemView.findViewById(R.id.btn_share);
            readMore = (Button) itemView.findViewById(R.id.btn_more);

            // 设置TextView背景为半透明
            news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));
        }
    }

    @Override
    public int getItemCount() {

        return newses == null ? 0 : newses.size();
    }

    @Override
    public void onBindViewHolder(
            RecyclerViewAdapter.NewsViewHolder personViewHolder, int position) {

        final int j = position;

        personViewHolder.news_photo.setImageResource(newses.get(position)
                .getPhotoId());
        personViewHolder.news_title.setText(newses.get(position).getTitle());
        personViewHolder.news_desc.setText(newses.get(position).getDesc());

        // 为btn_share btn_readMore cardView设置点击事件
        // 为btn_share btn_readMore cardView设置点击事件
        personViewHolder.cardView
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, NewsActivity.class);
                        intent.putExtra("News", newses.get(j));
                        context.startActivity(intent);
                    }
                });

        personViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, newses.get(j).getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, newses
                        .get(j).getTitle()));
            }
        });

        personViewHolder.readMore
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, NewsActivity.class);
                        intent.putExtra("News", newses.get(j));
                        context.startActivity(intent);
                    }
                });
    }

    @Override
    public RecyclerViewAdapter.NewsViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int arg1) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_item,
                null);
        NewsViewHolder nvh = new NewsViewHolder(view);

        return nvh;
    }
}
