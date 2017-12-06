package com.app.mvp.model;

import com.app.mvp.bean.Bean;
import com.app.mvp.retrofit.GetDataInterface;
import com.app.mvp.retrofit_rxjava_okhttp.LoggingInterceptor;
import com.app.mvp.retrofit_rxjava_okhttp.RetrofitUnitl;
import java.util.concurrent.TimeUnit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

//model接口实现类
public class MyModel {
    /**
     * 使用Retrofit结合RxJava的get请求数据，使用@Query注解传递参数
     * @param callBack
     */
    public void getData(final ModelCallBack callBack) {
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        //使用Retrofit结合RxJava，okhttp封装类的单例模式
        RetrofitUnitl.getInstance("http://api.tianapi.com",ok)
                .setCreate(GetDataInterface.class)
                .getData("71e58b5b2f930eaf1f937407acde08fe",18)
                .subscribeOn(Schedulers.io())               //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())  //最后在主线程中执行

                //进行事件的订阅，使用Consumer实现
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        //请求成功时返回数据
                        callBack.onSuccess(bean);
                        System.out.println(bean.toString());
                    }
                });
    }

}
