package com.example.citypass.model.bean.information;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.citypass.model.bean.BaseParamBean;

import static android.R.attr.id;
import static android.os.Build.ID;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/4 14:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShopDetail extends BaseParamBean {
    private int siteID;
    @JSONField(name = "Id")
    private int id;

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }
}
