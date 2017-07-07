package com.example.citypass.model.bean.information;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/7 10:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GuanZhu extends BaseParamBean {
    @JSONField(name = "siteID")
    private int siteID;
    @JSONField(name = "userName")
    private String userName;
    @JSONField(name="curPage")
    private int curPage;
    @JSONField(name = "pageSize")
    private int pageSize;


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

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
