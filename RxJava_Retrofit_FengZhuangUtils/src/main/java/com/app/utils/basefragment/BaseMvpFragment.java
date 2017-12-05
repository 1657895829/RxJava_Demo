package com.app.utils.basefragment;

import android.content.Context;
import android.os.Bundle;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = initPresenter() ;
        context = getActivity() ;
       return  null;
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
