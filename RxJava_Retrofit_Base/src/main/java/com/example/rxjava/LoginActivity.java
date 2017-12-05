package com.example.rxjava;
import android.os.Bundle;
import android.view.View;
import com.example.rxjava.bean.Bean;
import com.example.rxjava.presenter.LoginPresenter;
import com.example.rxjava.view.LoginView;

//新建一个登录Activity类，继承自定义的BaseMvpActivity，持有v与p层
public class LoginActivity extends BaseMvpActivity<LoginView,LoginPresenter> implements LoginView {

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
