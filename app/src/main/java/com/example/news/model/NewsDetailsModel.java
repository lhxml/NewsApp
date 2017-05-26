package com.example.news.model;

import com.example.api.ApiConfiguration;
import com.example.api.ApiConstants;
import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.baserx.RxUtils;
import com.example.news.contract.NewsContract;
import com.example.news.contract.NewsDetailsContract;
import com.example.service.NewsService;
import com.example.util.RetrofitUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by lxl on 2017/3/29.
 */

public class NewsDetailsModel implements NewsDetailsContract.Model{

    @Override
    public Observable<NewsDetails> getNewsDetailsData(int news_id, int tableNum, String callback) {

        return RetrofitUtils.getInstance().initService(ApiConstants.NEWS_URL,NewsService.class)
                .getNewsDetailsData(news_id,tableNum,callback)
                .compose(RxUtils.<NewsDetails>rxSchedulerHelper());
    }
}
