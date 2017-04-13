package com.example.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.News;
import com.example.common.base.BaseApplication;
import com.example.ui.R;
import com.example.util.ImageLoaderUtils;
import com.example.util.LoadHelper;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM =0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView


    private Context mContext;
    private List<News> newsList;
    public NewsListAdapter(Context mContext){
        this.mContext = mContext;
        newsList = new ArrayList<>();
    }

    public void setNewsList(List<News> newsList){
        Log.i("NewsListAdater==", "setNewsList: "+newsList);
        if(newsList!=null){

            this.newsList = newsList;
        }else{
            this.newsList = new ArrayList<>();
        }
        this.notifyDataSetChanged();
    }
    public void addNewsList(List<News> newsList){
        if(newsList!=null){
            this.newsList.addAll(newsList);
        }else{
            this.newsList = new ArrayList<>();
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position+1==getItemCount()){
            return TYPE_FOOTER;
        }else{
            return TYPE_ITEM;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_ITEM){
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_newslist, parent, false));
            return holder;
        }else{
            LoadHelper loadHelper = LoadHelper.getInstance(mContext);
            View view = loadHelper.getmLoadingFooterView();
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new MyFooterViewHolder(view);

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            News news = newsList.get(position);
            ImageLoaderUtils.display(mContext,((MyViewHolder)holder).image_news,news.getTop_image());
            ((MyViewHolder)holder).txt_title.setText(""+news.getTitle());
            ((MyViewHolder)holder).txt_desc.setText(""+news.getDigest());
        }else if(holder instanceof MyFooterViewHolder){
            LoadHelper.getInstance(mContext).startLoadMore();
        }

    }

    @Override
    public int getItemCount() {
        return newsList.size() == 0 ? 0 : newsList.size()+1;
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

    class MyFooterViewHolder extends RecyclerView.ViewHolder{

        public MyFooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
