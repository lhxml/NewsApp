package com.example.service;

import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.base.BaseResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lxl on 2017/3/29.
 */

public interface NewsService {

    @GET("news/get-news")
    Observable<BaseResponse<List<News>>> getNewsListData(@Query("tableNum") int tableNum,
                                               @Query("page") int page,
                                               @Query("pagesize") int pagesize,
                                               @Query("callback") String callback,
                                               @Query("justList") int justList);
    @GET("news/single-news")
    Observable<BaseResponse<NewsDetails>> getNewsDetailsData(@Query("news_id") int news_id,
                                                             @Query("tableNum") int tableNum,
                                                             @Query("callback") String callback);
}
