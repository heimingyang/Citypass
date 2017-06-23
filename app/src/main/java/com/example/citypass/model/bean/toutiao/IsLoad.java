package com.example.citypass.model.bean.toutiao;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述: 是否上传成功打的实体类
 * 创建人: 马杰
 * 创建时间: 2017/6/23 15:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IsLoad {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : null
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.131836
     */

    private Object ServerInfo;
    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;


    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
    }

    public Object getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(Object ServerInfo) {
        this.ServerInfo = ServerInfo;
    }

    public Object getExtend() {
        return Extend;
    }

    public void setExtend(Object Extend) {
        this.Extend = Extend;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getGxNum() {
        return GxNum;
    }

    public void setGxNum(int GxNum) {
        this.GxNum = GxNum;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int PageNum) {
        this.PageNum = PageNum;
    }

    public double getRetime() {
        return retime;
    }

    public void setRetime(double retime) {
        this.retime = retime;
    }

    public static class MessageListBean {
        private int code;
        private String message;


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
