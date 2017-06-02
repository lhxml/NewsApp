package com.example.common.baserx;

import android.app.Activity;
import android.content.Context;

import com.example.common.R;
import com.example.common.base.BaseApplication;
import com.example.common.utils.NetWorkUtils;
import com.example.common.widget.LoadingDialog;

import java.net.SocketTimeoutException;

import rx.Subscriber;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by lxl on 2017/3/13.
 */

public abstract class RxSubscriber<T> extends Subscriber<T>{

    private Context mContext;
    private String msg;
    private boolean showDialog= false;

    public void showDialog() {
        this.showDialog= true;
    }
    public void hideDialog() {
        this.showDialog= true;
    }

    public RxSubscriber(Context context,String msg,boolean showDialog){
        this.mContext= context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context){
        this(context,"",true);
    }

    public RxSubscriber(Context context,boolean showDialog){
        this(context,"",showDialog);
    }
    @Override
    public void onCompleted() {
        if(showDialog){
            LoadingDialog.cancelDialogForLoading();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext,msg,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        e.printStackTrace();
        System.out.println("RxSubscriber=="+e.getMessage());
        checkNotNull(e);
        if(e.getMessage().equals(BaseApplication.getAppContext().getString(R.string.connect_timed_out))||e instanceof SocketTimeoutException){
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
            return;
        }
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);
}
