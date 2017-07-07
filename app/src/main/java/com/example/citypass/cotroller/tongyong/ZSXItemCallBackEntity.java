package com.example.citypass.cotroller.tongyong;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24 0024.
 */

public class ZSXItemCallBackEntity {


    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ReplyID":55965,"Rtitle":"沙发","UserName":"WXIDnTJdGELQ9666","UserID":28957291,"RoleName":"aeon  赵","RoleImg":"http://wx.qlogo.cn/mmopen/RDiaL6j1Wgd5VuTiaicqGFMbb6AVOwcVic09atPicdKvJNyTTACnFGsImsucRdInEicgIbIsNJF68sKNAoJGQfnw65A16uqKjXpAn6/0","Level":1,"AddTime":"2017-6-24 8:39:00","MapName":"延庆县,","MapPoint":"","IsDaKa":0,"MedalInfo":["","",""],"ReplyMemo":"确实，行政不作为！","Expression":"","Images":[],"Clild":null,"ClildReplyList":null}]
     * Extend : null
     * Count : 1
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0546875
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
         * ReplyID : 55965
         * Rtitle : 沙发
         * UserName : WXIDnTJdGELQ9666
         * UserID : 28957291
         * RoleName : aeon  赵
         * RoleImg : http://wx.qlogo.cn/mmopen/RDiaL6j1Wgd5VuTiaicqGFMbb6AVOwcVic09atPicdKvJNyTTACnFGsImsucRdInEicgIbIsNJF68sKNAoJGQfnw65A16uqKjXpAn6/0
         * Level : 1
         * AddTime : 2017-6-24 8:39:00
         * MapName : 延庆县,
         * MapPoint :
         * IsDaKa : 0
         * MedalInfo : ["","",""]
         * ReplyMemo : 确实，行政不作为！
         * Expression :
         * Images : []
         * Clild : null
         * ClildReplyList : null
         */

        private int ReplyID;
        private String Rtitle;
        private String UserName;
        private int UserID;
        private String RoleName;
        private String RoleImg;
        private int Level;
        private String AddTime;
        private String MapName;
        private String MapPoint;
        private int IsDaKa;
        private String ReplyMemo;
        private String Expression;
        private Object Clild;
        private Object ClildReplyList;
        private List<String> MedalInfo;
        private List<?> Images;

        public int getReplyID() {
            return ReplyID;
        }

        public void setReplyID(int ReplyID) {
            this.ReplyID = ReplyID;
        }

        public String getRtitle() {
            return Rtitle;
        }

        public void setRtitle(String Rtitle) {
            this.Rtitle = Rtitle;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getRoleName() {
            return RoleName;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public String getRoleImg() {
            return RoleImg;
        }

        public void setRoleImg(String RoleImg) {
            this.RoleImg = RoleImg;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }

        public String getMapName() {
            return MapName;
        }

        public void setMapName(String MapName) {
            this.MapName = MapName;
        }

        public String getMapPoint() {
            return MapPoint;
        }

        public void setMapPoint(String MapPoint) {
            this.MapPoint = MapPoint;
        }

        public int getIsDaKa() {
            return IsDaKa;
        }

        public void setIsDaKa(int IsDaKa) {
            this.IsDaKa = IsDaKa;
        }

        public String getReplyMemo() {
            return ReplyMemo;
        }

        public void setReplyMemo(String ReplyMemo) {
            this.ReplyMemo = ReplyMemo;
        }

        public String getExpression() {
            return Expression;
        }

        public void setExpression(String Expression) {
            this.Expression = Expression;
        }

        public Object getClild() {
            return Clild;
        }

        public void setClild(Object Clild) {
            this.Clild = Clild;
        }

        public Object getClildReplyList() {
            return ClildReplyList;
        }

        public void setClildReplyList(Object ClildReplyList) {
            this.ClildReplyList = ClildReplyList;
        }

        public List<String> getMedalInfo() {
            return MedalInfo;
        }

        public void setMedalInfo(List<String> MedalInfo) {
            this.MedalInfo = MedalInfo;
        }

        public List<?> getImages() {
            return Images;
        }

        public void setImages(List<?> Images) {
            this.Images = Images;
        }
    }
}
