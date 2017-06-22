package com.example.citypass.model.bean.naonao;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/20 0020 17:23
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


public class NaoNao_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":1,"Class":0,"Name":"闹闹帝","Buju":1,"LocationId":0},{"Id":2,"Class":0,"Name":"闹闹王","Buju":2,"LocationId":0},{"Id":3,"Class":0,"Name":"闹闹星","Buju":3,"LocationId":0},{"Id":5,"Class":1,"Name":"广场","Buju":0,"LocationId":1},{"Id":4,"Class":1,"Name":"话题","Buju":1,"LocationId":0},{"Id":0,"Class":1,"Name":"推荐","Buju":0,"LocationId":0},{"Id":2,"Class":1,"Name":"晒图","Buju":2,"LocationId":0},{"Id":3,"Class":1,"Name":"网友自荐","Buju":0,"LocationId":0}]
     * Extend : null
     * Count : 8
     * GxNum : 0
     * PageNum : 0
     * retime : 0.009766
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
         * Id : 1
         * Class : 0
         * Name : 闹闹帝
         * Buju : 1
         * LocationId : 0
         */

        private int Id;
        private int Class;
        private String Name;
        private int Buju;
        private int LocationId;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }



        public void setClass(int Class) {
            this.Class = Class;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getBuju() {
            return Buju;
        }

        public void setBuju(int Buju) {
            this.Buju = Buju;
        }

        public int getLocationId() {
            return LocationId;
        }

        public void setLocationId(int LocationId) {
            this.LocationId = LocationId;
        }
    }
}
