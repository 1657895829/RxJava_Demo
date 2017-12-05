package com.app.utils.view;

import com.app.utils.bean.Bean;

/**
 * view层接口
 */

public interface MyView {
    public void success(Bean bean);
    public void failure();
}
