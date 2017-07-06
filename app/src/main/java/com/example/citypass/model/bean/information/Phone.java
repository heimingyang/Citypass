package com.example.citypass.model.bean.information;

import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/6 19:14
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Phone extends BaseParamBean{
    private int siteID;
    private String userName;
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
