package com.qinhaihang.cityselectordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.qinhaihang.cityselectordemo.Utils.NetURl;
import com.qinhaihang.cityselectordemo.Utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//NetURL.getCityDataURL
//mParams.put(Param.UUID,uuid);
//        mParams.put("SupCity", supCity);
//        mParams.put("CityLev", String.valueOf(cityLev));

public class CitySelectActivity extends AppCompatActivity {

    @BindView(R.id.lv_city)
    ListView lv_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);
        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.city_out_anim);
    }

    @OnClick({R.id.rl_top , R.id.iv_close})
    public void back(View view){
        finish();
        overridePendingTransition(0,R.anim.city_out_anim);
    }

    public void request(){
        OkHttpClientManager.postAsyn(NetURl.getCityDataURL,
                new OkHttpClientManager.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                },
                new OkHttpClientManager.Param[]{
                        new OkHttpClientManager.Param("uuid",""),
                        new OkHttpClientManager.Param("SupCity",""),
                        new OkHttpClientManager.Param("CityLev","")
                });
    }

}
