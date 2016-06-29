package com.qinhaihang.cityselectordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rl_selector)
    public void rl_selector(View view){
        startActivity(new Intent(MainActivity.this,CitySelectActivity.class));
        overridePendingTransition(R.anim.city_in_anim,0);
    }
}
