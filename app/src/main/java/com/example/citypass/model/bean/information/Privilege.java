package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 11:01
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Privilege {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MyPrivilegeList : {"MyPrivilegeList":[],"Count":0}
     * UserPrivilegeList : {"UserPrivilegeList":[{"PrivilegeID":7,"Name":"发帖免审","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615335720954187.png","Description":"社区发帖在不包含违规关键词的情况下无需审核，直接通过","HName":"居委委员"},{"PrivilegeID":8,"Name":"发起投票","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615333472163144.png","Description":"享有发布投票等特殊贴权限","HName":"小区区长"},{"PrivilegeID":9,"Name":"高级表情","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615332671888696.png","Description":"发贴时可使用高级酷炫表情","HName":"模范市民"},{"PrivilegeID":10,"Name":"一言九顶","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615331547781712.png","Description":"点赞 1赞等于9赞 彰显特殊身份","HName":"街道主任"},{"PrivilegeID":11,"Name":"发起活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615330004331868.png","Description":"有发布活动权限，让他人报名参与","HName":"小区区长"},{"PrivilegeID":14,"Name":"抽城市币","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615325035415409.png","Description":"极高概率获得城市币、道具、成长值（lv4级别及其以上会员可每天免费抽取一次）","HName":"合格市民"},{"PrivilegeID":15,"Name":"特供商品","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615324071724693.png","Description":"有权兑换特定等级限制的商品","HName":"居委委员"},{"PrivilegeID":16,"Name":"管理员关注","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615323101808234.png","Description":"有机会成为本站活动的嘉宾或评委","HName":"居委主任"},{"PrivilegeID":17,"Name":"专享礼品","PImage":"http://p3.pccoo.cn/vote/20160130/2016013013422871269059.png","Description":"有权兑换特定等级限制的特别礼品","HName":"政协委员"},{"PrivilegeID":18,"Name":"节日礼包","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615321124141119.png","Description":"节假日可领取网站派发的虚拟赠品","HName":"小区楼长"},{"PrivilegeID":19,"Name":"专享活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615320174500479.png","Description":"免费参与如\"北京三日游\"等本站承担费用活动（具体将根据网站实时公告而定）","HName":"人大代表"}],"Count":11}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"MyPrivilegeList":{"MyPrivilegeList":[],"Count":0},"UserPrivilegeList":{"UserPrivilegeList":[{"PrivilegeID":7,"Name":"发帖免审","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615335720954187.png","Description":"社区发帖在不包含违规关键词的情况下无需审核，直接通过","HName":"居委委员"},{"PrivilegeID":8,"Name":"发起投票","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615333472163144.png","Description":"享有发布投票等特殊贴权限","HName":"小区区长"},{"PrivilegeID":9,"Name":"高级表情","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615332671888696.png","Description":"发贴时可使用高级酷炫表情","HName":"模范市民"},{"PrivilegeID":10,"Name":"一言九顶","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615331547781712.png","Description":"点赞 1赞等于9赞 彰显特殊身份","HName":"街道主任"},{"PrivilegeID":11,"Name":"发起活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615330004331868.png","Description":"有发布活动权限，让他人报名参与","HName":"小区区长"},{"PrivilegeID":14,"Name":"抽城市币","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615325035415409.png","Description":"极高概率获得城市币、道具、成长值（lv4级别及其以上会员可每天免费抽取一次）","HName":"合格市民"},{"PrivilegeID":15,"Name":"特供商品","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615324071724693.png","Description":"有权兑换特定等级限制的商品","HName":"居委委员"},{"PrivilegeID":16,"Name":"管理员关注","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615323101808234.png","Description":"有机会成为本站活动的嘉宾或评委","HName":"居委主任"},{"PrivilegeID":17,"Name":"专享礼品","PImage":"http://p3.pccoo.cn/vote/20160130/2016013013422871269059.png","Description":"有权兑换特定等级限制的特别礼品","HName":"政协委员"},{"PrivilegeID":18,"Name":"节日礼包","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615321124141119.png","Description":"节假日可领取网站派发的虚拟赠品","HName":"小区楼长"},{"PrivilegeID":19,"Name":"专享活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615320174500479.png","Description":"免费参与如\"北京三日游\"等本站承担费用活动（具体将根据网站实时公告而定）","HName":"人大代表"}],"Count":11}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0097657
     */

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
         * MyPrivilegeList : []
         * Count : 0
         */

        private MyPrivilegeListBean MyPrivilegeList;
        /**
         * UserPrivilegeList : [{"PrivilegeID":7,"Name":"发帖免审","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615335720954187.png","Description":"社区发帖在不包含违规关键词的情况下无需审核，直接通过","HName":"居委委员"},{"PrivilegeID":8,"Name":"发起投票","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615333472163144.png","Description":"享有发布投票等特殊贴权限","HName":"小区区长"},{"PrivilegeID":9,"Name":"高级表情","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615332671888696.png","Description":"发贴时可使用高级酷炫表情","HName":"模范市民"},{"PrivilegeID":10,"Name":"一言九顶","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615331547781712.png","Description":"点赞 1赞等于9赞 彰显特殊身份","HName":"街道主任"},{"PrivilegeID":11,"Name":"发起活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615330004331868.png","Description":"有发布活动权限，让他人报名参与","HName":"小区区长"},{"PrivilegeID":14,"Name":"抽城市币","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615325035415409.png","Description":"极高概率获得城市币、道具、成长值（lv4级别及其以上会员可每天免费抽取一次）","HName":"合格市民"},{"PrivilegeID":15,"Name":"特供商品","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615324071724693.png","Description":"有权兑换特定等级限制的商品","HName":"居委委员"},{"PrivilegeID":16,"Name":"管理员关注","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615323101808234.png","Description":"有机会成为本站活动的嘉宾或评委","HName":"居委主任"},{"PrivilegeID":17,"Name":"专享礼品","PImage":"http://p3.pccoo.cn/vote/20160130/2016013013422871269059.png","Description":"有权兑换特定等级限制的特别礼品","HName":"政协委员"},{"PrivilegeID":18,"Name":"节日礼包","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615321124141119.png","Description":"节假日可领取网站派发的虚拟赠品","HName":"小区楼长"},{"PrivilegeID":19,"Name":"专享活动","PImage":"http://p3.pccoo.cn/vote/20151126/2015112615320174500479.png","Description":"免费参与如\"北京三日游\"等本站承担费用活动（具体将根据网站实时公告而定）","HName":"人大代表"}]
         * Count : 11
         */

        private UserPrivilegeListBean UserPrivilegeList;


        public MyPrivilegeListBean getMyPrivilegeList() {
            return MyPrivilegeList;
        }

        public void setMyPrivilegeList(MyPrivilegeListBean MyPrivilegeList) {
            this.MyPrivilegeList = MyPrivilegeList;
        }

        public UserPrivilegeListBean getUserPrivilegeList() {
            return UserPrivilegeList;
        }

        public void setUserPrivilegeList(UserPrivilegeListBean UserPrivilegeList) {
            this.UserPrivilegeList = UserPrivilegeList;
        }

        public static class MyPrivilegeListBean {
            private int Count;
            private List<?> MyPrivilegeList;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<?> getMyPrivilegeList() {
                return MyPrivilegeList;
            }

            public void setMyPrivilegeList(List<?> MyPrivilegeList) {
                this.MyPrivilegeList = MyPrivilegeList;
            }
        }

        public static class UserPrivilegeListBean {
            private int Count;
            /**
             * PrivilegeID : 7
             * Name : 发帖免审
             * PImage : http://p3.pccoo.cn/vote/20151126/2015112615335720954187.png
             * Description : 社区发帖在不包含违规关键词的情况下无需审核，直接通过
             * HName : 居委委员
             */

            private List<UserPrivilegeListBeans> UserPrivilegeList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<UserPrivilegeListBeans> getUserPrivilegeList() {
                return UserPrivilegeList;
            }

            public void setUserPrivilegeList(List<UserPrivilegeListBeans> UserPrivilegeList) {
                this.UserPrivilegeList = UserPrivilegeList;
            }

            public static class UserPrivilegeListBeans {
                private int PrivilegeID;
                private String Name;
                private String PImage;
                private String Description;
                private String HName;


                public int getPrivilegeID() {
                    return PrivilegeID;
                }

                public void setPrivilegeID(int PrivilegeID) {
                    this.PrivilegeID = PrivilegeID;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public String getPImage() {
                    return PImage;
                }

                public void setPImage(String PImage) {
                    this.PImage = PImage;
                }

                public String getDescription() {
                    return Description;
                }

                public void setDescription(String Description) {
                    this.Description = Description;
                }

                public String getHName() {
                    return HName;
                }

                public void setHName(String HName) {
                    this.HName = HName;
                }
            }
        }
    }
}
