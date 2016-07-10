package com.qinhaihang.cityselectordemo.Utils;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/9 23:33
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.Utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public abstract class StringCallBack extends Callback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {

        return response.body().string();
    }
}
