package com.app.mvp.retrofit;

import com.app.mvp.bean.Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络接口数据的请求类
 * 接口： http://api.tianapi.com/military/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
 */
public interface GetDataInterface {
    /*
     * 使用Observable被观察者模式下的的get请求数据 @Query注解传递参数
     */
    @GET("/military/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
    Observable<Bean> getData(@Query("key") String key,@Query("num") int num);

}
