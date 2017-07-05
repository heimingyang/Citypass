package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/5 16:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DetailTasks {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * Id : 75488
     * Title : 完善基本信息
     * Coin : 20
     * Integral : 100
     * Explain : 完善“街道/乡镇、出生日期、职业、情感状态、签名”等基本信息——便于他人初步了解您。
     每个用户均可领取1次此项任务，完成后将自动获得20城市币，100成长值奖励。
     * TState : 1006
     * Rate : 100
     * RateInfo : 任务已100%保质保量完成~
     * ETime : 2017-06-24 11:34
     * FirstType : 6
     * SecondType : 17
     * TypeUrlName : 完善基本信息
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"Id":75488,"Title":"完善基本信息","Coin":20,"Integral":100,"Explain":"完善\u201c街道/乡镇、出生日期、职业、情感状态、签名\u201d等基本信息\u2014\u2014便于他人初步了解您。\r\n每个用户均可领取1次此项任务，完成后将自动获得20城市币，100成长值奖励。","TState":1006,"Rate":100,"RateInfo":"任务已100%保质保量完成~","ETime":"2017-06-24 11:34","FirstType":6,"SecondType":17,"TypeUrlName":"完善基本信息"}
     * Extend : null
     * Count : 1
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0644531
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
        private int Id;
        private String Title;
        private int Coin;
        private int Integral;
        private String Explain;
        private int TState;
        private int Rate;
        private String RateInfo;
        private String ETime;
        private int FirstType;
        private int SecondType;
        private String TypeUrlName;


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

        public int getCoin() {
            return Coin;
        }

        public void setCoin(int Coin) {
            this.Coin = Coin;
        }

        public int getIntegral() {
            return Integral;
        }

        public void setIntegral(int Integral) {
            this.Integral = Integral;
        }

        public String getExplain() {
            return Explain;
        }

        public void setExplain(String Explain) {
            this.Explain = Explain;
        }

        public int getTState() {
            return TState;
        }

        public void setTState(int TState) {
            this.TState = TState;
        }

        public int getRate() {
            return Rate;
        }

        public void setRate(int Rate) {
            this.Rate = Rate;
        }

        public String getRateInfo() {
            return RateInfo;
        }

        public void setRateInfo(String RateInfo) {
            this.RateInfo = RateInfo;
        }

        public String getETime() {
            return ETime;
        }

        public void setETime(String ETime) {
            this.ETime = ETime;
        }

        public int getFirstType() {
            return FirstType;
        }

        public void setFirstType(int FirstType) {
            this.FirstType = FirstType;
        }

        public int getSecondType() {
            return SecondType;
        }

        public void setSecondType(int SecondType) {
            this.SecondType = SecondType;
        }

        public String getTypeUrlName() {
            return TypeUrlName;
        }

        public void setTypeUrlName(String TypeUrlName) {
            this.TypeUrlName = TypeUrlName;
        }
    }
}
