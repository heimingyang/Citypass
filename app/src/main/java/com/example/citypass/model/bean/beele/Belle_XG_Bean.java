package com.example.citypass.model.bean.beele;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 0026 10:48
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

public class Belle_XG_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoverPhotoDetailsInfo":{"CoverPhotoDetailsInfo":[{"Id":720472,"UserID":23139611,"Photo":"http://r9.pccoo.cn/weixin/20161226/2016122623043751835113_960_1280_500x300(w).jpg","LikeTotal":4,"nick":"??。静。??","positionName":"33岁","MapName":"格兰","CreateTime":"2017-6-24 16:40:09","tName":"性感","isDZ":0},{"Id":190638,"UserID":16879465,"Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","LikeTotal":6,"nick":"七分毒","positionName":"31岁","MapName":"来自金星","CreateTime":"2017-6-24 16:31:18","tName":"性感","isDZ":0},{"Id":693338,"UserID":11756215,"Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","LikeTotal":10,"nick":"??玉??","positionName":"38岁","MapName":"新双路","CreateTime":"2017-6-24 16:12:29","tName":"性感","isDZ":0},{"Id":742652,"UserID":25250139,"Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","LikeTotal":3,"nick":"那年╮莪笑靥如花","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-6-2 22:33:57","tName":"性感","isDZ":0},{"Id":709775,"UserID":22076107,"Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_500x300(w).jpg","LikeTotal":2,"nick":"","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-4-22 6:25:00","tName":"性感","isDZ":0},{"Id":523734,"UserID":11928010,"Photo":"http://p2.pccoo.cn/PHBBS/20150517/2015051721263083536637m.jpg","LikeTotal":2,"nick":"站住！打劫！","positionName":"23岁","MapName":"党校","CreateTime":"2016-5-28 14:10:30","tName":"性感","isDZ":0}],"Count":6},"TotalPage":1,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0644531
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
         * CoverPhotoDetailsInfo : {"CoverPhotoDetailsInfo":[{"Id":720472,"UserID":23139611,"Photo":"http://r9.pccoo.cn/weixin/20161226/2016122623043751835113_960_1280_500x300(w).jpg","LikeTotal":4,"nick":"??。静。??","positionName":"33岁","MapName":"格兰","CreateTime":"2017-6-24 16:40:09","tName":"性感","isDZ":0},{"Id":190638,"UserID":16879465,"Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","LikeTotal":6,"nick":"七分毒","positionName":"31岁","MapName":"来自金星","CreateTime":"2017-6-24 16:31:18","tName":"性感","isDZ":0},{"Id":693338,"UserID":11756215,"Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","LikeTotal":10,"nick":"??玉??","positionName":"38岁","MapName":"新双路","CreateTime":"2017-6-24 16:12:29","tName":"性感","isDZ":0},{"Id":742652,"UserID":25250139,"Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","LikeTotal":3,"nick":"那年╮莪笑靥如花","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-6-2 22:33:57","tName":"性感","isDZ":0},{"Id":709775,"UserID":22076107,"Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_500x300(w).jpg","LikeTotal":2,"nick":"","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-4-22 6:25:00","tName":"性感","isDZ":0},{"Id":523734,"UserID":11928010,"Photo":"http://p2.pccoo.cn/PHBBS/20150517/2015051721263083536637m.jpg","LikeTotal":2,"nick":"站住！打劫！","positionName":"23岁","MapName":"党校","CreateTime":"2016-5-28 14:10:30","tName":"性感","isDZ":0}],"Count":6}
         * TotalPage : 1
         * UpdateCount : 0
         */

        private CoverPhotoDetailsInfoBeanX CoverPhotoDetailsInfo;
        private int TotalPage;
        private int UpdateCount;

        public CoverPhotoDetailsInfoBeanX getCoverPhotoDetailsInfo() {
            return CoverPhotoDetailsInfo;
        }

        public void setCoverPhotoDetailsInfo(CoverPhotoDetailsInfoBeanX CoverPhotoDetailsInfo) {
            this.CoverPhotoDetailsInfo = CoverPhotoDetailsInfo;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public int getUpdateCount() {
            return UpdateCount;
        }

        public void setUpdateCount(int UpdateCount) {
            this.UpdateCount = UpdateCount;
        }

        public static class CoverPhotoDetailsInfoBeanX {
            /**
             * CoverPhotoDetailsInfo : [{"Id":720472,"UserID":23139611,"Photo":"http://r9.pccoo.cn/weixin/20161226/2016122623043751835113_960_1280_500x300(w).jpg","LikeTotal":4,"nick":"??。静。??","positionName":"33岁","MapName":"格兰","CreateTime":"2017-6-24 16:40:09","tName":"性感","isDZ":0},{"Id":190638,"UserID":16879465,"Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","LikeTotal":6,"nick":"七分毒","positionName":"31岁","MapName":"来自金星","CreateTime":"2017-6-24 16:31:18","tName":"性感","isDZ":0},{"Id":693338,"UserID":11756215,"Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","LikeTotal":10,"nick":"??玉??","positionName":"38岁","MapName":"新双路","CreateTime":"2017-6-24 16:12:29","tName":"性感","isDZ":0},{"Id":742652,"UserID":25250139,"Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","LikeTotal":3,"nick":"那年╮莪笑靥如花","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-6-2 22:33:57","tName":"性感","isDZ":0},{"Id":709775,"UserID":22076107,"Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_500x300(w).jpg","LikeTotal":2,"nick":"","positionName":"28岁","MapName":"来自金星","CreateTime":"2017-4-22 6:25:00","tName":"性感","isDZ":0},{"Id":523734,"UserID":11928010,"Photo":"http://p2.pccoo.cn/PHBBS/20150517/2015051721263083536637m.jpg","LikeTotal":2,"nick":"站住！打劫！","positionName":"23岁","MapName":"党校","CreateTime":"2016-5-28 14:10:30","tName":"性感","isDZ":0}]
             * Count : 6
             */

            private int Count;
            private List<CoverPhotoDetailsInfoBean> CoverPhotoDetailsInfo;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<CoverPhotoDetailsInfoBean> getCoverPhotoDetailsInfo() {
                return CoverPhotoDetailsInfo;
            }

            public void setCoverPhotoDetailsInfo(List<CoverPhotoDetailsInfoBean> CoverPhotoDetailsInfo) {
                this.CoverPhotoDetailsInfo = CoverPhotoDetailsInfo;
            }

            public static class CoverPhotoDetailsInfoBean {
                /**
                 * Id : 720472
                 * UserID : 23139611
                 * Photo : http://r9.pccoo.cn/weixin/20161226/2016122623043751835113_960_1280_500x300(w).jpg
                 * LikeTotal : 4
                 * nick : ??。静。??
                 * positionName : 33岁
                 * MapName : 格兰
                 * CreateTime : 2017-6-24 16:40:09
                 * tName : 性感
                 * isDZ : 0
                 */

                private int Id;
                private int UserID;
                private String Photo;
                private int LikeTotal;
                private String nick;
                private String positionName;
                private String MapName;
                private String CreateTime;
                private String tName;
                private int isDZ;

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

                public int getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(int LikeTotal) {
                    this.LikeTotal = LikeTotal;
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

                public String getMapName() {
                    return MapName;
                }

                public void setMapName(String MapName) {
                    this.MapName = MapName;
                }

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public String getTName() {
                    return tName;
                }

                public void setTName(String tName) {
                    this.tName = tName;
                }

                public int getIsDZ() {
                    return isDZ;
                }

                public void setIsDZ(int isDZ) {
                    this.isDZ = isDZ;
                }
            }
        }
    }
}
