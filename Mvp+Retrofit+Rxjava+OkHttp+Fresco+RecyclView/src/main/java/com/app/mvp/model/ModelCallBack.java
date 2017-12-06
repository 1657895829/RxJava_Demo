package com.app.mvp.model;

import com.app.mvp.bean.Bean;

/**
 * model层接口，成功和失败的方法
 */
public interface ModelCallBack {
    public void onSuccess(Bean bean);
    public void onFailure(Exception e);
}
