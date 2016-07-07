package com.qinhaihang.cityselectordemo.bean;

import java.util.List;

/**
 * Created by qinhh on 16/7/7.
 */
public class CUserBeanS {


    /**
     * ret : 0
     * msg : ok
     * totalnum : 1
     * data : {"addId":"","bankacc":"","bucket":"","cpRelUuid":"","cusServicerId":"","delFlg":"","filePath":"","furnaceType":"","houseSize":"","idpRelUuid":"","openbank":"","purchaseState":"","state":"","telNo":"18172265347","type":"","upId":"","uploadFlg":"","userAddr":"87-8","userAge":"1989-07-15","userAuth":"L1511091601011","userCity":"1101","userCityNM":"北京市辖区","userCounty":"110105","userCountyNM":"朝阳区","userCp":"","userId":"cgy","userIdnum":"210905197807210546 ","userIdp":"","userNm":"熊兴和","userProvince":"11","userProvinceNM":"北京市","userPw":"","userSex":"1","userTown":"110105022","userTownNM":"高碑店地区办事处","userType":"cgy","userUuid":"K1512241439001","userVillage":"","userVillageNm":"","uuid":""}
     */

    private String ret;
    private String msg;
    private String totalnum;

    private List<CUserDataBean> dataList;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public List<CUserDataBean> getData() {
        return dataList;
    }

    public void setData(List<CUserDataBean> dataList) {
        this.dataList = dataList;
    }

}
