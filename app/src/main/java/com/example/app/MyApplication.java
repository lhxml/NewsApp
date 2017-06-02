package com.example.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.antfortune.freeline.FreelineCore;
import com.example.common.base.BaseApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxl on 2017/3/10.
 */

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);


    }

}

