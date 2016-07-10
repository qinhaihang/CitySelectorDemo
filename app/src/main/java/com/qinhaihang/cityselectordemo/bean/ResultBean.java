package com.qinhaihang.cityselectordemo.bean;

import java.util.List;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/10 11:12
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.bean
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class ResultBean {


    /**
     * ret : 0
     * msg : ok
     * totalnum : 31
     * data : [{"childList":[],"cityId":"11","cityLev":"","cityName":"北京市","supCity":""},{"childList":[],"cityId":"12","cityLev":"","cityName":"天津市","supCity":""},{"childList":[],"cityId":"13","cityLev":"","cityName":"河北省","supCity":""},{"childList":[],"cityId":"14","cityLev":"","cityName":"山西省","supCity":""},{"childList":[],"cityId":"15","cityLev":"","cityName":"内蒙古自治区","supCity":""},{"childList":[],"cityId":"21","cityLev":"","cityName":"辽宁省","supCity":""},{"childList":[],"cityId":"22","cityLev":"","cityName":"吉林省","supCity":""},{"childList":[],"cityId":"23","cityLev":"","cityName":"黑龙江省","supCity":""},{"childList":[],"cityId":"31","cityLev":"","cityName":"上海市","supCity":""},{"childList":[],"cityId":"32","cityLev":"","cityName":"江苏省","supCity":""},{"childList":[],"cityId":"33","cityLev":"","cityName":"浙江省","supCity":""},{"childList":[],"cityId":"34","cityLev":"","cityName":"安徽省","supCity":""},{"childList":[],"cityId":"35","cityLev":"","cityName":"福建省","supCity":""},{"childList":[],"cityId":"36","cityLev":"","cityName":"江西省","supCity":""},{"childList":[],"cityId":"37","cityLev":"","cityName":"山东省","supCity":""},{"childList":[],"cityId":"41","cityLev":"","cityName":"河南省","supCity":""},{"childList":[],"cityId":"42","cityLev":"","cityName":"湖北省","supCity":""},{"childList":[],"cityId":"43","cityLev":"","cityName":"湖南省","supCity":""},{"childList":[],"cityId":"44","cityLev":"","cityName":"广东省","supCity":""},{"childList":[],"cityId":"45","cityLev":"","cityName":"广西壮族自治区","supCity":""},{"childList":[],"cityId":"46","cityLev":"","cityName":"海南省","supCity":""},{"childList":[],"cityId":"50","cityLev":"","cityName":"重庆市","supCity":""},{"childList":[],"cityId":"51","cityLev":"","cityName":"四川省","supCity":""},{"childList":[],"cityId":"52","cityLev":"","cityName":"贵州省","supCity":""},{"childList":[],"cityId":"53","cityLev":"","cityName":"云南省","supCity":""},{"childList":[],"cityId":"54","cityLev":"","cityName":"西藏自治区","supCity":""},{"childList":[],"cityId":"61","cityLev":"","cityName":"陕西省","supCity":""},{"childList":[],"cityId":"62","cityLev":"","cityName":"甘肃省","supCity":""},{"childList":[],"cityId":"63","cityLev":"","cityName":"青海省","supCity":""},{"childList":[],"cityId":"64","cityLev":"","cityName":"宁夏回族自治区","supCity":""},{"childList":[],"cityId":"65","cityLev":"","cityName":"新疆维吾尔自治区","supCity":""}]
     */

    private int ret;
    private String msg;
    private int totalnum;
    /**
     * childList : []
     * cityId : 11
     * cityLev :
     * cityName : 北京市
     * supCity :
     */

    private List<AddrBean> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public List<AddrBean> getData() {
        return data;
    }

    public void setData(List<AddrBean> data) {
        this.data = data;
    }

}
