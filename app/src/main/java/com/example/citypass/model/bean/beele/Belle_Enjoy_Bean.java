package com.example.citypass.model.bean.beele;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/23 0023 19:22
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

public class Belle_Enjoy_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoverXinShangInfoListTop3":{"CoverXinShangInfoListTop3":[{"Number":"1","UserID":"28998068","LikeTotal":"12","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"30959881","LikeTotal":"4","nick":"﹏ 常、育萍","Age":"20","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/1714B402D8073F93E298788EFB346AFD/100","Sex":"男"}],"Count":3},"CoverXinShangInfoList":{"CoverXinShangInfoList":[{"Number":4,"UserID":"28833985","LikeTotal":"3","nick":"忘记了拥抱","Age":"25","positionName":"IT","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170613/2017061314242806405536_780_780_150x150(s).jpg","Sex":"男"},{"Number":5,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"},{"Number":6,"UserID":"31085236","LikeTotal":"1","nick":"杨阿杨阿阳、","Age":"19","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/43631B530525F43B2AD137CB5F5F169F/100","Sex":"男"},{"Number":7,"UserID":"31164612","LikeTotal":"1","nick":"不讨喜！！！","Age":"18","positionName":"职业不明","address":"北京吉利大学","userface":"http://r5.pccoo.cn/weixin/20170622/2017062219145324430559_150x150(s).jpg","Sex":"女"}],"Count":7},"CurrMyRankStr":""}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0205086
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
         * CoverXinShangInfoListTop3 : {"CoverXinShangInfoListTop3":[{"Number":"1","UserID":"28998068","LikeTotal":"12","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"30959881","LikeTotal":"4","nick":"﹏ 常、育萍","Age":"20","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/1714B402D8073F93E298788EFB346AFD/100","Sex":"男"}],"Count":3}
         * CoverXinShangInfoList : {"CoverXinShangInfoList":[{"Number":4,"UserID":"28833985","LikeTotal":"3","nick":"忘记了拥抱","Age":"25","positionName":"IT","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170613/2017061314242806405536_780_780_150x150(s).jpg","Sex":"男"},{"Number":5,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"},{"Number":6,"UserID":"31085236","LikeTotal":"1","nick":"杨阿杨阿阳、","Age":"19","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/43631B530525F43B2AD137CB5F5F169F/100","Sex":"男"},{"Number":7,"UserID":"31164612","LikeTotal":"1","nick":"不讨喜！！！","Age":"18","positionName":"职业不明","address":"北京吉利大学","userface":"http://r5.pccoo.cn/weixin/20170622/2017062219145324430559_150x150(s).jpg","Sex":"女"}],"Count":7}
         * CurrMyRankStr :
         */

        private CoverXinShangInfoListTop3BeanX CoverXinShangInfoListTop3;
        private CoverXinShangInfoListBeanX CoverXinShangInfoList;
        private String CurrMyRankStr;

        public CoverXinShangInfoListTop3BeanX getCoverXinShangInfoListTop3() {
            return CoverXinShangInfoListTop3;
        }

        public void setCoverXinShangInfoListTop3(CoverXinShangInfoListTop3BeanX CoverXinShangInfoListTop3) {
            this.CoverXinShangInfoListTop3 = CoverXinShangInfoListTop3;
        }

        public CoverXinShangInfoListBeanX getCoverXinShangInfoList() {
            return CoverXinShangInfoList;
        }

        public void setCoverXinShangInfoList(CoverXinShangInfoListBeanX CoverXinShangInfoList) {
            this.CoverXinShangInfoList = CoverXinShangInfoList;
        }

        public String getCurrMyRankStr() {
            return CurrMyRankStr;
        }

        public void setCurrMyRankStr(String CurrMyRankStr) {
            this.CurrMyRankStr = CurrMyRankStr;
        }

        public static class CoverXinShangInfoListTop3BeanX {
            /**
             * CoverXinShangInfoListTop3 : [{"Number":"1","UserID":"28998068","LikeTotal":"12","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"30959881","LikeTotal":"4","nick":"﹏ 常、育萍","Age":"20","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/1714B402D8073F93E298788EFB346AFD/100","Sex":"男"}]
             * Count : 3
             */

            private int Count;
            private List<CoverXinShangInfoListTop3Bean> CoverXinShangInfoListTop3;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<CoverXinShangInfoListTop3Bean> getCoverXinShangInfoListTop3() {
                return CoverXinShangInfoListTop3;
            }

            public void setCoverXinShangInfoListTop3(List<CoverXinShangInfoListTop3Bean> CoverXinShangInfoListTop3) {
                this.CoverXinShangInfoListTop3 = CoverXinShangInfoListTop3;
            }

            public static class CoverXinShangInfoListTop3Bean {
                /**
                 * Number : 1
                 * UserID : 28998068
                 * LikeTotal : 12
                 * nick : ︶ㄣ冷煙～潕
                 * Age : 38
                 * positionName : 职业不明
                 * address : 北京吉利大学
                 * userface : http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100
                 * Sex : 男
                 */

                private String Number;
                private String UserID;
                private String LikeTotal;
                private String nick;
                private String Age;
                private String positionName;
                private String address;
                private String userface;
                private String Sex;

                public String getNumber() {
                    return Number;
                }

                public void setNumber(String Number) {
                    this.Number = Number;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
                    this.UserID = UserID;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }
            }
        }

        public static class CoverXinShangInfoListBeanX {
            /**
             * CoverXinShangInfoList : [{"Number":4,"UserID":"28833985","LikeTotal":"3","nick":"忘记了拥抱","Age":"25","positionName":"IT","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170613/2017061314242806405536_780_780_150x150(s).jpg","Sex":"男"},{"Number":5,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"},{"Number":6,"UserID":"31085236","LikeTotal":"1","nick":"杨阿杨阿阳、","Age":"19","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/43631B530525F43B2AD137CB5F5F169F/100","Sex":"男"},{"Number":7,"UserID":"31164612","LikeTotal":"1","nick":"不讨喜！！！","Age":"18","positionName":"职业不明","address":"北京吉利大学","userface":"http://r5.pccoo.cn/weixin/20170622/2017062219145324430559_150x150(s).jpg","Sex":"女"}]
             * Count : 7
             */

            private int Count;
            private List<CoverXinShangInfoListBean> CoverXinShangInfoList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<CoverXinShangInfoListBean> getCoverXinShangInfoList() {
                return CoverXinShangInfoList;
            }

            public void setCoverXinShangInfoList(List<CoverXinShangInfoListBean> CoverXinShangInfoList) {
                this.CoverXinShangInfoList = CoverXinShangInfoList;
            }

            public static class CoverXinShangInfoListBean {
                /**
                 * Number : 4
                 * UserID : 28833985
                 * LikeTotal : 3
                 * nick : 忘记了拥抱
                 * Age : 25
                 * positionName : IT
                 * address : 北京吉利大学
                 * userface : http://r9.pccoo.cn/app_avatar/20170613/2017061314242806405536_780_780_150x150(s).jpg
                 * Sex : 男
                 */

                private int Number;
                private String UserID;
                private String LikeTotal;
                private String nick;
                private String Age;
                private String positionName;
                private String address;
                private String userface;
                private String Sex;

                public int getNumber() {
                    return Number;
                }

                public void setNumber(int Number) {
                    this.Number = Number;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
                    this.UserID = UserID;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }
            }
        }
    }
}
