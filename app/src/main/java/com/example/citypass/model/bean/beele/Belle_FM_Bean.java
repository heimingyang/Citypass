package com.example.citypass.model.bean.beele;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/24 0024 17:31
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

public class Belle_FM_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"FigureTCoverInfoList":{"FigureTCoverInfoList":[{"Id":220825,"UserID":11640046,"Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"来自金星","tName":"","nick":"依然","positionName":"职业不明","Issue":1,"ReplyTotal":0,"uXinZuo":"双子座","Age":"30","PicUrls":"","LikeTotal":0}],"Count":1}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0859375
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
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
         * FigureTCoverInfoList : {"FigureTCoverInfoList":[{"Id":220825,"UserID":11640046,"Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"来自金星","tName":"","nick":"依然","positionName":"职业不明","Issue":1,"ReplyTotal":0,"uXinZuo":"双子座","Age":"30","PicUrls":"","LikeTotal":0}],"Count":1}
         */

        private FigureTCoverInfoListBeanX FigureTCoverInfoList;

        public FigureTCoverInfoListBeanX getFigureTCoverInfoList() {
            return FigureTCoverInfoList;
        }

        public void setFigureTCoverInfoList(FigureTCoverInfoListBeanX FigureTCoverInfoList) {
            this.FigureTCoverInfoList = FigureTCoverInfoList;
        }

        public static class FigureTCoverInfoListBeanX {
            /**
             * FigureTCoverInfoList : [{"Id":220825,"UserID":11640046,"Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"来自金星","tName":"","nick":"依然","positionName":"职业不明","Issue":1,"ReplyTotal":0,"uXinZuo":"双子座","Age":"30","PicUrls":"","LikeTotal":0}]
             * Count : 1
             */

            private int Count;
            private List<FigureTCoverInfoListBean> FigureTCoverInfoList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<FigureTCoverInfoListBean> getFigureTCoverInfoList() {
                return FigureTCoverInfoList;
            }

            public void setFigureTCoverInfoList(List<FigureTCoverInfoListBean> FigureTCoverInfoList) {
                this.FigureTCoverInfoList = FigureTCoverInfoList;
            }

            public static class FigureTCoverInfoListBean {
                /**
                 * Id : 220825
                 * UserID : 11640046
                 * Photo : http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg
                 * MapName : 来自金星
                 * tName :
                 * nick : 依然
                 * positionName : 职业不明
                 * Issue : 1
                 * ReplyTotal : 0
                 * uXinZuo : 双子座
                 * Age : 30
                 * PicUrls :
                 * LikeTotal : 0
                 */

                private int Id;
                private int UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;
                private int Issue;
                private int ReplyTotal;
                private String uXinZuo;
                private String Age;
                private String PicUrls;
                private int LikeTotal;

                public int getId() {
                    return Id;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public int getUserID() {
                    return UserID;
                }

                public void setUserID(int UserID) {
                    this.UserID = UserID;
                }

                public String getPhoto() {
                    return Photo;
                }

                public void setPhoto(String Photo) {
                    this.Photo = Photo;
                }

                public String getMapName() {
                    return MapName;
                }

                public void setMapName(String MapName) {
                    this.MapName = MapName;
                }

                public String getTName() {
                    return tName;
                }

                public void setTName(String tName) {
                    this.tName = tName;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public int getIssue() {
                    return Issue;
                }

                public void setIssue(int Issue) {
                    this.Issue = Issue;
                }

                public int getReplyTotal() {
                    return ReplyTotal;
                }

                public void setReplyTotal(int ReplyTotal) {
                    this.ReplyTotal = ReplyTotal;
                }

                public String getUXinZuo() {
                    return uXinZuo;
                }

                public void setUXinZuo(String uXinZuo) {
                    this.uXinZuo = uXinZuo;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
                }

                public String getPicUrls() {
                    return PicUrls;
                }

                public void setPicUrls(String PicUrls) {
                    this.PicUrls = PicUrls;
                }

                public int getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(int LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }
            }
        }
    }
}
