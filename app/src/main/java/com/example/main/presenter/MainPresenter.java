package com.example.main.presenter;

import com.example.common.base.BaseModel;
import com.example.common.base.BasePresenter;
import com.example.common.base.BaseView;
import com.example.main.contract.MainContract;
import com.example.main.view.MainView;
import com.example.ui.R;

/**
 * Created by lxl on 2017/3/27.
 */

public class MainPresenter extends MainContract.Presenter{


    @Override
    public void switchNavigation(int id) {
        checkViewAttach();
        switch(id){
            case R.id.navigation_item_news:
                mView.switchToNews();
                break;
            case R.id.navigation_item_images:
                mView.switchToImages();
                break;
            case R.id.navigation_item_weather:
                mView.switchToImages();
                break;
            case R.id.navigation_item_about:
                mView.switchToAbout();
                break;
            default:
                mView.switchToNews();
                break;
        }

    }


}
