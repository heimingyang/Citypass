package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/2 20:31
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


public class Attbean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Address":"北京","ReplyNum":41,"DingNum":17,"Level":6,"UserFace":"http://r9.pccoo.cn/app_avatar/20170626/2017062611423608599903_458_458_300x225(s).jpg","NickName":"12300","UserMedal":"http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png,http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png,http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png","UserId":"31090706"}]
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.3134886
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
         * Address : 北京
         * ReplyNum : 41
         * DingNum : 17
         * Level : 6
         * UserFace : http://r9.pccoo.cn/app_avatar/20170626/2017062611423608599903_458_458_300x225(s).jpg
         * NickName : 12300
         * UserMedal : http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png,http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png,http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png
         * UserId : 31090706
         */

        private String Address;
        private int ReplyNum;
        private int DingNum;
        private int Level;
        private String UserFace;
        private String NickName;
        private String UserMedal;
        private String UserId;

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public int getReplyNum() {
            return ReplyNum;
        }

        public void setReplyNum(int ReplyNum) {
            this.ReplyNum = ReplyNum;
        }

        public int getDingNum() {
            return DingNum;
        }

        public void setDingNum(int DingNum) {
            this.DingNum = DingNum;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
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

        public String getUserMedal() {
            return UserMedal;
        }

        public void setUserMedal(String UserMedal) {
            this.UserMedal = UserMedal;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }
    }
}
