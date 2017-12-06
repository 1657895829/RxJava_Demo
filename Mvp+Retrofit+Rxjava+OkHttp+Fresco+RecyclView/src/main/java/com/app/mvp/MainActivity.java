package com.app.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.app.mvp.adapter.MyAdapter;
import com.app.mvp.bean.Bean;
import com.app.mvp.presenter.MyPresenter;
import com.app.mvp.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;

//主页面继承自定义Activity，持有p与c层
public class MainActivity extends AppCompatActivity implements MyView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyAdapter adapter;
    private MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //调用P层
        presenter = new MyPresenter(MainActivity.this);

        //p层的用Retrofit+RxJava的get请求数据,使用@Query注解传递参数
        presenter.get();
    }

    @Override
    public void onSuccess(Bean bean) {

        //设置布局管理器以及布局适配器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this);
        adapter.addData(bean);
        recyclerView.setAdapter(adapter);

        Toast.makeText(MainActivity.this, "数据：" + bean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Exception e) {
        System.out.println("数据出错：" + e);
    }

    //调用P层的解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
