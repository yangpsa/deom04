package com.bawei.myapplicationooo.mvp.model;

import com.bawei.myapplicationooo.net.OkHttpUtils;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 19:48
 * @Description：描述信息
 */
public class MainModems implements MainModel {
    @Override
    public void getData(final CallBacko callBacko) {
        new OkHttpUtils().get("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1").reuslt(new OkHttpUtils.HttpListenr() {
            @Override
            public void success(String data) {
                callBacko.success(data);
            }

            @Override
            public void fail() {
                callBacko.fail();
            }
        });
    }
}
