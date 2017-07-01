package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/1 10:12
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


public class Showbean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"TCoverInfoByGirlList":{"TCoverInfoByGirlList":[{"Id":"220825","UserID":"11640046","Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"第1期封面人物,30岁","tName":"","nick":"依然","positionName":"职业不明"},{"Id":"805407","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353468475880_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"性感","nick":"呼噜路","positionName":"职业不明"},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_300x225(s).jpg","MapName":"北京吉利大学","tName":"冷艳","nick":"??","positionName":"职业不明"},{"Id":"709775","UserID":"22076107","Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"气质","nick":"","positionName":"职业不明"},{"Id":"805406","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353379983385_864_864_300x225(s).jpg","MapName":"来自萌星","tName":"萌妹子","nick":"呼噜路","positionName":"职业不明"},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810s.jpg","MapName":"来自萌星","tName":"女汉子","nick":"A.ヾ─╄ Cy ","positionName":"职业不明"}],"Count":6},"TCoverInfoByBoyList":{"TCoverInfoByBoyList":[{"Id":"417784","UserID":"14945534","Photo":"http://p3.pccoo.cn/PHBBS/20150805/2015080518402336371765m.jpg","MapName":"第1期封面人物,28岁","tName":"","nick":"谁你动 ","positionName":"职业不明"},{"Id":"832643","UserID":"31370528","Photo":"http://r9.pccoo.cn/app_bbs/20170629/2017062911470383457055_1080_1920_300x225(s).jpg","MapName":"北京吉利大学","tName":"单身墙","nick":"ZJ_杰森","positionName":"职业不明"}],"Count":2},"TCoverInfoByBaByList":{"TCoverInfoByBaByList":[{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"","nick":"刘博妍","positionName":"1岁6个月"},{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"表情帝","nick":"刘博妍","positionName":"1岁6个月"}],"Count":2}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.357399
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
         * TCoverInfoByGirlList : {"TCoverInfoByGirlList":[{"Id":"220825","UserID":"11640046","Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"第1期封面人物,30岁","tName":"","nick":"依然","positionName":"职业不明"},{"Id":"805407","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353468475880_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"性感","nick":"呼噜路","positionName":"职业不明"},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_300x225(s).jpg","MapName":"北京吉利大学","tName":"冷艳","nick":"??","positionName":"职业不明"},{"Id":"709775","UserID":"22076107","Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"气质","nick":"","positionName":"职业不明"},{"Id":"805406","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353379983385_864_864_300x225(s).jpg","MapName":"来自萌星","tName":"萌妹子","nick":"呼噜路","positionName":"职业不明"},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810s.jpg","MapName":"来自萌星","tName":"女汉子","nick":"A.ヾ─╄ Cy ","positionName":"职业不明"}],"Count":6}
         * TCoverInfoByBoyList : {"TCoverInfoByBoyList":[{"Id":"417784","UserID":"14945534","Photo":"http://p3.pccoo.cn/PHBBS/20150805/2015080518402336371765m.jpg","MapName":"第1期封面人物,28岁","tName":"","nick":"谁你动 ","positionName":"职业不明"},{"Id":"832643","UserID":"31370528","Photo":"http://r9.pccoo.cn/app_bbs/20170629/2017062911470383457055_1080_1920_300x225(s).jpg","MapName":"北京吉利大学","tName":"单身墙","nick":"ZJ_杰森","positionName":"职业不明"}],"Count":2}
         * TCoverInfoByBaByList : {"TCoverInfoByBaByList":[{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"","nick":"刘博妍","positionName":"1岁6个月"},{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"表情帝","nick":"刘博妍","positionName":"1岁6个月"}],"Count":2}
         */

        private TCoverInfoByGirlListBeanX TCoverInfoByGirlList;
        private TCoverInfoByBoyListBeanX TCoverInfoByBoyList;
        private TCoverInfoByBaByListBeanX TCoverInfoByBaByList;

        public TCoverInfoByGirlListBeanX getTCoverInfoByGirlList() {
            return TCoverInfoByGirlList;
        }

        public void setTCoverInfoByGirlList(TCoverInfoByGirlListBeanX TCoverInfoByGirlList) {
            this.TCoverInfoByGirlList = TCoverInfoByGirlList;
        }

        public TCoverInfoByBoyListBeanX getTCoverInfoByBoyList() {
            return TCoverInfoByBoyList;
        }

        public void setTCoverInfoByBoyList(TCoverInfoByBoyListBeanX TCoverInfoByBoyList) {
            this.TCoverInfoByBoyList = TCoverInfoByBoyList;
        }

        public TCoverInfoByBaByListBeanX getTCoverInfoByBaByList() {
            return TCoverInfoByBaByList;
        }

        public void setTCoverInfoByBaByList(TCoverInfoByBaByListBeanX TCoverInfoByBaByList) {
            this.TCoverInfoByBaByList = TCoverInfoByBaByList;
        }

        public static class TCoverInfoByGirlListBeanX {
            /**
             * TCoverInfoByGirlList : [{"Id":"220825","UserID":"11640046","Photo":"http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg","MapName":"第1期封面人物,30岁","tName":"","nick":"依然","positionName":"职业不明"},{"Id":"805407","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353468475880_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"性感","nick":"呼噜路","positionName":"职业不明"},{"Id":"828378","UserID":"30108866","Photo":"http://r9.pccoo.cn/app_bbs/20170622/2017062215012619115457_540_960_300x225(s).jpg","MapName":"北京吉利大学","tName":"冷艳","nick":"??","positionName":"职业不明"},{"Id":"709775","UserID":"22076107","Photo":"http://r9.pccoo.cn/weixin/20161211/2016121123140767867956_960_1280_300x225(s).jpg","MapName":"来自萌星","tName":"气质","nick":"","positionName":"职业不明"},{"Id":"805406","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353379983385_864_864_300x225(s).jpg","MapName":"来自萌星","tName":"萌妹子","nick":"呼噜路","positionName":"职业不明"},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810s.jpg","MapName":"来自萌星","tName":"女汉子","nick":"A.ヾ─╄ Cy ","positionName":"职业不明"}]
             * Count : 6
             */

            private int Count;
            private List<TCoverInfoByGirlListBean> TCoverInfoByGirlList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<TCoverInfoByGirlListBean> getTCoverInfoByGirlList() {
                return TCoverInfoByGirlList;
            }

            public void setTCoverInfoByGirlList(List<TCoverInfoByGirlListBean> TCoverInfoByGirlList) {
                this.TCoverInfoByGirlList = TCoverInfoByGirlList;
            }

            public static class TCoverInfoByGirlListBean {
                /**
                 * Id : 220825
                 * UserID : 11640046
                 * Photo : http://p2.pccoo.cn/PHBBS/20150603/2015060320054319582672m.jpg
                 * MapName : 第1期封面人物,30岁
                 * tName :
                 * nick : 依然
                 * positionName : 职业不明
                 */

                private String Id;
                private String UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;

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
            }
        }

        public static class TCoverInfoByBoyListBeanX {
            /**
             * TCoverInfoByBoyList : [{"Id":"417784","UserID":"14945534","Photo":"http://p3.pccoo.cn/PHBBS/20150805/2015080518402336371765m.jpg","MapName":"第1期封面人物,28岁","tName":"","nick":"谁你动 ","positionName":"职业不明"},{"Id":"832643","UserID":"31370528","Photo":"http://r9.pccoo.cn/app_bbs/20170629/2017062911470383457055_1080_1920_300x225(s).jpg","MapName":"北京吉利大学","tName":"单身墙","nick":"ZJ_杰森","positionName":"职业不明"}]
             * Count : 2
             */

            private int Count;
            private List<TCoverInfoByBoyListBean> TCoverInfoByBoyList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<TCoverInfoByBoyListBean> getTCoverInfoByBoyList() {
                return TCoverInfoByBoyList;
            }

            public void setTCoverInfoByBoyList(List<TCoverInfoByBoyListBean> TCoverInfoByBoyList) {
                this.TCoverInfoByBoyList = TCoverInfoByBoyList;
            }

            public static class TCoverInfoByBoyListBean {
                /**
                 * Id : 417784
                 * UserID : 14945534
                 * Photo : http://p3.pccoo.cn/PHBBS/20150805/2015080518402336371765m.jpg
                 * MapName : 第1期封面人物,28岁
                 * tName :
                 * nick : 谁你动 
                 * positionName : 职业不明
                 */

                private String Id;
                private String UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;

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
            }
        }

        public static class TCoverInfoByBaByListBeanX {
            /**
             * TCoverInfoByBaByList : [{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"","nick":"刘博妍","positionName":"1岁6个月"},{"Id":"69906","UserID":"23502","Photo":"http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg","MapName":"第1期封面宝宝,1岁6个月岁","tName":"表情帝","nick":"刘博妍","positionName":"1岁6个月"}]
             * Count : 2
             */

            private int Count;
            private List<TCoverInfoByBaByListBean> TCoverInfoByBaByList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<TCoverInfoByBaByListBean> getTCoverInfoByBaByList() {
                return TCoverInfoByBaByList;
            }

            public void setTCoverInfoByBaByList(List<TCoverInfoByBaByListBean> TCoverInfoByBaByList) {
                this.TCoverInfoByBaByList = TCoverInfoByBaByList;
            }

            public static class TCoverInfoByBaByListBean {
                /**
                 * Id : 69906
                 * UserID : 23502
                 * Photo : http://p1.pccoo.cn/PHBBS/20150623/2015062308343323870102m.jpg
                 * MapName : 第1期封面宝宝,1岁6个月岁
                 * tName :
                 * nick : 刘博妍
                 * positionName : 1岁6个月
                 */

                private String Id;
                private String UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;

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
            }
        }
    }
}
