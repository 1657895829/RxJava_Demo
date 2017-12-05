package com.app.utils;

import android.os.Bundle;
import android.view.View;
import com.app.utils.bean.Bean;
import com.app.utils.presenter.MyPresenter;
import com.app.utils.view.MyView;

//新建一个登录Activity类，继承自定义的BaseMvpActivity，持有v与p层
public class MainActivity extends BaseMvpActivity<MyView,MyPresenter> implements MyView {

    //声明p层
    @Override
    public MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用p层登录方法
                p.login("问天","88888888");
            }
        });
    }

    @Override
    public void success(Bean bean) {
        System.out.println("返回数据：" + bean.toString());
    }

    @Override
    public void failure() {

    }
}
