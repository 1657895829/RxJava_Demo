package app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.adapter.MyAdapter;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.bean.Bean;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.presenter.MyPresenter;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;

//主页面继承自定义Activity，持有p与c层
public class MainActivity extends BaseMvpActivity<MyView, MyPresenter> implements MyView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyAdapter adapter;

    //声明presenter层,与view层交互
    @Override
    public MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //p层的get请求方式
//     p.get1();   //不传递参数
//     p.get2();   //只使用Retrofit的get请求数据,使用@QueryMap注解传递集合参数

        p.get();     //使用Retrofit+RxJava的get请求数据,使用@QueryMap注解传递集合参数
    }

    @Override
    public void onSuccess(Bean bean) {
        //设置布局管理器以及布局适配器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this);
        adapter.addData(bean);
        recyclerView.setAdapter(adapter);

        Toast.makeText(MainActivity.this,"数据："+bean.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Exception e) {
        System.out.println("数据出错："+e);
    }
}
