package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.qinhaihang.cityselectordemo.Utils.NetURl;
import com.qinhaihang.cityselectordemo.Utils.SimpleNetUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements SimpleNetUtils.RequestListener {

    private static final String TAG = "MainActivity";
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){

        mOkHttpClient = new OkHttpClient();

        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("userId","cgy");
        builder.add("userPass","1");
        builder.add("userType","cgy");

        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(NetURl.loginURL)
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d(TAG,request.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG,string);
            }
        });

        startActivity(new Intent(MainActivity.this,CitySelectActivity.class));
        overridePendingTransition(R.anim.city_in_anim,0);
    }

    @Override
    public void onSuccess(Object response) {
        String msg = (String) response;

        Log.d(TAG,msg);
    }

    @Override
    public void onError(Request request, Exception e) {

    }
}
