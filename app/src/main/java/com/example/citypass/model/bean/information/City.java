package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 14:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class City {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * CoinLogInfo : null
     * UserExtend : [{"Integral":250,"Coin":0}]
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoinLogInfo":null,"UserExtend":[{"Integral":250,"Coin":0}]}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0185547
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
        private Object CoinLogInfo;
        /**
         * Integral : 250
         * Coin : 0
         */

        private List<UserExtendBean> UserExtend;


        public Object getCoinLogInfo() {
            return CoinLogInfo;
        }

        public void setCoinLogInfo(Object CoinLogInfo) {
            this.CoinLogInfo = CoinLogInfo;
        }

        public List<UserExtendBean> getUserExtend() {
            return UserExtend;
        }

        public void setUserExtend(List<UserExtendBean> UserExtend) {
            this.UserExtend = UserExtend;
        }

        public static class UserExtendBean {
            private int Integral;
            private int Coin;


            public int getIntegral() {
                return Integral;
            }

            public void setIntegral(int Integral) {
                this.Integral = Integral;
            }

            public int getCoin() {
                return Coin;
            }

            public void setCoin(int Coin) {
                this.Coin = Coin;
            }
        }
    }
}
