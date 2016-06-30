package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.qinhaihang.cityselectordemo.Utils.SimpleNetUtils;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements SimpleNetUtils.RequestListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){

        SimpleNetUtils utils = new SimpleNetUtils(this);
        utils.login("cgy","1","cgy");

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
