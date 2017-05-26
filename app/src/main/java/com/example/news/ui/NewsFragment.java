package com.example.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api.ApiConstants;
import com.example.bean.News;

import com.example.common.base.BaseFragment;
import com.example.common.base.BaseView;
import com.example.news.contract.NewsContract;
import com.example.news.model.NewsModel;
import com.example.news.presenter.NewsPresenter;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lxl on 2017/3/29.
 */

public class NewsFragment extends BaseFragment<NewsPresenter, NewsModel> implements BaseView {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public NewsFragment() {

    }

    public static NewsFragment getInstance() {
        return new NewsFragment();
    }


    @Override
    public int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        viewpager.setOffscreenPageLimit(3);
        setupViewPager(viewpager);
        setupTabLayout(tabLayout);

    }



    public void setupViewPager(ViewPager viewpager){
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(NewsListFragment.getInstance(ApiConstants.TOP),getString(R.string.newslist_top));
        adapter.addFragment(NewsListFragment.getInstance(ApiConstants.ENTERTAINMENT),getString(R.string.newslist_entertainment));
        adapter.addFragment(NewsListFragment.getInstance(ApiConstants.MILITARY),getString(R.string.newslist_military));
        adapter.addFragment(NewsListFragment.getInstance(ApiConstants.CARS),getString(R.string.newslist_cars));
        viewpager.setAdapter(adapter);
    }

    public void setupTabLayout(TabLayout tabLayout){
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.newslist_top)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.newslist_entertainment)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.newslist_cars)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.newslist_military)));
        tabLayout.setupWithViewPager(viewpager);
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

    public static class MyPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment,String title){
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
