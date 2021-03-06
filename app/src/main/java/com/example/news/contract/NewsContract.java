package com.example.news.contract;

import com.example.bean.News;
import com.example.bean.NewsDetails;
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

    }

    interface View extends BaseView{


    }
    abstract class Presenter extends BasePresenter<View,Model>{

    }


}
