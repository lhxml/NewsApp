package com.example.news.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.View;

import com.example.adapter.NewsListAdapter;
import com.example.api.ApiConstants;
import com.example.bean.News;
import com.example.common.base.BaseFragment;
import com.example.common.utils.LogUtils;
import com.example.news.contract.NewsContract;
import com.example.news.contract.NewsListContract;
import com.example.news.model.NewsListModel;
import com.example.news.model.NewsModel;
import com.example.news.presenter.NewsListPresenter;
import com.example.news.presenter.NewsPresenter;
import com.example.ui.R;
import com.example.util.LoadHelper;

import java.util.ArrayList;
import java.util.List;
import static com.google.common.base.Preconditions.checkNotNull;
import butterknife.BindView;

/**
 * Created by lxl on 2017/4/10.
 */

public class NewsListFragment extends BaseFragment<NewsListPresenter, NewsListModel> implements NewsListContract.View,SwipeRefreshLayout.OnRefreshListener,NewsListAdapter.OnItemClickListener{


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private LinearLayoutManager mLayoutManager;
    private NewsListAdapter adapter;

    private int mType = ApiConstants.TOP;
    private int page = 1;

    private static final String TAG = "NewsListFragment";

    private List<News> newsList;


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
        Log.i(TAG, "onCreate: "+mType);
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
        recycleView.setLayoutManager(mLayoutManager);
        adapter = new NewsListAdapter(getActivity());
        adapter.setOnItemClickListener(this);
        recycleView.addOnScrollListener(mOnScrollListener);
        recycleView.setAdapter(adapter);
        newsList = new ArrayList<>();
        onRefresh();
    }

    @Override
    public void onRefresh() {
        page = 1;
        refreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNewsListData(mType,page,ApiConstants.PAGE_SIZE,"0",1);
            }
        },2000);

    }


    @Override
    public void returnNewsListData(List<News> newsList) {
        checkNotNull(newsList);
        if(page==1){
            adapter.setNewsList(newsList);
            this.newsList = newsList;
            refreshLayout.setRefreshing(false);

        }else{
            adapter.addNewsList(newsList);
            this.newsList.addAll(newsList);
            LoadHelper.getInstance(getActivity()).endLoadMore();
        }

    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener(){

        private int lastVisibleItem;
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            LogUtils.logd(TAG,"onScrolled::lastVisibleItem="+lastVisibleItem);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if(newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()){
                loadMore();
            }
        }
    };

    public void loadMore(){
        page = page + 1;
        mPresenter.getNewsListData(mType,page,ApiConstants.PAGE_SIZE,"0",1);
    }

    @Override
    public void OnItemClick(View view, int position) {
        News news = newsList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("tableNum",mType);
        bundle.putParcelable("news",news);
        startActivity(NewsDetailsActivity.class,bundle);
}
}
