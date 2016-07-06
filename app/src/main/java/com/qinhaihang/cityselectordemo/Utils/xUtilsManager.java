package com.qinhaihang.cityselectordemo.Utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/6 22:25
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.Utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class xUtilsManager {

    private OnRequestCallBack mOnRequestCallBack;

    public void setOnRequestCallBack(OnRequestCallBack onRequestCallBack){
        mOnRequestCallBack = onRequestCallBack;
    }

    public interface OnRequestCallBack{
        void onSuccess(String result);
        void onError(String error);
    }



    public void checkUserExists(String uuid){

        RequestParams params = new RequestParams(NetURl.checkUserExists);
        params.addParameter("UserId",uuid);

        x.http().post(
                params,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if(null != mOnRequestCallBack){
                            mOnRequestCallBack.onSuccess(result);
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        if(null != mOnRequestCallBack){
                            mOnRequestCallBack.onError(ex.toString());
                        }
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        if(null != mOnRequestCallBack){

                        }
                    }

                    @Override
                    public void onFinished() {
                        if(null != mOnRequestCallBack){

                        }
                    }
                }
        );

    }

    public static class Param{

    }

}
