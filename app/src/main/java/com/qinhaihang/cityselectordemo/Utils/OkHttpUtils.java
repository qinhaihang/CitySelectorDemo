package com.qinhaihang.cityselectordemo.Utils;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/6/30 23:01
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.Utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class OkHttpUtils {

    private static final String TAG = "OkHttpUtils";
    private static OkHttpUtils mInstance;
    private final OkHttpClient mOkHttpClient;

    public OkHttpUtils() {

        mOkHttpClient = new OkHttpClient();

    }

    public static OkHttpUtils getInstance(){

        if(mInstance == null){
            synchronized (OkHttpUtils.class){
                if(mInstance == null){
                    mInstance = new OkHttpUtils();
                }
            }
        }

        return mInstance;
    }

    public void post() throws IOException {

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

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG,string);
            }
        });

    }

}
