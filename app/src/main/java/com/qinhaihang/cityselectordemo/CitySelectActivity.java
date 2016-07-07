package com.qinhaihang.cityselectordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.qinhaihang.cityselectordemo.app.BaseApplicatin;
import com.qinhaihang.cityselectordemo.bean.CUserDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CitySelectActivity extends AppCompatActivity {

    @BindView(R.id.lv_city)
    ListView lv_city;
    private CUserDataBean mCUserDataBean;
    private String mUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);
        ButterKnife.bind(this);
        mCUserDataBean = BaseApplicatin.getCUserDataBean();
        if(null != mCUserDataBean){
            mUuid = mCUserDataBean.getUserId();
        }


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

}
