package com.qinhaihang.cityselectordemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
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
public class AddrBean implements Parcelable{
    private String cityId;
    private String cityLev;
    private String cityName;
    private String supCity;
    private List<Object> childList;
    private String isSelector; //"1":选中，"0":未选中

    public AddrBean() {

    }

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

    public void setChildList(List<Object> childList) {
        this.childList = childList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityId);
        dest.writeString(this.cityLev);
        dest.writeString(this.cityName);
        dest.writeString(this.supCity);
        dest.writeList(this.childList);
        dest.writeString(this.isSelector);
    }

    protected AddrBean(Parcel in) {
        this.cityId = in.readString();
        this.cityLev = in.readString();
        this.cityName = in.readString();
        this.supCity = in.readString();
        this.childList = new ArrayList<Object>();
        in.readList(this.childList, Object.class.getClassLoader());
        this.isSelector = in.readString();
    }

    public static final Creator<AddrBean> CREATOR = new Creator<AddrBean>() {
        @Override
        public AddrBean createFromParcel(Parcel source) {
            return new AddrBean(source);
        }

        @Override
        public AddrBean[] newArray(int size) {
            return new AddrBean[size];
        }
    };
}
