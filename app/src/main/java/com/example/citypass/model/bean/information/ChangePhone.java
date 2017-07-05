package com.example.citypass.model.bean.information;

import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/5 8:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ChangePhone extends BaseParamBean{
    private String userName;
    private int siteID;
    private int usiteID;
    private String phone;
    private String authKey;
    private int userID;

    public String getUsetName() {
        return userName;
    }

    public void setUsetName(String usetName) {
        this.userName = usetName;
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public int getUsiteID() {
        return usiteID;
    }

    public void setUsiteID(int usiteID) {
        this.usiteID = usiteID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
