package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 19:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforTwo {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * UserId : 31042672
     * Birthday : 1998-08-29
     * XingZuo : 处女座
     * Job : 程序员
     * SignInfo : 嗯，你好
     * Marry : 单身
     * WeiXin : 18501151714
     * QQ : 1208174051
     * Address : 北京吉利大学
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"UserId":31042672,"Birthday":"1998-08-29","XingZuo":"处女座","Job":"程序员","SignInfo":"嗯，你好","Marry":"单身","WeiXin":"18501151714","QQ":"1208174051","Address":"北京吉利大学"}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0048828
     */

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

    public ServerInfoBean getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(ServerInfoBean ServerInfo) {
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

    public static class ServerInfoBean {
        private int UserId;
        private String Birthday;
        private String XingZuo;
        private String Job;
        private String SignInfo;
        private String Marry;
        private String WeiXin;
        private String QQ;
        private String Address;

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String Birthday) {
            this.Birthday = Birthday;
        }

        public String getXingZuo() {
            return XingZuo;
        }

        public void setXingZuo(String XingZuo) {
            this.XingZuo = XingZuo;
        }

        public String getJob() {
            return Job;
        }

        public void setJob(String Job) {
            this.Job = Job;
        }

        public String getSignInfo() {
            return SignInfo;
        }

        public void setSignInfo(String SignInfo) {
            this.SignInfo = SignInfo;
        }

        public String getMarry() {
            return Marry;
        }

        public void setMarry(String Marry) {
            this.Marry = Marry;
        }

        public String getWeiXin() {
            return WeiXin;
        }

        public void setWeiXin(String WeiXin) {
            this.WeiXin = WeiXin;
        }

        public String getQQ() {
            return QQ;
        }

        public void setQQ(String QQ) {
            this.QQ = QQ;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }
    }
}
