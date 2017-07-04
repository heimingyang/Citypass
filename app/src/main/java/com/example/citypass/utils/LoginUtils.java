package com.example.citypass.utils;

import android.os.Build;

import com.alibaba.fastjson.JSON;
import com.example.citypass.model.bean.BaseParam;
import com.example.citypass.model.bean.BaseParamBean;
import com.example.citypass.model.bean.information.Information;
import com.example.citypass.model.bean.information.UpLoad;

/**
 * 项目名称: 血压卫士
 * 类描述: 一些登录后得到的参数的数据存放
 * 创建人: 马杰
 * 创建时间: 2017/6/21 15:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LoginUtils {
    public static Information information;
    public static String LOGIN="login";//boolean
    public static String NAME="name";
    public static String USERID="userID";
    public static String USERNAME="userName";
    public static String USITEID="uSiteID";
    public static String OUSITEID="ouSiteID";
    public static String MYIMG="myImg";
    public static String PHONE="phone";
    //可选照片的最大数量
    public static final String PICTURE_NUM = "picture_num";
    //是否可以跳转到照片调整页面
    public static final String PICtURE_FLAG = "picture_flag";

    public static String upload(int keyID,String value){
        UpLoad load=new UpLoad();
        load.setCustomerID(8001);
        load.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        load.setMethod("PHSocket_SetUserBaseInfo");
        load.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        load.setAppName("CcooCity");
        load.setVersion("4.5");
        UpLoad.ParamBean paramBean=new UpLoad.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setUserName(information.getServerInfo().getUserName());
        paramBean.setUserID(SpUtils.getSp().getString(USERID,""));
        paramBean.setUsiteID(information.getServerInfo().getSiteID());
        paramBean.setKeyID(keyID);
        paramBean.setValue(value);
        load.setParam(paramBean);
        UpLoad.StatisBean statisBean=new UpLoad.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID,"")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        load.setStatis(statisBean);
        String s = JSON.toJSONString(load);
        return s;
    }

    public static String getParam(BaseParamBean bean,String type){
        BaseParam param=new BaseParam();
        param.setCustomerID(8001);
        param.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        param.setMethod(type);
        param.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        param.setAppName("CcooCity");
        param.setVersion("4.5");
        param.setParam(bean);
        BaseParam.StatisBean statisBean=new BaseParam.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID,"")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        param.setStatisBean(statisBean);
        String s = JSON.toJSONString(param);
        return s;
    }


}
