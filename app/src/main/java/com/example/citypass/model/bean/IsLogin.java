package com.example.citypass.model.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述: 登录成功以后解析的实体类
 * 创建人: 马杰
 * 创建时间: 2017/6/21 15:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IsLogin {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * UserID : 31042672
     * UserName : sid193108730110051
     * RoleName : 蠢均
     * RoleImg : http://p9.pccoo.cn/app_avatar/20170620/2017062019312400988846_390_390.jpg
     * uSiteID : 2422
     * ouSiteID : 2422
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"UserID":31042672,"UserName":"sid193108730110051","RoleName":"蠢均","RoleImg":"http://p9.pccoo.cn/app_avatar/20170620/2017062019312400988846_390_390.jpg","uSiteID":2422,"ouSiteID":2422}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1484375
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
        private int UserID;
        private String UserName;
        private String RoleName;
        private String RoleImg;
        private int uSiteID;
        private int ouSiteID;


        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
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

        public int getUSiteID() {
            return uSiteID;
        }

        public void setUSiteID(int uSiteID) {
            this.uSiteID = uSiteID;
        }

        public int getOuSiteID() {
            return ouSiteID;
        }

        public void setOuSiteID(int ouSiteID) {
            this.ouSiteID = ouSiteID;
        }
    }
}
