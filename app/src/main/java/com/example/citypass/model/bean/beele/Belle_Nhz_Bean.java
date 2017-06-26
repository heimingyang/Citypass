package com.example.citypass.model.bean.beele;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 0026 15:01
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

public class Belle_Nhz_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoverPhotoDetailsInfo":{"CoverPhotoDetailsInfo":[{"Id":828378,"UserID":30108866,"Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","LikeTotal":4,"nick":"??","positionName":"18岁","MapName":"北京吉利大学","CreateTime":"2017-6-26 11:25:38","tName":"女汉子","isDZ":0},{"Id":322557,"UserID":16431230,"Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","LikeTotal":7,"nick":"A.ヾ─╄ Cy ","positionName":"26岁","MapName":"来自金星","CreateTime":"2017-6-24 16:12:30","tName":"女汉子","isDZ":0}],"Count":2},"TotalPage":1,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1884766
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
         * CoverPhotoDetailsInfo : {"CoverPhotoDetailsInfo":[{"Id":828378,"UserID":30108866,"Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","LikeTotal":4,"nick":"??","positionName":"18岁","MapName":"北京吉利大学","CreateTime":"2017-6-26 11:25:38","tName":"女汉子","isDZ":0},{"Id":322557,"UserID":16431230,"Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","LikeTotal":7,"nick":"A.ヾ─╄ Cy ","positionName":"26岁","MapName":"来自金星","CreateTime":"2017-6-24 16:12:30","tName":"女汉子","isDZ":0}],"Count":2}
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
             * CoverPhotoDetailsInfo : [{"Id":828378,"UserID":30108866,"Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg","LikeTotal":4,"nick":"??","positionName":"18岁","MapName":"北京吉利大学","CreateTime":"2017-6-26 11:25:38","tName":"女汉子","isDZ":0},{"Id":322557,"UserID":16431230,"Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","LikeTotal":7,"nick":"A.ヾ─╄ Cy ","positionName":"26岁","MapName":"来自金星","CreateTime":"2017-6-24 16:12:30","tName":"女汉子","isDZ":0}]
             * Count : 2
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
                 * Id : 828378
                 * UserID : 30108866
                 * Photo : http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_500x300(w).jpg
                 * LikeTotal : 4
                 * nick : ??
                 * positionName : 18岁
                 * MapName : 北京吉利大学
                 * CreateTime : 2017-6-26 11:25:38
                 * tName : 女汉子
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
