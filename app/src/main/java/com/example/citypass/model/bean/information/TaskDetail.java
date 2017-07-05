package com.example.citypass.model.bean.information;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/5 16:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskDetail extends BaseParamBean{
    private int siteID;
    @JSONField(name = "Id")
    private int Id;
    private int userID;

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
