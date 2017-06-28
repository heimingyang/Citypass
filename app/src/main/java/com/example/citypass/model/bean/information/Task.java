package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 15:51
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Task {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":75489,"Title":"设置头像","Coin":"5","Integral":"50","Explain":"上传您的真实照片或个性头像\u2014\u2014便于他人了解您，记住您。","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709464090273309.png","TState":1006,"message":"6"},{"Id":75488,"Title":"完善基本信息","Coin":"20","Integral":"100","Explain":"完善\u201c街道/乡镇、出生日期、职业、情感状态、签名\u201d等基本信息\u2014\u2014便于他人初步了解您。","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709412462978778.png","TState":1006,"message":"6"},{"Id":75487,"Title":"完善联系信息","Coin":"10","Integral":"50","Explain":"完善\u201cQQ、微信、真实姓名\u201d等联系信息\u2014\u2014便于本站及您的好友联系您。","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151223/2015122318004002220908.png","TState":1006,"message":"6"},{"Id":75486,"Title":"手机认证","Coin":"20","Integral":"100","Explain":"完成手机认证\u2014\u2014登录便捷，不怕被盗。","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709481016477388.png","TState":1000,"message":"6"},{"Id":75485,"Title":"搭讪与结识","Coin":"10","Integral":"50","Explain":"进入想结识的人的主页，\u201c关注\u201d他，并\u201c发私信\u201d求结识","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709505253956756.png","TState":1000,"message":"6"},{"Id":75484,"Title":"狂点赞","Coin":"10","Integral":"30","Explain":"一天内，对照片、文章、贴子及评论回复点赞达30个","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709555490167634.png","TState":1000,"message":"1"},{"Id":75483,"Title":"我爱评论","Coin":"20","Integral":"100","Explain":"7天内，进行50次以上的回复或评论","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112710001071764123.png","TState":1000,"message":"1"},{"Id":75482,"Title":"我爱抢楼","Coin":"20","Integral":"150","Explain":"一天内抢到沙发、板凳、马扎各1个","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112709573539155772.png","TState":1000,"message":"1"},{"Id":75481,"Title":"我爱发贴","Coin":"30","Integral":"200","Explain":"7天内，发出10篇以上的贴子","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151126/2015112615115176787319.png","TState":1000,"message":"1"},{"Id":75480,"Title":"我有观点","Coin":"30","Integral":"150","Explain":"城事一天内抢到沙发、板凳、马扎各1个","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20160229/2016022913400325657897.png","TState":1000,"message":"13"},{"Id":75479,"Title":"我爱分享","Coin":"30","Integral":"200","Explain":"7天内，进行了30次以上的分享","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20151127/2015112710045507605456.png","TState":1000,"message":"1"},{"Id":75478,"Title":"回复并分享","Coin":"20","Integral":"100","Explain":"城事内回复文章，并分享该文章。","STime":"","ETime":"","TImage":"http://p3.pccoo.cn/vote/20160131/2016013117140947303663.png","TState":1000,"message":"13"}]
     * Extend : null
     * Count : 9
     * GxNum : 0
     * PageNum : 0
     * retime : 0.3945464
     */

    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
    /**
     * Id : 75489
     * Title : 设置头像
     * Coin : 5
     * Integral : 50
     * Explain : 上传您的真实照片或个性头像——便于他人了解您，记住您。
     * STime :
     * ETime :
     * TImage : http://p3.pccoo.cn/vote/20151127/2015112709464090273309.png
     * TState : 1006
     * message : 6
     */

    private List<ServerInfoBean> ServerInfo;


    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
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

    public List<ServerInfoBean> getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(List<ServerInfoBean> ServerInfo) {
        this.ServerInfo = ServerInfo;
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
        private int Id;
        private String Title;
        private String Coin;
        private String Integral;
        private String Explain;
        private String STime;
        private String ETime;
        private String TImage;
        private int TState;
        private String message;


        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getCoin() {
            return Coin;
        }

        public void setCoin(String Coin) {
            this.Coin = Coin;
        }

        public String getIntegral() {
            return Integral;
        }

        public void setIntegral(String Integral) {
            this.Integral = Integral;
        }

        public String getExplain() {
            return Explain;
        }

        public void setExplain(String Explain) {
            this.Explain = Explain;
        }

        public String getSTime() {
            return STime;
        }

        public void setSTime(String STime) {
            this.STime = STime;
        }

        public String getETime() {
            return ETime;
        }

        public void setETime(String ETime) {
            this.ETime = ETime;
        }

        public String getTImage() {
            return TImage;
        }

        public void setTImage(String TImage) {
            this.TImage = TImage;
        }

        public int getTState() {
            return TState;
        }

        public void setTState(int TState) {
            this.TState = TState;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
