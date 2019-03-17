package com.bawei.myapplicationooo.net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 19:31
 * @Description：描述信息
 */
public class OkHttpUtils {

    private HttpListenr listenr;
    private int HTTP_FAIL=1001;
    private int HTTP_SUCCESS=1000;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == HTTP_SUCCESS){
                String data = (String) msg.obj;
                listenr.success(data);
            }else{
                listenr.fail();
            }
        }
    };


    //get请求
    public OkHttpUtils get(String url){
        doHttp(url,0,null);
        return this;
    }
    //post请求
    public OkHttpUtils post(String url,FormBody.Builder boyBuilder){
        doHttp(url,1,boyBuilder);
        return this;
    }

    private void doHttp(String url, int type, FormBody.Builder boyBuilder) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LanJie()).build();
        Request.Builder builder = new Request.Builder();
        builder.url(url);


        if (type == 0){
            builder.get();
        }else {
            RequestBody body = boyBuilder.build();
            builder.post(body);
        }

        final Message message = new Message();
        Request request=builder.build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
             message.what=HTTP_FAIL;
             handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            message.obj=response.body().string();
            message.what=HTTP_SUCCESS;
            handler.sendMessage(message);
            }
        });
    }


    public void reuslt(HttpListenr listenr){
        this.listenr=listenr;
    }
    public interface HttpListenr{
        void success(String data);
        void fail();
    }

    public class LanJie implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            boolean https = request.isHttps();
            return chain.proceed(request);
        }
    }
}
