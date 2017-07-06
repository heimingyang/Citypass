package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/4 15:06
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class Newbean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ReplyID":399174,"ParentID":0,"UserId":"31718288","UserName":"QQID1D220815925","UserFace":"http://q.qlogo.cn/qqapp/1102147502/1D220815FD7E810CAF7B6E266DD3A5FF/100","NickName":"@ H","Level":"3","UserMedal":"","ReplyTime":"2017-7-4 9:23:10","Address":"北京吉利大学","Ding":"0","ReplyContent":"啊考虑考虑😄","Expression":"","ReplyNum":0,"Lou":"沙发","hasZan":0,"ChildReply":{"Info":[],"Count":0}},{"ReplyID":399175,"ParentID":0,"UserId":"31718288","UserName":"QQID1D220815925","UserFace":"http://q.qlogo.cn/qqapp/1102147502/1D220815FD7E810CAF7B6E266DD3A5FF/100","NickName":"@ H","Level":"3","UserMedal":"","ReplyTime":"2017-7-4 9:23:11","Address":"北京吉利大学","Ding":"0","ReplyContent":"啊考虑考虑😄","Expression":"","ReplyNum":0,"Lou":"板凳","hasZan":0,"ChildReply":{"Info":[],"Count":0}}]
     * Extend : null
     * Count : 2
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1699219
     */

    private MessageListBean MessageList;
    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
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
        /**
         * code : 1000
         * message : Success
         */

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
         * ReplyID : 399174
         * ParentID : 0
         * UserId : 31718288
         * UserName : QQID1D220815925
         * UserFace : http://q.qlogo.cn/qqapp/1102147502/1D220815FD7E810CAF7B6E266DD3A5FF/100
         * NickName : @ H
         * Level : 3
         * UserMedal :
         * ReplyTime : 2017-7-4 9:23:10
         * Address : 北京吉利大学
         * Ding : 0
         * ReplyContent : 啊考虑考虑😄
         * Expression :
         * ReplyNum : 0
         * Lou : 沙发
         * hasZan : 0
         * ChildReply : {"Info":[],"Count":0}
         */

        private int ReplyID;
        private int ParentID;
        private String UserId;
        private String UserName;
        private String UserFace;
        private String NickName;
        private String Level;
        private String UserMedal;
        private String ReplyTime;
        private String Address;
        private String Ding;
        private String ReplyContent;
        private String Expression;
        private int ReplyNum;
        private String Lou;
        private int hasZan;
        private ChildReplyBean ChildReply;

        public int getReplyID() {
            return ReplyID;
        }

        public void setReplyID(int ReplyID) {
            this.ReplyID = ReplyID;
        }

        public int getParentID() {
            return ParentID;
        }

        public void setParentID(int ParentID) {
            this.ParentID = ParentID;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserFace() {
            return UserFace;
        }

        public void setUserFace(String UserFace) {
            this.UserFace = UserFace;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getLevel() {
            return Level;
        }

        public void setLevel(String Level) {
            this.Level = Level;
        }

        public String getUserMedal() {
            return UserMedal;
        }

        public void setUserMedal(String UserMedal) {
            this.UserMedal = UserMedal;
        }

        public String getReplyTime() {
            return ReplyTime;
        }

        public void setReplyTime(String ReplyTime) {
            this.ReplyTime = ReplyTime;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getDing() {
            return Ding;
        }

        public void setDing(String Ding) {
            this.Ding = Ding;
        }

        public String getReplyContent() {
            return ReplyContent;
        }

        public void setReplyContent(String ReplyContent) {
            this.ReplyContent = ReplyContent;
        }

        public String getExpression() {
            return Expression;
        }

        public void setExpression(String Expression) {
            this.Expression = Expression;
        }

        public int getReplyNum() {
            return ReplyNum;
        }

        public void setReplyNum(int ReplyNum) {
            this.ReplyNum = ReplyNum;
        }

        public String getLou() {
            return Lou;
        }

        public void setLou(String Lou) {
            this.Lou = Lou;
        }

        public int getHasZan() {
            return hasZan;
        }

        public void setHasZan(int hasZan) {
            this.hasZan = hasZan;
        }

        public ChildReplyBean getChildReply() {
            return ChildReply;
        }

        public void setChildReply(ChildReplyBean ChildReply) {
            this.ChildReply = ChildReply;
        }

        public static class ChildReplyBean {
            /**
             * Info : []
             * Count : 0
             */

            private int Count;
            private List<?> Info;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<?> getInfo() {
                return Info;
            }

            public void setInfo(List<?> Info) {
                this.Info = Info;
            }
        }
    }
}
