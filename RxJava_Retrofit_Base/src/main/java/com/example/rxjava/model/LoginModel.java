package com.example.rxjava.model;

import com.example.rxjava.app.MyApplication;
import com.example.rxjava.bean.Bean;
import java.util.HashMap;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * model层实现类
 */
public class LoginModel {
    public void getData(final LoginModelCallBack callBack){
        //设置请求接口的集合参数
        HashMap<String,String>  map = new HashMap<>();
        map.put("key","71e58b5b2f930eaf1f937407acde08fe");
        map.put("num","10");

        //发起异步请求，执行订阅事件
        MyApplication.request.get(map)
                .subscribeOn(Schedulers.io())       //先在io线程执行
                .observeOn(AndroidSchedulers.mainThread())  //最后在主线程执行
                .subscribe(new Consumer<Bean>() {          //最后在订阅事件中实现数据的获取
                    @Override
                    public void accept(Bean bean) throws Exception {
                        callBack.success(bean);     //获取成功的数据
                    }
                });
    }
}
