package com.example.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api.ApiConstants;
import com.example.common.base.BaseFragment;
import com.example.news.model.NewsListModel;
import com.example.news.presenter.NewsPresenter;
import com.example.news.view.NewsListView;
import com.example.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListFragment extends BaseFragment<NewsPresenter, NewsListModel> implements NewsListView,SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private LinearLayoutManager mLayoutManager;

    private int mType = ApiConstants.TOP;

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

    }

    @Override
    public void onRefresh() {

    }
}
