package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/7 10:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class UpGuanZhu {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"FriendID":705002,"UserName":"WXID11960408","RoleName":"浮生若梦为欢几何","RoleImg":"http://r9.pccoo.cn/app_cover/20170606/2017060614263978918052_748_750_150x150(s).jpg","UserID":11960408,"Sex":"女","Age":27,"OWERSIGN":"只与英雄争高下 不与傻瓜话短长","IsFriend":0}]
     * Extend : null
     * Count : 1
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0810547
     */

    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
    /**
     * FriendID : 705002
     * UserName : WXID11960408
     * RoleName : 浮生若梦为欢几何
     * RoleImg : http://r9.pccoo.cn/app_cover/20170606/2017060614263978918052_748_750_150x150(s).jpg
     * UserID : 11960408
     * Sex : 女
     * Age : 27
     * OWERSIGN : 只与英雄争高下 不与傻瓜话短长
     * IsFriend : 0
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
        private int FriendID;
        private String UserName;
        private String RoleName;
        private String RoleImg;
        private int UserID;
        private String Sex;
        private int Age;
        private String OWERSIGN;
        private int IsFriend;


        public int getFriendID() {
            return FriendID;
        }

        public void setFriendID(int FriendID) {
            this.FriendID = FriendID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
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

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public String getOWERSIGN() {
            return OWERSIGN;
        }

        public void setOWERSIGN(String OWERSIGN) {
            this.OWERSIGN = OWERSIGN;
        }

        public int getIsFriend() {
            return IsFriend;
        }

        public void setIsFriend(int IsFriend) {
            this.IsFriend = IsFriend;
        }
    }
}
