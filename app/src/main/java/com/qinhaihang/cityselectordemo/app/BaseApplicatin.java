package com.qinhaihang.cityselectordemo.app;

import android.app.Application;

import com.zhy.http.okhttp.BuildConfig;
import com.zhy.http.okhttp.OkHttpUtils;

import org.xutils.x;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/5 22:58
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.app
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class BaseApplicatin extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L,TimeUnit.MILLISECONDS)
                .build();

        OkHttpUtils.initClient(okHttpClient);

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
