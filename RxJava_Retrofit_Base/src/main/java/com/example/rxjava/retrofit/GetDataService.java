package com.example.rxjava.retrofit;

import com.example.rxjava.bean.Bean;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
/**
 * 被观察者模式下的网络数据请求接口类
 */
public interface GetDataService {
    /**
     * 使用@QueryMap注解通过get请求方式传递集合参数
     * @param map
     * @return
     */
    @GET("/nba")
    Observable<Bean> get(@QueryMap Map<String,String> map);

    /**
     * 使用@FieldMap注解通过get请求方式传递集合参数(对于本model的接口只能使用get请求)
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/nba")
    Observable<Bean> post(@FieldMap Map<String,String> map);
}
