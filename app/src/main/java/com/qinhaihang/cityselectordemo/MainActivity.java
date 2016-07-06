package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.qinhaihang.cityselectordemo.Utils.NetURl;
import com.qinhaihang.cityselectordemo.Utils.OkHttpUtils;
import com.qinhaihang.cityselectordemo.Utils.xUtilsManager;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private xUtilsManager mXUtilsManager;
    private OkHttpUtils mOkHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOkHttpUtils = new OkHttpUtils();
        mOkHttpUtils.setOnResultCallback(new OkHttpUtils.OnResultCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG,"onSuccess"+result);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG,"onError"+error);
            }
        });
    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){

//        OkHttpUtils.post()
//                .url(NetURl.checkUserExists)
//                .addParams("UserId","cgy")
//                .build()
//                .execute(new Callback() {
//                    @Override
//                    public Object parseNetworkResponse(Response response, int id) throws Exception {
//
//                        Log.d(TAG,"parseNetworkResponse"+response.body().string());
//                        return null;
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Log.d(TAG,"onError"+e.toString());
//                    }
//
//                    @Override
//                    public void onResponse(Object response, int id) {
//                        Log.d(TAG,"onResponse"+response);
//                    }
//                });

        OkHttpUtils.Param param = new OkHttpUtils.Param("UserId","cgy");

        mOkHttpUtils.post(NetURl.checkUserExists,param);

        startActivity(new Intent(MainActivity.this,CitySelectActivity.class));
        overridePendingTransition(R.anim.city_in_anim,0);
    }

}
