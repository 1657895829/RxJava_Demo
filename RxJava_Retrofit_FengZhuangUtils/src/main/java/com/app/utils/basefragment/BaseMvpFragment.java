package com.app.utils.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.utils.BasePresenter;

/**
 * Fragment抽象类,持有View层和Presenter层
 * @param <V>  表示持有的View层
 * @param <T>  表示持有的Presenter层
 */

public abstract class BaseMvpFragment<V,T extends BasePresenter<V>> extends Fragment {
    //声明持有的p层
    public abstract T initPresenter();
    public T presenter ;
    public Context context ;

    public BaseMvpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

//        //如果是在 onCreateView方法 引用p层，那么继承本类的Fragment使用p层获取数据也要在 onCreateView 方法中执行
//        presenter = initPresenter();
//        context = getActivity();
       return  null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //如果是在 onActivityCreated方法 引用p层，那么继承本类的Fragment使用p层获取数据也要在 onActivityCreated方法中执行
        presenter = initPresenter();
        context = getActivity();
    }

    //视图运行获取焦点时，连接view层
    @Override
    public void onResume() {
        super.onResume();
        presenter.attach((V) this);


    }

    //试图销毁时释放内存
    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detach();
    }
}
