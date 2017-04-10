package com.example.news.contract;

import com.example.bean.News;
import com.example.common.base.BaseModel;
import com.example.common.base.BasePresenter;
import com.example.common.base.BaseView;
import com.example.main.contract.MainContract;

import java.util.List;

import rx.Observable;

/**
 * Created by lxl on 2017/3/29.
 */

public interface NewsContract {

    interface Model extends BaseModel{
        Observable<List<News>> getNewsListData(int tableNum,int page,int pagesize,String callback,int justList);
    }

    interface View extends BaseView{
        void returnNewsListData(List<News> newsList);
    }
    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getNewsListData(int tableNum,int page,int pagesize,String callback,int justList);
    }


}
