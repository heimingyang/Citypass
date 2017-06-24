package com.example.citypass.model.bean.beele;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/24 0024 11:19
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

public class Beele_Zuixin_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"NewTCoverInfoList":{"NewTCoverInfoList":[{"Id":"825992","UserID":"30922969","Photo":"http://r9.pccoo.cn/weixin/20170619/2017061907193141435955_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小怂儿","positionName":"28岁","CreateTime":"2017-6-24 10:58:41","LikeTotal":"3","isDZ":0},{"Id":"828026","UserID":"31121613","Photo":"http://r9.pccoo.cn/weixin/20170622/2017062202321495499639_768_769_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"??","positionName":"28岁","CreateTime":"2017-6-24 10:57:04","LikeTotal":"3","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-6-24 10:56:57","LikeTotal":"5","isDZ":0},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","MapName":"北京吉利大学","tName":"","nick":"??","positionName":"18岁","CreateTime":"2017-6-24 10:56:31","LikeTotal":"2","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-24 10:56:17","LikeTotal":"9","isDZ":0},{"Id":"704325","UserID":"22212021","Photo":"http://r9.pccoo.cn/weixin/20161204/2016120422090972356077_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"","positionName":"28岁","CreateTime":"2017-6-24 10:56:05","LikeTotal":"4","isDZ":0},{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-24 10:55:59","LikeTotal":"5","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-24 10:55:58","LikeTotal":"6","isDZ":0},{"Id":"774138","UserID":"14495365","Photo":"http://r9.pccoo.cn/weixin/20170402/2017040211424087843026_600_900_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"咎由自取。","positionName":"28岁","CreateTime":"2017-6-24 10:55:54","LikeTotal":"9","isDZ":0},{"Id":"827322","UserID":"12963503","Photo":"http://r9.pccoo.cn/weixin/20170621/2017062101071114138786_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"我这暴脾气","positionName":"28岁","CreateTime":"2017-6-23 20:33:51","LikeTotal":"1","isDZ":0}],"Count":10},"TotalPage":11,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 1.7919922
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
         * NewTCoverInfoList : {"NewTCoverInfoList":[{"Id":"825992","UserID":"30922969","Photo":"http://r9.pccoo.cn/weixin/20170619/2017061907193141435955_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小怂儿","positionName":"28岁","CreateTime":"2017-6-24 10:58:41","LikeTotal":"3","isDZ":0},{"Id":"828026","UserID":"31121613","Photo":"http://r9.pccoo.cn/weixin/20170622/2017062202321495499639_768_769_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"??","positionName":"28岁","CreateTime":"2017-6-24 10:57:04","LikeTotal":"3","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-6-24 10:56:57","LikeTotal":"5","isDZ":0},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","MapName":"北京吉利大学","tName":"","nick":"??","positionName":"18岁","CreateTime":"2017-6-24 10:56:31","LikeTotal":"2","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-24 10:56:17","LikeTotal":"9","isDZ":0},{"Id":"704325","UserID":"22212021","Photo":"http://r9.pccoo.cn/weixin/20161204/2016120422090972356077_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"","positionName":"28岁","CreateTime":"2017-6-24 10:56:05","LikeTotal":"4","isDZ":0},{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-24 10:55:59","LikeTotal":"5","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-24 10:55:58","LikeTotal":"6","isDZ":0},{"Id":"774138","UserID":"14495365","Photo":"http://r9.pccoo.cn/weixin/20170402/2017040211424087843026_600_900_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"咎由自取。","positionName":"28岁","CreateTime":"2017-6-24 10:55:54","LikeTotal":"9","isDZ":0},{"Id":"827322","UserID":"12963503","Photo":"http://r9.pccoo.cn/weixin/20170621/2017062101071114138786_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"我这暴脾气","positionName":"28岁","CreateTime":"2017-6-23 20:33:51","LikeTotal":"1","isDZ":0}],"Count":10}
         * TotalPage : 11
         * UpdateCount : 0
         */

        private NewTCoverInfoListBeanX NewTCoverInfoList;
        private int TotalPage;
        private int UpdateCount;

        public NewTCoverInfoListBeanX getNewTCoverInfoList() {
            return NewTCoverInfoList;
        }

        public void setNewTCoverInfoList(NewTCoverInfoListBeanX NewTCoverInfoList) {
            this.NewTCoverInfoList = NewTCoverInfoList;
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

        public static class NewTCoverInfoListBeanX {
            /**
             * NewTCoverInfoList : [{"Id":"825992","UserID":"30922969","Photo":"http://r9.pccoo.cn/weixin/20170619/2017061907193141435955_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小怂儿","positionName":"28岁","CreateTime":"2017-6-24 10:58:41","LikeTotal":"3","isDZ":0},{"Id":"828026","UserID":"31121613","Photo":"http://r9.pccoo.cn/weixin/20170622/2017062202321495499639_768_769_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"??","positionName":"28岁","CreateTime":"2017-6-24 10:57:04","LikeTotal":"3","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-6-24 10:56:57","LikeTotal":"5","isDZ":0},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","MapName":"北京吉利大学","tName":"","nick":"??","positionName":"18岁","CreateTime":"2017-6-24 10:56:31","LikeTotal":"2","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-24 10:56:17","LikeTotal":"9","isDZ":0},{"Id":"704325","UserID":"22212021","Photo":"http://r9.pccoo.cn/weixin/20161204/2016120422090972356077_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"","positionName":"28岁","CreateTime":"2017-6-24 10:56:05","LikeTotal":"4","isDZ":0},{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-24 10:55:59","LikeTotal":"5","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-24 10:55:58","LikeTotal":"6","isDZ":0},{"Id":"774138","UserID":"14495365","Photo":"http://r9.pccoo.cn/weixin/20170402/2017040211424087843026_600_900_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"咎由自取。","positionName":"28岁","CreateTime":"2017-6-24 10:55:54","LikeTotal":"9","isDZ":0},{"Id":"827322","UserID":"12963503","Photo":"http://r9.pccoo.cn/weixin/20170621/2017062101071114138786_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"我这暴脾气","positionName":"28岁","CreateTime":"2017-6-23 20:33:51","LikeTotal":"1","isDZ":0}]
             * Count : 10
             */

            private int Count;
            private List<NewTCoverInfoListBean> NewTCoverInfoList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<NewTCoverInfoListBean> getNewTCoverInfoList() {
                return NewTCoverInfoList;
            }

            public void setNewTCoverInfoList(List<NewTCoverInfoListBean> NewTCoverInfoList) {
                this.NewTCoverInfoList = NewTCoverInfoList;
            }

            public static class NewTCoverInfoListBean {
                /**
                 * Id : 825992
                 * UserID : 30922969
                 * Photo : http://r9.pccoo.cn/weixin/20170619/2017061907193141435955_960_1280_500x300(w).jpg
                 * MapName : 来自金星
                 * tName :
                 * nick : 小怂儿
                 * positionName : 28岁
                 * CreateTime : 2017-6-24 10:58:41
                 * LikeTotal : 3
                 * isDZ : 0
                 */

                private String Id;
                private String UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;
                private String CreateTime;
                private String LikeTotal;
                private int isDZ;

                public String getId() {
                    return Id;
                }

                public void setId(String Id) {
                    this.Id = Id;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
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

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
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
