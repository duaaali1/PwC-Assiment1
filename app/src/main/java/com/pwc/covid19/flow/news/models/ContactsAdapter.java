package com.pwc.covid19.flow.news.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pwc.covid19.R;

import java.util.ArrayList;


class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<NewsItemUiModel> newsItemUiModels;

    // RecyclerView recyclerView;
    public NewsAdapter() {
        this.newsItemUiModels = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewsItemUiModel myListData = newsItemUiModels.get(position);
        holder.tvTitle.setText(myListData.getTitle());
        holder.tvDesc.setText(myListData.getDesc());
        holder.tvDate.setText(myListData.getDate());

        if (myListData.getImageUrl() != null)
            Glide.with(holder.imageView.getContext())
                    .load(myListData.getImageUrl())
                    .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return newsItemUiModels.size();
    }

    public void setItems(ArrayList<NewsItemUiModel> mapNewsItems) {
        this.newsItemUiModels= mapNewsItems;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvTitle, tvDesc, tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_icon);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvDesc = itemView.findViewById(R.id.tv_dec);
            this.tvDate = itemView.findViewById(R.id.date);
        }
    }
}