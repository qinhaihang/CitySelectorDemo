package com.qinhaihang.cityselectordemo.Utils;

import com.google.gson.Gson;
import com.qinhaihang.cityselectordemo.bean.AddrBean;
import com.qinhaihang.cityselectordemo.bean.ResultBean;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import okhttp3.Call;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/9 23:24
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.Utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class NetUtils {

    private static OnReqeustCallback mOnReqeustCallback;

    public interface OnReqeustCallback{
        void onSuccess(Object result,int id);
        void onError(String error);
    }

    public static void loginURL(String uuid, String pwd, String userType, Callback callback){

        com.zhy.http.okhttp.OkHttpUtils.post()
                .url(NetURl.loginURL)
                .addParams("userId",uuid)
                .addParams("userPass",pwd)
                .addParams("userType",userType)
                .build()
                .execute(callback);

    }

    public static void requestAddr(String uuid, String supCity, int cityLev,OnReqeustCallback onReqeustCallback){

        mOnReqeustCallback = onReqeustCallback;

        com.zhy.http.okhttp.OkHttpUtils.post()
                .url(NetURl.getCityDataURL)
                .addParams("uuid",uuid)
                .addParams("SupCity",supCity)
                .addParams("CityLev",String.valueOf(cityLev))
                .build()
                .execute(new StringCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if(null != mOnReqeustCallback){
                            mOnReqeustCallback.onError(e.toString());
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Gson gson = new Gson();
                        ResultBean resultBean = gson.fromJson(response, ResultBean.class);

                        List<AddrBean> addrDataList = resultBean.getData();

                        if(null != mOnReqeustCallback){
                            mOnReqeustCallback.onSuccess(addrDataList,id);
                        }
                    }
                });

    }
}
