package com.example.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adapter.NewsListAdapter;
import com.example.api.ApiConstants;
import com.example.bean.News;
import com.example.common.base.BaseFragment;
import com.example.common.utils.LogUtils;
import com.example.news.contract.NewsContract;
import com.example.news.model.NewsListModel;
import com.example.news.presenter.NewsPresenter;
import com.example.ui.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListFragment extends BaseFragment<NewsPresenter, NewsListModel> implements NewsContract.View,SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private LinearLayoutManager mLayoutManager;
    private NewsListAdapter adapter;

    private int mType = ApiConstants.TOP;
    private int page = 1;

    private static final String TAG = "NewsListFragment";


    public static NewsListFragment getInstance(int type) {
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErr(String err) {
        LogUtils.logd(TAG,err);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_newslist;
    }

    @Override
    protected void initView() {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark, R.color.primary_light,
                R.color.accent);
        refreshLayout.setOnRefreshListener(this);
        recycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recycleView.setItemAnimator(new DefaultItemAnimator());
        adapter = new NewsListAdapter(getActivity());
        recycleView.setAdapter(adapter);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mPresenter.getNewsListData(mType,page,ApiConstants.PAGE_SIZE,"0",1);
    }


    @Override
    public void returnNewsListData(List<News> newsList) {
        adapter.setNewsList(newsList);
    }
}
