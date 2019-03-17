package com.bawei.myapplicationooo.bean;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 19:59
 * @Description：描述信息
 */
public class One {
    private String type;
    private String url;

    @Override
    public String toString() {
        return "One{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public One(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public One() {
    }
}
