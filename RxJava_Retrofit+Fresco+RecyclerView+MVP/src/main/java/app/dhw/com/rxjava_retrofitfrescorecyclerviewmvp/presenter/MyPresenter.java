package app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.presenter;

// Presenter层，进行view层与model数据的交互
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.BasePresenter;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.bean.Bean;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.model.ModelCallBack;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.model.MyModel;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.view.MyView;

public class MyPresenter extends BasePresenter<MyView> {
    private MyModel myModel;
    public MyPresenter() {
        this.myModel = new MyModel();
    }

    /**
     * 简单使用Retrofit的get请求, 不传递参数
     */
    public void get1(){
        myModel.getData1(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    /**
     * 简单使用Retrofit的get请求, 使用@QueryMap注解传递集合参数
     */
    public void get2(){
        myModel.getData2(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    /**
     * 简单使用Retrofit结合RxJava的get请求数据, 使用@QueryMap注解传递集合参数
     */
    public void get(){
        myModel.getData(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    //取消p层与v层的绑定，防止内存泄露
    @Override
    public void detach(){
        this.view = null;
    }
}
