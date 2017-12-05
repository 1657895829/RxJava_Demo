package com.app.utils.presenter;

import com.app.utils.BasePresenter;
import com.app.utils.bean.Bean;
import com.app.utils.model.ModelCallBack;
import com.app.utils.model.MyModel;
import com.app.utils.view.MyView;

/**
 * presenter层,继承自定义的p层，持有view层接口
 */

public class MyPresenter extends BasePresenter<MyView> {
    //声明model层
    private MyModel model;
    public MyPresenter() {
        this.model = new MyModel();
    }

    //登陆的方法
    public void login(String username,String password){
        model.getData(new ModelCallBack() {
            @Override
            public void success(Bean bean) {
                view.success(bean);         //view层获取数据
            }
        });
    }
}
