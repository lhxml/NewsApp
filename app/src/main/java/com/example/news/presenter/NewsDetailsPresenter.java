package com.example.news.presenter;

import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.base.BaseApplication;
import com.example.common.base.BasePresenter;
import com.example.common.baserx.RxSubscriber;
import com.example.common.utils.LogUtils;
import com.example.news.contract.NewsContract;
import com.example.news.contract.NewsDetailsContract;

import java.util.List;

/**
 * Created by lxl on 2017/3/29.
 */

public class NewsDetailsPresenter extends NewsDetailsContract.Presenter{

    private static final String TAG = "NewsPresenter";

    @Override
    public void getNewsDetailsData(int news_id, int tableNum, String callback) {
        mView.showLoading("");
        mModel.getNewsDetailsData(news_id,tableNum,callback).subscribe(new RxSubscriber<NewsDetails>(BaseApplication.getAppContext(),false) {
            @Override
            protected void _onNext(NewsDetails newsDetails) {
                System.out.println(newsDetails);
                mView.returnNewsDetailsData(newsDetails);
                mView.hideLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.hideLoading();
                mView.showErr(message);
            }
        });
    }

}
