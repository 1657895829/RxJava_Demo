package com.example.rxjava;

/**
 * 自定义的p层泛型类,持有View层接口
 */
public class BasePresenter<V> {
    // V 相当于V的接口
    public  V  view;

    /**
     * Presenter层创建时的方法， 持有View层 的接口
     * @param v
     */
    public void attach(V v){
        this.view = v;
    }

    /**
     * Presenter层 释放持有View的接口， 防止内存泄漏
     */
    public void detach(){
        this.view = null;
    }

}
