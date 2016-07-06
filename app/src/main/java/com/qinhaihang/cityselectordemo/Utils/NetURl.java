package com.qinhaihang.cityselectordemo.Utils;

/**
 * Created by qinhh on 16/6/30.
 */
public class NetURl {
    //private static final String host = "http://123.57.18.37:8080/";
    private static final String host = "http://60.205.57.113:8080/";         //linux测试
    public static final String webService = host + "Bluesky365WebService/";

    public static final String loginURL = webService + "login.do";
    public static final String checkUserExists = webService + "checkUserExists.do";
    public static final String getCityDataURL = webService + "getCityData.do";

}
