package com.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.base.BaseApplication;
import com.example.ui.R;

import butterknife.BindView;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.item_newslist, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
