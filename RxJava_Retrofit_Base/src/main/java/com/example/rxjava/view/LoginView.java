package com.example.rxjava.view;

import com.example.rxjava.bean.Bean;

/**
 * view层接口
 */

public interface LoginView {
    public void success(Bean bean);
    public void failure();
}
