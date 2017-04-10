package com.example.common.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by lxl on 2017/3/13.
 */

public class BaseApplication extends Application{

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Context getAppContext(){
        return baseApplication;
    }
    public static Resources getAppResources(){
        return baseApplication.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
