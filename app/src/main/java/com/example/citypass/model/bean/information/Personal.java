package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/26 9:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Personal {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * UserName : sid193108730110051
     * UserNick : 蠢均QAQ
     * UserFace : http://r9.pccoo.cn/app_avatar/20170624/2017062411341012485561_390_390_150x150(s).jpg
     * Gender : 男
     * Age : 19
     * Address : 北京吉利大学
     * Level : 1
     * HonorName : 新居民
     * UserImpressionName :
     * MedalNum : 0
     * GiftNum : 0
     * FollowNum : 0
     * FansNum : 0
     * IsFigure :
     * Issue :
     * IsFollow : 0
     * ShareMessage : {"Title":"蠢均QAQ的\"手机延庆在线\"个人空间","Url":"/home/?id=31042672","Image":"http://p9.pccoo.cn/app_avatar/20170624/2017062411341012485561_390_390.jpg"}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"UserName":"sid193108730110051","UserNick":"蠢均QAQ","UserFace":"http://r9.pccoo.cn/app_avatar/20170624/2017062411341012485561_390_390_150x150(s).jpg","Gender":"男","Age":"19","Address":"北京吉利大学","Level":"1","HonorName":"新居民","UserImpressionName":"","MedalNum":"0","GiftNum":"0","FollowNum":"0","FansNum":"0","IsFigure":"","Issue":"","IsFollow":"0","ShareMessage":{"Title":"蠢均QAQ的\"手机延庆在线\"个人空间","Url":"/home/?id=31042672","Image":"http://p9.pccoo.cn/app_avatar/20170624/2017062411341012485561_390_390.jpg"}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0380874
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
        private String UserName;
        private String UserNick;
        private String UserFace;
        private String Gender;
        private String Age;
        private String Address;
        private String Level;
        private String HonorName;
        private String UserImpressionName;
        private String MedalNum;
        private String GiftNum;
        private String FollowNum;
        private String FansNum;
        private String IsFigure;
        private String Issue;
        private String IsFollow;
        /**
         * Title : 蠢均QAQ的"手机延庆在线"个人空间
         * Url : /home/?id=31042672
         * Image : http://p9.pccoo.cn/app_avatar/20170624/2017062411341012485561_390_390.jpg
         */

        private ShareMessageBean ShareMessage;


        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserNick() {
            return UserNick;
        }

        public void setUserNick(String UserNick) {
            this.UserNick = UserNick;
        }

        public String getUserFace() {
            return UserFace;
        }

        public void setUserFace(String UserFace) {
            this.UserFace = UserFace;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getLevel() {
            return Level;
        }

        public void setLevel(String Level) {
            this.Level = Level;
        }

        public String getHonorName() {
            return HonorName;
        }

        public void setHonorName(String HonorName) {
            this.HonorName = HonorName;
        }

        public String getUserImpressionName() {
            return UserImpressionName;
        }

        public void setUserImpressionName(String UserImpressionName) {
            this.UserImpressionName = UserImpressionName;
        }

        public String getMedalNum() {
            return MedalNum;
        }

        public void setMedalNum(String MedalNum) {
            this.MedalNum = MedalNum;
        }

        public String getGiftNum() {
            return GiftNum;
        }

        public void setGiftNum(String GiftNum) {
            this.GiftNum = GiftNum;
        }

        public String getFollowNum() {
            return FollowNum;
        }

        public void setFollowNum(String FollowNum) {
            this.FollowNum = FollowNum;
        }

        public String getFansNum() {
            return FansNum;
        }

        public void setFansNum(String FansNum) {
            this.FansNum = FansNum;
        }

        public String getIsFigure() {
            return IsFigure;
        }

        public void setIsFigure(String IsFigure) {
            this.IsFigure = IsFigure;
        }

        public String getIssue() {
            return Issue;
        }

        public void setIssue(String Issue) {
            this.Issue = Issue;
        }

        public String getIsFollow() {
            return IsFollow;
        }

        public void setIsFollow(String IsFollow) {
            this.IsFollow = IsFollow;
        }

        public ShareMessageBean getShareMessage() {
            return ShareMessage;
        }

        public void setShareMessage(ShareMessageBean ShareMessage) {
            this.ShareMessage = ShareMessage;
        }

        public static class ShareMessageBean {
            private String Title;
            private String Url;
            private String Image;


            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public String getImage() {
                return Image;
            }

            public void setImage(String Image) {
                this.Image = Image;
            }
        }
    }
}
