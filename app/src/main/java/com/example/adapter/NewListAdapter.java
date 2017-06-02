package com.example.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.base.BaseRecyclerViewAdapter;
import com.example.bean.News;

import com.example.common.base.BaseViewHolder;
import com.example.news.presenter.NewsListPresenter;
import com.example.ui.R;

/**
 * Created by lxl on 2017/5/26.
 */

public class NewListAdapter extends BaseRecyclerViewAdapter<News>{
    private Context mContext;

    public NewListAdapter(Context mContext) {
        super(mContext);
        this.mContext = mContext;

    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_newslist;
    }

    @Override
    public void convert(RecyclerView.ViewHolder holder, News news) {

        ((BaseViewHolder)holder).setImageByUrl(R.id.image_news,news.getTop_image());
        ((BaseViewHolder)holder).setText(R.id.txt_title,news.getTitle());
        ((BaseViewHolder)holder).setText(R.id.txt_desc,news.getDigest());
        ((BaseViewHolder)holder).setOnClickListener(R.id.layout_newslist_item,mOnItemClickListener);
    }




}
