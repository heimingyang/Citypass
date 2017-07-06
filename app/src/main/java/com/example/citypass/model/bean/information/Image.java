package com.example.citypass.model.bean.information;

import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/6 17:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Image extends BaseParamBean{
    private String userID;
    private int siteID;
    private String userName;
    private int usiteID;
    private int keyID;
    private String value;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUsiteID() {
        return usiteID;
    }

    public void setUsiteID(int usiteID) {
        this.usiteID = usiteID;
    }

    public int getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
