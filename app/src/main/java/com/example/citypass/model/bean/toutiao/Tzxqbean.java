package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/6 16:52
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


public class Tzxqbean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ReplyID":60829,"Rtitle":"沙发","UserName":"WXID15778631","UserID":15778631,"RoleName":"A_佛怒火莲（YEI）","RoleImg":"http://r3.pccoo.cn/weixin/20150928/2015092822410367596582_150x150(s).jpg","Level":1,"AddTime":"2017-7-5 0:18:09","MapName":"来自火星","MapPoint":"","IsDaKa":0,"MedalInfo":["","",""],"ReplyMemo":"牛逼就跟幼儿园理论一下。在这说没啥意义吧","Expression":"","Images":[],"AtUser":"","Clild":null,"ClildReplyList":null}]
     * Extend : null
     * Count : 1
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0488281
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
         * ReplyID : 60829
         * Rtitle : 沙发
         * UserName : WXID15778631
         * UserID : 15778631
         * RoleName : A_佛怒火莲（YEI）
         * RoleImg : http://r3.pccoo.cn/weixin/20150928/2015092822410367596582_150x150(s).jpg
         * Level : 1
         * AddTime : 2017-7-5 0:18:09
         * MapName : 来自火星
         * MapPoint :
         * IsDaKa : 0
         * MedalInfo : ["","",""]
         * ReplyMemo : 牛逼就跟幼儿园理论一下。在这说没啥意义吧
         * Expression :
         * Images : []
         * AtUser :
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
        private String AtUser;
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

        public String getAtUser() {
            return AtUser;
        }

        public void setAtUser(String AtUser) {
            this.AtUser = AtUser;
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
