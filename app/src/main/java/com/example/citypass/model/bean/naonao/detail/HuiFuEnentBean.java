package com.example.citypass.model.bean.naonao.detail;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/4 17:26
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class HuiFuEnentBean {
    private List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> ReplyList;

    public HuiFuEnentBean(List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> replyList) {
        ReplyList = replyList;
    }

    public List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> getReplyList() {
        return ReplyList;
    }

    public void setReplyList(List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> replyList) {
        ReplyList = replyList;
    }
}


