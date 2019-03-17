package com.bawei.myapplicationooo.mvp.model;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 19:46
 * @Description：描述信息
 */
public interface MainModel {

    interface CallBacko{
        void success(String data);
        void fail();
    }
    void getData(CallBacko callBacko);
}
