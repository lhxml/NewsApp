package com.example.news.presenter;

import android.view.View;

import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.base.BaseApplication;
import com.example.common.baserx.RxSubscriber;
import com.example.common.utils.LogUtils;
import com.example.news.contract.NewsContract;
import com.example.news.contract.NewsListContract;

import java.util.List;

/**
 * Created by lxl on 2017/3/29.
 */

public class NewsListPresenter extends NewsListContract.Presenter{

    private static final String TAG = "NewsPresenter";

    @Override
    public void getNewsListData(int tableNum, int page, int pagesize, String callback, int justList) {
        mModel.getNewsListData(tableNum,page,pagesize,callback,justList).subscribe(new RxSubscriber<List<News>>(BaseApplication.getAppContext(),false) {
            @Override
            protected void _onNext(List<News> newses) {
                LogUtils.logd(TAG,"news=="+newses);
                mView.returnNewsListData(newses);
            }

            @Override
            protected void _onError(String message) {
                mView.showErr(message);
            }
        });
    }



}
