package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.qinhaihang.cityselectordemo.Utils.NetURl;
import com.qinhaihang.cityselectordemo.Utils.xUtilsManager;
import com.qinhaihang.cityselectordemo.app.BaseApplicatin;
import com.qinhaihang.cityselectordemo.bean.CUserBeanS;
import com.qinhaihang.cityselectordemo.bean.CUserDataBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private xUtilsManager mXUtilsManager;
    private OkHttpUtils mOkHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mOkHttpUtils = new OkHttpUtils();
//        mOkHttpUtils.setOnResultCallback(new OkHttpUtils.OnResultCallback() {
//            @Override
//            public void onSuccess(String result) {
//                Log.d(TAG,"onSuccess"+result);
//            }
//
//            @Override
//            public void onError(String error) {
//                Log.d(TAG,"onError"+error);
//            }
//        });
    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){

        OkHttpUtils.post()
                .url(NetURl.loginURL)
                .addParams("userId","cgy")
                .addParams("userPass","1")
                .addParams("userType","cgy")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {

                        Log.d(TAG,"parseNetworkResponse"+response.body().string());

                        try{
                            Gson gson = new Gson();
                            CUserBeanS cUserBeanS = gson.fromJson(response.body().string(), CUserBeanS.class);

                            CUserDataBean cUserDataBean = cUserBeanS.getData();
                            BaseApplicatin.setCUserDataBean(cUserDataBean);

                        } catch (Exception e){
                            e.printStackTrace();
                        }

                        startActivity(new Intent(MainActivity.this,CitySelectActivity.class));
                        overridePendingTransition(R.anim.city_in_anim,0);

                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG,"onError"+e.toString());
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        Log.d(TAG,"onResponse"+response);
                    }
                });

//        OkHttpUtils.Param param = new OkHttpUtils.Param("UserId","cgy");
//
//        mOkHttpUtils.post(NetURl.checkUserExists,param);

    }

}
