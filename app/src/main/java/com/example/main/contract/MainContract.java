package com.example.main.contract;


import com.example.bean.News;
import com.example.common.base.BaseModel;
import com.example.common.base.BasePresenter;
import com.example.common.base.BaseView;
import com.example.main.view.MainView;

import java.util.List;

import rx.Observable;

/**
 * Created by lxl on 2017/4/6.
 */

public interface MainContract {

    interface Model extends BaseModel{
        void switchNavigation(int id);
    }

    interface View extends BaseView{
        void switchToNews();

        void switchToImages();

        void switchToWeather();

        void switchToAbout();
    }
    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void switchNavigation(int id);

    }
}
