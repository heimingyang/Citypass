package com.example.citypass.model.bean.information;

import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/1 16:29
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class NotifyOne extends BaseParamBean{
    private int siteid;
    private String username;
    private int pagesize;
    private int pageindex;

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }
}
