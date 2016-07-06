package com.qinhaihang.cityselectordemo.Utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/5 21:34
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.Utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class OkHttpUtils {

    public static OkHttpUtils mInstance;
    public OkHttpClient okHttpClient;
    public OnResultCallback mOnResultCallback;

    public OkHttpUtils() {

        okHttpClient = new OkHttpClient();

    }

    public static OkHttpUtils getInstance(){

        if(mInstance == null){
            synchronized (OkHttpUtils.class){
                if(mInstance == null){
                    mInstance = new OkHttpUtils();
                }
            }
        }

        return mInstance;
    }


    public interface OnResultCallback{
        void onSuccess(String result);
        void onError(String error);
    }

    public void setOnResultCallback(OnResultCallback onResultCallback){
        mOnResultCallback = onResultCallback;
    }

    public Request request(String url, RequestBody body){

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).post(body).build();

        return request;
    }

    public RequestBody body(Param... params){

        FormBody.Builder builder = new FormBody.Builder();

        for (Param param : params){
            builder.add(param.key,param.value);
        }

        return builder.build();
    }

    /**
     * 异步请求
     * @param url
     * @param params
     */
    public void post(String url,Param... params){
        RequestBody body = body(params);
        Request request = request(url, body);
        enqueue(request);
    }

    /**

     * 开启异步线程访问网络

     * @param request

     * @param responseCallback

     */

    public void enqueue(Request request, Callback responseCallback){

        okHttpClient.newCall(request).enqueue(responseCallback);

    }

    /**

     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）

     * @param request

     */

    public void enqueue(Request request){

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                String failure = call.request().body().toString();
                if(null != mOnResultCallback){
                    mOnResultCallback.onError(failure);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String msg = response.body().string();
                if(null != mOnResultCallback){
                    mOnResultCallback.onSuccess(msg);
                }
            }
        });

    }

    public static class Param {
        String key;
        String value;

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
