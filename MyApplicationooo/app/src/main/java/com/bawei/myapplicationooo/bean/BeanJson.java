package com.bawei.myapplicationooo.bean;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 20:00
 * @Description：描述信息
 */
public class BeanJson {
    private ArrayList<One> results;

    @Override
    public String toString() {
        return "BeanJson{" +
                "results=" + results +
                '}';
    }

    public ArrayList<One> getResults() {
        return results;
    }

    public void setResults(ArrayList<One> results) {
        this.results = results;
    }

    public BeanJson(ArrayList<One> results) {
        this.results = results;
    }

    public BeanJson() {
    }
}
