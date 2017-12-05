package app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp;

/**
 * 自定义一个Presenter层，持有view层接口
 */
public class BasePresenter<V> {
    // V 相当于V的接口
    public V view;

    /**
     * Presenter 持有View 的接口
     * @param v
     */
    public void attach(V v){
        this.view = v;
    }

    /**
     * Presenter 释放持有View的接口， 防止内存泄漏
     */
    public void detach(){
        this.view = null;
    }
}
