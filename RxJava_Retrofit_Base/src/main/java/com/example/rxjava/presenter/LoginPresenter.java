package com.example.rxjava.presenter;

import com.example.rxjava.BasePresenter;
import com.example.rxjava.bean.Bean;
import com.example.rxjava.model.LoginModel;
import com.example.rxjava.model.LoginModelCallBack;
import com.example.rxjava.view.LoginView;

/**
 * presenter层,继承自定义的p层，持有view层接口
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    //声明model层
    private LoginModel model;
    public LoginPresenter() {
        this.model = new LoginModel();
    }

    //登陆的方法
    public void login(String username,String password){
        model.getData(new LoginModelCallBack() {
            @Override
            public void success(Bean bean) {
                view.success(bean);         //view层获取数据
            }
        });
    }
}
