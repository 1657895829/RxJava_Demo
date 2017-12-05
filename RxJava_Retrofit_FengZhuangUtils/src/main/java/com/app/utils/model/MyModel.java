package com.app.utils.model;

import com.app.utils.bean.Bean;
import com.app.utils.utils.APIGet_Post_Factory;
import com.app.utils.utils.AbstractObserver;
import java.util.HashMap;
import java.util.Map;
/**
 * model层实现类
 */
public class MyModel {

    //调用封装的请求方式的单例模式执行类请求接口,传入集合参数，使用被观察者发起定阅事件
    public void getData(final ModelCallBack callBack){
        Map<String,String> map = new HashMap<>();
        map.put("key","71e58b5b2f930eaf1f937407acde08fe");
        map.put("num","10");

        APIGet_Post_Factory.getInstance().post("/yunifang/mobile/home", map, new AbstractObserver<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                System.out.println(bean.toString());
            }

            @Override
            public void onFailure(int code) {
                System.out.println("code = " + code);
            }
        });

    }
}
