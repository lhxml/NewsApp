package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.News;
import com.example.common.base.BaseApplication;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {

    private Context mContext;
    private List<News> newsList;
    public NewsListAdapter(Context mContext){
        this.mContext = mContext;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.item_newslist, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = newsList.get(position);
        Glide.with(mContext).load(news.getTop_image()).into(holder.image_news);
        holder.txt_title.setText(""+news.getTitle());
        holder.txt_desc.setText(""+news.getContent());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image_news;
        TextView txt_title;
        TextView txt_desc;
        public MyViewHolder(View itemView) {
            super(itemView);
            image_news = (ImageView) itemView.findViewById(R.id.image_news);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_desc = (TextView) itemView.findViewById(R.id.txt_desc);
        }
    }
}
