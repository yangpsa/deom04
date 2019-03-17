package com.bawei.myapplicationooo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.bawei.myapplicationooo.adapter.ItmAdapter;
import com.bawei.myapplicationooo.adapter.NewsAdapter;
import com.bawei.myapplicationooo.bean.BeanJson;
import com.bawei.myapplicationooo.bean.One;
import com.bawei.myapplicationooo.mvp.model.MainModems;
import com.bawei.myapplicationooo.mvp.presenter.MainPresenms;
import com.bawei.myapplicationooo.mvp.view.MainView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private XRecyclerView x_recycler;
    private MainPresenms mainPresenms;
    private ArrayList<One> list =new ArrayList<>();
    private ItmAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        x_recycler = findViewById(R.id.x_recycler);

        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        x_recycler.setLayoutManager(layoutManager);

//        newsAdapter = new NewsAdapter(this);
        newsAdapter = new ItmAdapter(this);
        x_recycler.setAdapter(newsAdapter);

        x_recycler.setLoadingMoreEnabled(true);
        x_recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mainPresenms.doData();
            }

            @Override
            public void onLoadMore() {
                mainPresenms.doData();
            }
        });

        mainPresenms = new MainPresenms(new MainModems(),this);
        mainPresenms.doData();
    }

    @Override
    public void success(String data) {

        BeanJson beanJson = new Gson().fromJson(data, BeanJson.class);
        list = beanJson.getResults();
        newsAdapter.setData(list);
        x_recycler.refreshComplete();
        x_recycler.loadMoreComplete();
    }

    @Override
    public void fail() {
        x_recycler.refreshComplete();
        x_recycler.loadMoreComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenms.destroy();
    }
}
