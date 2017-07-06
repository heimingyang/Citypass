package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/3 21:02
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


public class Dianzanbean {

    /**
     * Count : 0
     * Extend : {"reMsg":"","reTask":[{"code":1006,"coin":0,"id":75476,"integral":10,"property":0,"title":"点赞"}]}
     * GxNum : 0
     * MessageList : {"code":1000,"message":"点赞成功~"}
     * PageNum : 0
     * retime : 0.1337891
     */

    private int Count;
    private ExtendBean Extend;
    private int GxNum;
    private MessageListBean MessageList;
    private int PageNum;
    private double retime;

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public ExtendBean getExtend() {
        return Extend;
    }

    public void setExtend(ExtendBean Extend) {
        this.Extend = Extend;
    }

    public int getGxNum() {
        return GxNum;
    }

    public void setGxNum(int GxNum) {
        this.GxNum = GxNum;
    }

    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
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

    public static class ExtendBean {
        /**
         * reMsg :
         * reTask : [{"code":1006,"coin":0,"id":75476,"integral":10,"property":0,"title":"点赞"}]
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
             * code : 1006
             * coin : 0
             * id : 75476
             * integral : 10
             * property : 0
             * title : 点赞
             */

            private int code;
            private int coin;
            private int id;
            private int integral;
            private int property;
            private String title;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getProperty() {
                return property;
            }

            public void setProperty(int property) {
                this.property = property;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class MessageListBean {
        /**
         * code : 1000
         * message : 点赞成功~
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
}
