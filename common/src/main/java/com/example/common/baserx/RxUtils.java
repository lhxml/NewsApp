package com.example.common.baserx;


import com.example.common.base.BaseResponse;
import com.example.common.utils.LogUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lxl on 2017/3/14.
 */

public class RxUtils {

    public static <T> Observable.Transformer<BaseResponse<T>,T> rxSchedulerHelper(){
        return new Observable.Transformer<BaseResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResponse<T>> baseResponseObservable) {

                return baseResponseObservable.map(new Func1<BaseResponse<T>, T>() {
                    @Override
                    public T call(BaseResponse<T> tBaseResponse) {
                        if(tBaseResponse.getStatus()==200){
                            LogUtils.logd("RxUtils","success");
                            return tBaseResponse.getData();
                        }else{
                            LogUtils.logd("RxUtils","fail");
                            return (T) Observable.error(new ServerException(tBaseResponse.getError()));
                        }

                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
