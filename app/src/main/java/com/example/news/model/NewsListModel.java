package com.example.news.model;

import com.example.api.ApiConstants;
import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.baserx.RxUtils;
import com.example.news.contract.NewsContract;
import com.example.news.contract.NewsListContract;
import com.example.service.NewsService;
import com.example.util.RetrofitUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by lxl on 2017/3/29.
 */

public class NewsListModel implements NewsListContract.Model{
    /**
     *获取新闻首页列表
     */
    @Override
    public Observable<List<News>> getNewsListData(int tableNum, int page, int pagesize, String callback, int justList) {
        return RetrofitUtils.getInstance().initService(ApiConstants.NEWS_URL, NewsService.class)
                    .getNewsListData(tableNum,page,pagesize,callback,justList)
                    .compose(RxUtils.<List<News>>rxSchedulerHelper());
    }

}
