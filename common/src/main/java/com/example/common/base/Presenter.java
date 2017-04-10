package com.example.common.base;

/**
 * Created by lxl on 2017/3/26.
 */

public interface Presenter <T extends BaseView,E extends BaseModel>{

    void attachViewAndModel(T mvpView,E mModel);

    void detachView();
}
