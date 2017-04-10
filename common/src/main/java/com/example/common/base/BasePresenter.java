package com.example.common.base;

import com.example.common.baserx.RxManager;

/**
 * Created by lxl on 2017/3/26.
 */

public abstract class BasePresenter<T extends BaseView,E extends BaseModel> implements Presenter<T,E>{

    public T mView;
    public E mModel;
    public RxManager mRxManager = new RxManager();

    @Override
    public void attachViewAndModel(T mvpView, E mModel) {
        this.mView = mvpView;
        this.mModel = mModel;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 判断 view是否为空
     * @return
     */
    public  boolean isAttachView(){
        return mView != null;
    }

    /**
     * 返回目标view
     * @return
     */
    public  T  getMvpView(){
        return mView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach(){
        if(! isAttachView()){
            throw  new MvpViewNotAttachedException();
        }
    }
    public void onDestroy(){
        mRxManager.clear();
    }
    /**
     * 自定义异常
     */
    public static   class  MvpViewNotAttachedException extends RuntimeException{
        public  MvpViewNotAttachedException(){
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }
}
