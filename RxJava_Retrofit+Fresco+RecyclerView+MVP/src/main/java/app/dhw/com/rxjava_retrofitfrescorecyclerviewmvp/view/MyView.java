package app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.view;

import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.bean.Bean;

/**
 * view层接口类，请求成功与失败的方法
 */
public interface MyView {
    public void onSuccess(Bean bean);
    public void onFailure(Exception e);
}
