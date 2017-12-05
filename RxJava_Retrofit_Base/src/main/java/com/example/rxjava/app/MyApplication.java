package com.example.rxjava.app;

import android.app.Application;

import com.example.rxjava.retrofit.GetDataService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 全局配置初始化RxJava
 */
public class MyApplication extends Application {
    public static GetDataService request;

    @Override
    public void onCreate() {
        super.onCreate();

        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //初始化请求接口类
        request = retrofit.create(GetDataService.class);
    }
}
