package com.qinhaihang.cityselectordemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 2016/7/9 11:44
 * @des ${TODO}
 * @packgename com.qinhaihang.cityselectordemo.bean
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class AddrBean implements Serializable{
    private String cityId;
    private String cityLev;
    private String cityName;
    private String supCity;
    private List<?> childList;
    private String isSelector; //"1":选中，"0":未选中

    public String getIsSelector() {
        return isSelector;
    }

    public void setIsSelector(String isSelector) {
        this.isSelector = isSelector;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityLev() {
        return cityLev;
    }

    public void setCityLev(String cityLev) {
        this.cityLev = cityLev;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSupCity() {
        return supCity;
    }

    public void setSupCity(String supCity) {
        this.supCity = supCity;
    }

    public List<?> getChildList() {
        return childList;
    }

    public void setChildList(List<?> childList) {
        this.childList = childList;
    }
}
