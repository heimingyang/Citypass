package com.example.citypass.model.bean.naonao;

import java.util.List;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/5 0005 15:21
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


public class Carmer_FaBu_AiTe_NaoNao_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"FriendID":704874,"UserName":"sid111337783757219","RoleName":"阿东","RoleImg":"http://r9.pccoo.cn/app_avatar/20170619/2017061911134798705506_818_818_150x150(s).jpg","UserID":30940828,"Sex":"男","Age":22,"OWERSIGN":"轻叹花开花落的流年","IsFriend":0},{"FriendID":704844,"UserName":"QQID1D220815925","RoleName":"","RoleImg":"","UserID":null,"Sex":"男","Age":0,"OWERSIGN":"该用户很懒，未设置签名~","IsFriend":0}]
     * Extend : null
     * Count : 2
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0498047
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
         * FriendID : 704874
         * UserName : sid111337783757219
         * RoleName : 阿东
         * RoleImg : http://r9.pccoo.cn/app_avatar/20170619/2017061911134798705506_818_818_150x150(s).jpg
         * UserID : 30940828
         * Sex : 男
         * Age : 22
         * OWERSIGN : 轻叹花开花落的流年
         * IsFriend : 0
         */

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
