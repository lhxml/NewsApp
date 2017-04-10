package com.example.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxl on 2017/3/10.
 */

public class MyApplication extends Application{

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static Context getAppContext(){
        return myApplication;
    }
}

