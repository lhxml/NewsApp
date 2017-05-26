package com.example.news.contract;

import com.example.bean.NewsDetails;
import com.example.common.base.BaseModel;
import com.example.common.base.BasePresenter;
import com.example.common.base.BaseView;

import rx.Observable;

/**
 * Created by lxl on 2017/3/29.
 */

public interface NewsDetailsContract {

    interface Model extends BaseModel{

        Observable<NewsDetails> getNewsDetailsData(int news_id, int tableNum, String callback);
    }

    interface View extends BaseView{

        void returnNewsDetailsData(NewsDetails newsDetails);
    }
    abstract class Presenter extends BasePresenter<View,Model>{

        public abstract void getNewsDetailsData(int news_id,int tableNum,String callback);
    }


}
