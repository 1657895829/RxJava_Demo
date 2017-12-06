package com.app.mvp.app;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 用于全局配置初始化Fresco 图片加载
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
