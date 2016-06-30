package com.qinhaihang.cityselectordemo.Utils;

import com.squareup.okhttp.Request;

/**
 * Created by qinhh on 16/6/30.
 */
public class SimpleNetUtils {

    private RequestListener mRequestListener;

    public SimpleNetUtils(RequestListener mRequestListener) {
        this.mRequestListener = mRequestListener;
    }

    public interface RequestListener{
        void onSuccess(Object response);
        void onError(Request request, Exception e);
    }

    public void setRequestListener(RequestListener requestListener){
        mRequestListener = requestListener;
    }

    public void login( String account, String password, String userType){
        OkHttpClientManager.postAsyn(NetURl.loginURL,
                new OkHttpClientManager.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        if(null != mRequestListener){
                            mRequestListener.onError(request,e);
                        }
                    }

                    @Override
                    public void onResponse(Object response) {
                        if(null != mRequestListener){
                            mRequestListener.onSuccess(response);
                        }
                    }
                },
                new OkHttpClientManager.Param[]{
                        new OkHttpClientManager.Param("userId", account),
                        new OkHttpClientManager.Param("userPass",password),
                        new OkHttpClientManager.Param("userType",userType)
                });
    }

}
