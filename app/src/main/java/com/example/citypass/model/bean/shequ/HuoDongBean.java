package com.example.citypass.model.bean.shequ;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 19:02
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class HuoDongBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ZTID":21768,"Title":"2016延庆单身男女相亲会","Image":"http://p3.pccoo.cn/bbs/20160107/2016010708402932707430s.jpg","ClassType":1,"Hit":9449,"AddTime":"2016-01-07","StartTime":"2015-11-11","EndTime":"2016-04-30","OtherID":0,"Editor":"yanqingccoo"},{"ZTID":21648,"Title":"2016延庆百姓春晚","Image":"http://p3.pccoo.cn/bbs/20151228/2015122817063451169640s.png","ClassType":0,"Hit":2530,"AddTime":"2015-12-08","StartTime":"2015-12-28","EndTime":"2015-12-29","OtherID":0,"Editor":"延庆在线"},{"ZTID":20843,"Title":"寻找延庆最美老板娘","Image":"http://p3.pccoo.cn/bbs/20150811/2015081109191588944758s.jpg","ClassType":0,"Hit":1893,"AddTime":"2015-08-11","StartTime":"2015-08-31","EndTime":"2015-09-01","OtherID":0,"Editor":"yqwfm2014"},{"ZTID":18986,"Title":"妫川骄子","Image":"http://p2.pccoo.cn/bbs/20141226/2014122613300935489436s.png","ClassType":0,"Hit":31639,"AddTime":"2014-12-26","StartTime":"2015-07-10","EndTime":"2015-07-11","OtherID":0,"Editor":"延庆电视台"},{"ZTID":18255,"Title":"延庆在线微封面\u201c我是明星\u201d","Image":"http://p2.pccoo.cn/bbs/20140903/2014090315405313193529s.jpg","ClassType":0,"Hit":1410,"AddTime":"2014-09-03","StartTime":"2014-09-05","EndTime":"2014-09-06","OtherID":0,"Editor":"延庆在线"},{"ZTID":17923,"Title":"延庆首届明星宝宝投票活动","Image":"http://p2.pccoo.cn/bbs/20140807/2014080713483470403484s.jpg","ClassType":0,"Hit":1934,"AddTime":"2014-08-07","StartTime":"2014-08-16","EndTime":"2014-08-17","OtherID":0,"Editor":"延庆在线编辑"},{"ZTID":15843,"Title":"墨墨的祝福-延庆本地民间慈善组织","Image":"http://p1.pccoo.cn/bar/20140312/201431217144163s.jpg","ClassType":0,"Hit":743,"AddTime":"2014-03-12","StartTime":"2014-11-13","EndTime":"2014-11-14","OtherID":0,"Editor":"子墨"},{"ZTID":20243,"Title":"延庆村里的有机生活","Image":"http://p2.pccoo.cn/bbs/20150603/2015060312193599833062s.jpg","ClassType":0,"Hit":739,"AddTime":"2015-06-03","StartTime":"2015-07-10","EndTime":"2015-07-11","OtherID":0,"Editor":"延庆在线"},{"ZTID":17263,"Title":"延庆历届求职招聘会情况","Image":"http://p2.pccoo.cn/bbs/20140710/2014071016324000144874s.jpg","ClassType":0,"Hit":4651,"AddTime":"2014-06-18","StartTime":"2014-12-12","EndTime":"2014-12-13","OtherID":0,"Editor":"延庆在线"},{"ZTID":14961,"Title":" 延庆传统饮食溯源、特色和攻略 ","Image":"http://p1.pccoo.cn/bar/20131218/2013121815320896s.jpg","ClassType":0,"Hit":479,"AddTime":"2013-12-18","StartTime":"2014-11-13","EndTime":"2014-11-14","OtherID":0,"Editor":"延庆在线"}]
     * Extend : null
     * Count : 10
     * GxNum : 0
     * PageNum : 1
     * retime : 0.0029297
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
         * ZTID : 21768
         * Title : 2016延庆单身男女相亲会
         * Image : http://p3.pccoo.cn/bbs/20160107/2016010708402932707430s.jpg
         * ClassType : 1
         * Hit : 9449
         * AddTime : 2016-01-07
         * StartTime : 2015-11-11
         * EndTime : 2016-04-30
         * OtherID : 0
         * Editor : yanqingccoo
         */

        private int ZTID;
        private String Title;
        private String Image;
        private int ClassType;
        private int Hit;
        private String AddTime;
        private String StartTime;
        private String EndTime;
        private int OtherID;
        private String Editor;

        public int getZTID() {
            return ZTID;
        }

        public void setZTID(int ZTID) {
            this.ZTID = ZTID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getClassType() {
            return ClassType;
        }

        public void setClassType(int ClassType) {
            this.ClassType = ClassType;
        }

        public int getHit() {
            return Hit;
        }

        public void setHit(int Hit) {
            this.Hit = Hit;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getOtherID() {
            return OtherID;
        }

        public void setOtherID(int OtherID) {
            this.OtherID = OtherID;
        }

        public String getEditor() {
            return Editor;
        }

        public void setEditor(String Editor) {
            this.Editor = Editor;
        }
    }
}
