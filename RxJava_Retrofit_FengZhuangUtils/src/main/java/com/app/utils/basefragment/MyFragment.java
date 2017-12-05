package com.app.utils.basefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 定义的fragment继承自定义的Fragment类
 */

public class MyFragment extends BaseMvpFragment<MyFragmentView,MyFragmentPresenter> {
    @Override
    public MyFragmentPresenter initPresenter() {
        return new MyFragmentPresenter();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
