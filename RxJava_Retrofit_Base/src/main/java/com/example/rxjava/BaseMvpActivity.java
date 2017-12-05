package com.example.rxjava;

import android.app.Activity;
import android.os.Bundle;

/**
 * Activity抽象类,持有View层和Presenter层
 * @param <V>  表示持有的View层
 * @param <T>  表示持有的Presenter层
 */
// 下面类的声明原型是： class BaseMvpActivity<LoginView,LoginPresenter extends BasePresneter<LoginView>> extends Activity {
public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends Activity {

    //声明持有的p层
    public T p;

    public abstract T initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvp);

        p = initPresenter();
    }

    //视图运行获取焦点时，连接view层
    @Override
    protected void onResume() {
        super.onResume();
        p.attach((V) this);
    }

    //试图销毁时释放内存
    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}