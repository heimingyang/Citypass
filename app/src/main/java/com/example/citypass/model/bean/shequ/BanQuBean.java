package com.example.citypass.model.bean.shequ;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/26 9:54
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class BanQuBean {
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ParentId":107,"BoardId":122119,"BoardName":"每日一菜","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":30,"ParentName":"美食俱乐部"},{"ParentId":107,"BoardId":122117,"BoardName":"农家院","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":26,"ParentName":"美食俱乐部"},{"ParentId":107,"BoardId":126453,"BoardName":"美食美客","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":23,"ParentName":"美食俱乐部"},{"ParentId":107,"BoardId":122116,"BoardName":"养生知识","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":20,"ParentName":"美食俱乐部"},{"ParentId":107,"BoardId":122118,"BoardName":"食府推荐","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":15,"ParentName":"美食俱乐部"},{"ParentId":113,"BoardId":122112,"BoardName":"亲子活动","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":22,"ParentName":"亲子俱乐部"},{"ParentId":113,"BoardId":122113,"BoardName":"育儿宝典","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":16,"ParentName":"亲子俱乐部"},{"ParentId":113,"BoardId":122110,"BoardName":"准爸准妈","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":11,"ParentName":"亲子俱乐部"},{"ParentId":106,"BoardId":122107,"BoardName":"纪实与人像","Description":"纪实和人是镜头前永远的主题，在这里有很多热衷于拍摄纪实和人像并且水平很赞的玩家，在这里你可以和他们一起交流。 ","Icon":"http://p1.pccoo.cn/bbs/20131115/2013111516465064s.jpg","FollowNum":12,"ParentName":"摄影俱乐部"},{"ParentId":106,"BoardId":122106,"BoardName":"风光与生态","Description":"以展现自然风光和生态之美为主要创作题材的原创作品(如自然景色、城市建筑摄影，花鸟虫鱼等生态摄影) ，一起从中体验感官和心灵的愉悦。 ","Icon":"http://p1.pccoo.cn/bbs/20131115/201311151642352s.jpg","FollowNum":9,"ParentName":"摄影俱乐部"},{"ParentId":106,"BoardId":122108,"BoardName":"活动与交流","Description":"谈摄影，交流后期制作，经典文章收集或转截，共同探讨，表达观点。收集网络上最精华的数码、人像、风景、单反摄影技术技巧教程，及摄影方法与知识资料，提供给摄友学习和提高摄影技术。","Icon":"http://p1.pccoo.cn/bbs/20131115/2013111516494411s.jpg","FollowNum":8,"ParentName":"摄影俱乐部"},{"ParentId":104,"BoardId":130657,"BoardName":"家居俱乐部","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":7,"ParentName":"业主俱乐部"},{"ParentId":104,"BoardId":130656,"BoardName":"鑫华美家居","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":5,"ParentName":"业主俱乐部"},{"ParentId":109,"BoardId":130655,"BoardName":"鑫华美家居","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":2,"ParentName":"家居俱乐部"},{"ParentId":114,"BoardId":122454,"BoardName":"宠物俱乐部","Description":"","Icon":"http://img.pccoo.cn/bbs/icon/bbs01.gif","FollowNum":2,"ParentName":"宠物俱乐部"}]
     * Extend : null
     * Count : 15
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0263682
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
         * ParentId : 107
         * BoardId : 122119
         * BoardName : 每日一菜
         * Description :
         * Icon : http://img.pccoo.cn/bbs/icon/bbs01.gif
         * FollowNum : 30
         * ParentName : 美食俱乐部
         */

        private int ParentId;
        private int BoardId;
        private String BoardName;
        private String Description;
        private String Icon;
        private int FollowNum;
        private String ParentName;
        private boolean showTwo;
        private boolean chax;

        public int getParentId() {
            return ParentId;
        }

        public void setParentId(int ParentId) {
            this.ParentId = ParentId;
        }

        public int getBoardId() {
            return BoardId;
        }

        public void setBoardId(int BoardId) {
            this.BoardId = BoardId;
        }

        public String getBoardName() {
            return BoardName;
        }

        public void setBoardName(String BoardName) {
            this.BoardName = BoardName;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getIcon() {
            return Icon;
        }

        public void setIcon(String Icon) {
            this.Icon = Icon;
        }

        public int getFollowNum() {
            return FollowNum;
        }

        public void setFollowNum(int FollowNum) {
            this.FollowNum = FollowNum;
        }

        public String getParentName() {
            return ParentName;
        }

        public void setParentName(String ParentName) {
            this.ParentName = ParentName;
        }

        public void setShowTwo(boolean showTwo) {
            this.showTwo = showTwo;
        }

        public boolean isChax() {
            return chax;
        }

        public boolean isShowTwo() {
            return showTwo;
        }

        public void setChax(boolean chax) {
            this.chax = chax;
        }
    }
}
