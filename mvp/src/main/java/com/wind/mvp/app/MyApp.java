package com.wind.mvp.app;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by H on 2017/10/22.
 * 用于获取应用全局的上下文
 * 这个类是整个应用的入口，一些你希望在应用一跑起来就立即完成的工作
 * （比如初始化一些三方库，包括 SDK），可以写入它的 onCreate() 方法。
 */

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    //郭霖版 p459 第一行代码
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //郭霖版
        context = getApplicationContext();
        LitePal.initialize(context);
    }

}
