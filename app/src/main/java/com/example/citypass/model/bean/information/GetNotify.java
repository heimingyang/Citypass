package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/30 15:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GetNotify {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"Top7":[{"UserID":31042672,"SiteID":2422,"Recommend":0,"Time1":"","Title1":"暂无最新内容~","System":0,"Time2":"","Title2":"恭喜您成功完成\u201c完善联系信息\u201d任务，额外获得50成长值~","Friend":0,"Time3":"","Title3":"暂无最新好友动态~","Reply":0,"Time4":"","Title4":"","AT":0,"Time5":"","Title5":"","Praise":0,"Time6":"","Title6":"","Visitor":0,"Time7":"","Title7":"最近暂无访客~"}],"FriendTalk":[]}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0351563
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
         * UserID : 31042672
         * SiteID : 2422
         * Recommend : 0
         * Time1 :
         * Title1 : 暂无最新内容~
         * System : 0
         * Time2 :
         * Title2 : 恭喜您成功完成“完善联系信息”任务，额外获得50成长值~
         * Friend : 0
         * Time3 :
         * Title3 : 暂无最新好友动态~
         * Reply : 0
         * Time4 :
         * Title4 :
         * AT : 0
         * Time5 :
         * Title5 :
         * Praise : 0
         * Time6 :
         * Title6 :
         * Visitor : 0
         * Time7 :
         * Title7 : 最近暂无访客~
         */

        private List<Top7Bean> Top7;
        private List<?> FriendTalk;


        public List<Top7Bean> getTop7() {
            return Top7;
        }

        public void setTop7(List<Top7Bean> Top7) {
            this.Top7 = Top7;
        }

        public List<?> getFriendTalk() {
            return FriendTalk;
        }

        public void setFriendTalk(List<?> FriendTalk) {
            this.FriendTalk = FriendTalk;
        }

        public static class Top7Bean {
            private int UserID;
            private int SiteID;
            private int Recommend;
            private String Time1;
            private String Title1;
            private int System;
            private String Time2;
            private String Title2;
            private int Friend;
            private String Time3;
            private String Title3;
            private int Reply;
            private String Time4;
            private String Title4;
            private int AT;
            private String Time5;
            private String Title5;
            private int Praise;
            private String Time6;
            private String Title6;
            private int Visitor;
            private String Time7;
            private String Title7;


            public int getUserID() {
                return UserID;
            }

            public void setUserID(int UserID) {
                this.UserID = UserID;
            }

            public int getSiteID() {
                return SiteID;
            }

            public void setSiteID(int SiteID) {
                this.SiteID = SiteID;
            }

            public int getRecommend() {
                return Recommend;
            }

            public void setRecommend(int Recommend) {
                this.Recommend = Recommend;
            }

            public String getTime1() {
                return Time1;
            }

            public void setTime1(String Time1) {
                this.Time1 = Time1;
            }

            public String getTitle1() {
                return Title1;
            }

            public void setTitle1(String Title1) {
                this.Title1 = Title1;
            }

            public int getSystem() {
                return System;
            }

            public void setSystem(int System) {
                this.System = System;
            }

            public String getTime2() {
                return Time2;
            }

            public void setTime2(String Time2) {
                this.Time2 = Time2;
            }

            public String getTitle2() {
                return Title2;
            }

            public void setTitle2(String Title2) {
                this.Title2 = Title2;
            }

            public int getFriend() {
                return Friend;
            }

            public void setFriend(int Friend) {
                this.Friend = Friend;
            }

            public String getTime3() {
                return Time3;
            }

            public void setTime3(String Time3) {
                this.Time3 = Time3;
            }

            public String getTitle3() {
                return Title3;
            }

            public void setTitle3(String Title3) {
                this.Title3 = Title3;
            }

            public int getReply() {
                return Reply;
            }

            public void setReply(int Reply) {
                this.Reply = Reply;
            }

            public String getTime4() {
                return Time4;
            }

            public void setTime4(String Time4) {
                this.Time4 = Time4;
            }

            public String getTitle4() {
                return Title4;
            }

            public void setTitle4(String Title4) {
                this.Title4 = Title4;
            }

            public int getAT() {
                return AT;
            }

            public void setAT(int AT) {
                this.AT = AT;
            }

            public String getTime5() {
                return Time5;
            }

            public void setTime5(String Time5) {
                this.Time5 = Time5;
            }

            public String getTitle5() {
                return Title5;
            }

            public void setTitle5(String Title5) {
                this.Title5 = Title5;
            }

            public int getPraise() {
                return Praise;
            }

            public void setPraise(int Praise) {
                this.Praise = Praise;
            }

            public String getTime6() {
                return Time6;
            }

            public void setTime6(String Time6) {
                this.Time6 = Time6;
            }

            public String getTitle6() {
                return Title6;
            }

            public void setTitle6(String Title6) {
                this.Title6 = Title6;
            }

            public int getVisitor() {
                return Visitor;
            }

            public void setVisitor(int Visitor) {
                this.Visitor = Visitor;
            }

            public String getTime7() {
                return Time7;
            }

            public void setTime7(String Time7) {
                this.Time7 = Time7;
            }

            public String getTitle7() {
                return Title7;
            }

            public void setTitle7(String Title7) {
                this.Title7 = Title7;
            }
        }
    }
}
