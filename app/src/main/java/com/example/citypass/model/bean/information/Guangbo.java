package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/29 11:24
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Guangbo {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * RecommendList : {"Content":[],"Count":0}
     * OrderList : {"Content":[{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了帖子置顶卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"}],"Count":5}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"RecommendList":{"Content":[],"Count":0},"OrderList":{"Content":[{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了帖子置顶卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"}],"Count":5}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0458985
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
        /**
         * Content : []
         * Count : 0
         */

        private RecommendListBean RecommendList;
        /**
         * Content : [{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了帖子置顶卡"},{"OrderMessage":"王老师购买了值得一看卡"},{"OrderMessage":"王老师购买了值得一看卡"}]
         * Count : 5
         */

        private OrderListBean OrderList;


        public RecommendListBean getRecommendList() {
            return RecommendList;
        }

        public void setRecommendList(RecommendListBean RecommendList) {
            this.RecommendList = RecommendList;
        }

        public OrderListBean getOrderList() {
            return OrderList;
        }

        public void setOrderList(OrderListBean OrderList) {
            this.OrderList = OrderList;
        }

        public static class RecommendListBean {
            private int Count;
            private List<?> Content;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<?> getContent() {
                return Content;
            }

            public void setContent(List<?> Content) {
                this.Content = Content;
            }
        }

        public static class OrderListBean {
            private int Count;
            /**
             * OrderMessage : 王老师购买了值得一看卡
             */

            private List<ContentBean> Content;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<ContentBean> getContent() {
                return Content;
            }

            public void setContent(List<ContentBean> Content) {
                this.Content = Content;
            }

            public static class ContentBean {
                private String OrderMessage;


                public String getOrderMessage() {
                    return OrderMessage;
                }

                public void setOrderMessage(String OrderMessage) {
                    this.OrderMessage = OrderMessage;
                }
            }
        }
    }
}
