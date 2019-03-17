package com.bawei.myapplicationooo.mvp.presenter;

import com.bawei.myapplicationooo.mvp.model.MainModel;
import com.bawei.myapplicationooo.mvp.model.MainModems;
import com.bawei.myapplicationooo.mvp.view.MainView;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 19:51
 * @Description：描述信息
 */
public class MainPresenms implements MainPre, MainModel.CallBacko {

    private MainModems mainModems;
    private MainView mainView;

    public MainPresenms(MainModems mainModems, MainView mainView) {
        this.mainModems = mainModems;
        this.mainView = mainView;
    }

    @Override
    public void doData() {
        mainModems.getData(this);
    }

    @Override
    public void success(String data) {
        mainView.success(data);
    }

    @Override
    public void fail() {
        mainView.fail();
    }

    public void destroy(){
        if (mainModems!=null){
            mainModems=null;
        }
        if (mainView!=null){
            mainView=null;
        }
    }
}
