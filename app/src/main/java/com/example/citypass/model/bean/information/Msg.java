package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/1 9:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Msg {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":5360435,"Type":2,"FirstType":6,"SecondType":3,"TheriID":0,"PartID":0,"Url":"","Title":"恭喜您成功完成\u201c回复并分享\u201d任务，额外获得100成长值~","Massage":"蠢均QAQ您好！恭喜您成功完成\u201c回复并分享\u201d任务，额外获得100成长值~，快到任务中心看看还有什么任务领取的吧~","Massage1":"","Image":"","erpUserID":0,"FromUserID":0,"FromRoleName":"","FromRoleImg":"","Hot":0,"state":0,"CreateTime":"2017-7-1 9:39:28"}]
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1044922
     */

    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
    /**
     * Id : 5360435
     * Type : 2
     * FirstType : 6
     * SecondType : 3
     * TheriID : 0
     * PartID : 0
     * Url :
     * Title : 恭喜您成功完成“回复并分享”任务，额外获得100成长值~
     * Massage : 蠢均QAQ您好！恭喜您成功完成“回复并分享”任务，额外获得100成长值~，快到任务中心看看还有什么任务领取的吧~
     * Massage1 :
     * Image :
     * erpUserID : 0
     * FromUserID : 0
     * FromRoleName :
     * FromRoleImg :
     * Hot : 0
     * state : 0
     * CreateTime : 2017-7-1 9:39:28
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
        private int Type;
        private int FirstType;
        private int SecondType;
        private int TheriID;
        private int PartID;
        private String Url;
        private String Title;
        private String Massage;
        private String Massage1;
        private String Image;
        private int erpUserID;
        private int FromUserID;
        private String FromRoleName;
        private String FromRoleImg;
        private int Hot;
        private int state;
        private String CreateTime;


        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
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

        public int getTheriID() {
            return TheriID;
        }

        public void setTheriID(int TheriID) {
            this.TheriID = TheriID;
        }

        public int getPartID() {
            return PartID;
        }

        public void setPartID(int PartID) {
            this.PartID = PartID;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getMassage() {
            return Massage;
        }

        public void setMassage(String Massage) {
            this.Massage = Massage;
        }

        public String getMassage1() {
            return Massage1;
        }

        public void setMassage1(String Massage1) {
            this.Massage1 = Massage1;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getErpUserID() {
            return erpUserID;
        }

        public void setErpUserID(int erpUserID) {
            this.erpUserID = erpUserID;
        }

        public int getFromUserID() {
            return FromUserID;
        }

        public void setFromUserID(int FromUserID) {
            this.FromUserID = FromUserID;
        }

        public String getFromRoleName() {
            return FromRoleName;
        }

        public void setFromRoleName(String FromRoleName) {
            this.FromRoleName = FromRoleName;
        }

        public String getFromRoleImg() {
            return FromRoleImg;
        }

        public void setFromRoleImg(String FromRoleImg) {
            this.FromRoleImg = FromRoleImg;
        }

        public int getHot() {
            return Hot;
        }

        public void setHot(int Hot) {
            this.Hot = Hot;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }
}

