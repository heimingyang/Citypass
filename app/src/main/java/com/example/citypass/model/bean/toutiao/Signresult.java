package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/29 20:32
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


public class Signresult {

    /**
     * MessageList : {"code":1000,"message":"签到成功"}
     * ServerInfo : {"SignInfo":{"ID":75477,"Title":"每日签到","Coin":3,"Integral":50,"Continuous":7,"LXCoin":15,"LXIntegral":20,"UserSignday":3}}
     * Extend : {"reTask":[{"id":75477,"title":"每日签到","property":0,"integral":50,"coin":0,"code":1000}],"reMsg":""}
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1113281
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
    private ExtendBean Extend;
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

    public ExtendBean getExtend() {
        return Extend;
    }

    public void setExtend(ExtendBean Extend) {
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
         * message : 签到成功
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
         * SignInfo : {"ID":75477,"Title":"每日签到","Coin":3,"Integral":50,"Continuous":7,"LXCoin":15,"LXIntegral":20,"UserSignday":3}
         */

        private SignInfoBean SignInfo;

        public SignInfoBean getSignInfo() {
            return SignInfo;
        }

        public void setSignInfo(SignInfoBean SignInfo) {
            this.SignInfo = SignInfo;
        }

        public static class SignInfoBean {
            /**
             * ID : 75477
             * Title : 每日签到
             * Coin : 3
             * Integral : 50
             * Continuous : 7
             * LXCoin : 15
             * LXIntegral : 20
             * UserSignday : 3
             */

            private int ID;
            private String Title;
            private int Coin;
            private int Integral;
            private int Continuous;
            private int LXCoin;
            private int LXIntegral;
            private int UserSignday;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getCoin() {
                return Coin;
            }

            public void setCoin(int Coin) {
                this.Coin = Coin;
            }

            public int getIntegral() {
                return Integral;
            }

            public void setIntegral(int Integral) {
                this.Integral = Integral;
            }

            public int getContinuous() {
                return Continuous;
            }

            public void setContinuous(int Continuous) {
                this.Continuous = Continuous;
            }

            public int getLXCoin() {
                return LXCoin;
            }

            public void setLXCoin(int LXCoin) {
                this.LXCoin = LXCoin;
            }

            public int getLXIntegral() {
                return LXIntegral;
            }

            public void setLXIntegral(int LXIntegral) {
                this.LXIntegral = LXIntegral;
            }

            public int getUserSignday() {
                return UserSignday;
            }

            public void setUserSignday(int UserSignday) {
                this.UserSignday = UserSignday;
            }
        }
    }

    public static class ExtendBean {
        /**
         * reTask : [{"id":75477,"title":"每日签到","property":0,"integral":50,"coin":0,"code":1000}]
         * reMsg :
         */

        private String reMsg;
        private List<ReTaskBean> reTask;

        public String getReMsg() {
            return reMsg;
        }

        public void setReMsg(String reMsg) {
            this.reMsg = reMsg;
        }

        public List<ReTaskBean> getReTask() {
            return reTask;
        }

        public void setReTask(List<ReTaskBean> reTask) {
            this.reTask = reTask;
        }

        public static class ReTaskBean {
            /**
             * id : 75477
             * title : 每日签到
             * property : 0
             * integral : 50
             * coin : 0
             * code : 1000
             */

            private int id;
            private String title;
            private int property;
            private int integral;
            private int coin;
            private int code;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getProperty() {
                return property;
            }

            public void setProperty(int property) {
                this.property = property;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }
        }
    }
}
