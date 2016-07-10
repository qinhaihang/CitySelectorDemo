package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qinhaihang.cityselectordemo.Utils.NetUtils;
import com.qinhaihang.cityselectordemo.Utils.StringCallBack;
import com.qinhaihang.cityselectordemo.Utils.xUtilsManager;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_selector)
    TextView tv_selector;

    private static final String TAG = "MainActivity";
    private xUtilsManager mXUtilsManager;
    private OkHttpUtils mOkHttpUtils;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_selector.setText((String)msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){

        NetUtils.loginURL("cgy", "1", "cgy",
                new StringCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG,e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG,response);
                    }
                });

        startActivity(new Intent(MainActivity.this,CitySelectActivity.class));
        overridePendingTransition(R.anim.city_in_anim,0);

    }

}
