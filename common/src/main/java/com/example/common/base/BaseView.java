package com.example.common.base;

/**
 * Created by lxl on 2017/3/26.
 */

public interface BaseView {

    void showLoading(String msg);

    void hideLoading();

    void showErr(String err);
}
