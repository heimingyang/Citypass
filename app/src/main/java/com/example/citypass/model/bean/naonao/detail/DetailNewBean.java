package com.example.citypass.model.bean.naonao.detail;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 23:57
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailNewBean {


    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"ID":110313,"Images":[],"Body":"你烦不烦啊，二狗子","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30937884,"UserName":"QQID433EBDD44443","Nick":"bug","Userface":"http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100","Level":3,"LImage":"","Lou":"沙发","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-06-28 07:55:38","AtUser":"","Tchild":1,"ClildReplyList":[{"ID":110318,"Body":"刷评论狗","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30957299,"UserName":"QQID83FE9F965077","Nick":"😇二💔运😈","Userface":"http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg","Lou":1,"CreateTime":"2017-06-28 08:08:42","AtUser":""}]},{"ID":110314,"Images":[],"Body":"成天刷屏，生怕没有存在感，二哈","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30937884,"UserName":"QQID433EBDD44443","Nick":"bug","Userface":"http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100","Level":3,"LImage":"","Lou":"板凳","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-06-28 07:56:16","AtUser":"","Tchild":1,"ClildReplyList":[{"ID":110317,"Body":"滚","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30957299,"UserName":"QQID83FE9F965077","Nick":"😇二💔运😈","Userface":"http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg","Lou":1,"CreateTime":"2017-06-28 08:08:25","AtUser":""}]},{"ID":110315,"Images":[],"Body":"😂😂😂😂[sys/2.gif]","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30937884,"UserName":"QQID433EBDD44443","Nick":"bug","Userface":"http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100","Level":3,"LImage":"","Lou":"马扎","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-06-28 07:56:35","AtUser":"","Tchild":1,"ClildReplyList":[{"ID":110319,"Body":"狗带","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30957299,"UserName":"QQID83FE9F965077","Nick":"😇二💔运😈","Userface":"http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg","Lou":1,"CreateTime":"2017-06-28 08:09:10","AtUser":""}]},{"ID":110316,"Images":[],"Body":"","Audio":"http://p9.pccoo.cn/audio/20170628/2017062807553904858964.aac","AudioTime":"6","Expression":"","Ding":"0","UserID":30937884,"UserName":"QQID433EBDD44443","Nick":"bug","Userface":"http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100","Level":3,"LImage":"","Lou":"4楼","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-06-28 07:57:00","AtUser":"","Tchild":0,"ClildReplyList":null},{"ID":110370,"Images":[],"Body":"存在感呢","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30940828,"UserName":"sid111337783757219","Nick":"阿东","Userface":"http://r9.pccoo.cn/app_avatar/20170619/2017061911134798705506_818_818_150x150(s).jpg","Level":5,"LImage":"http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png","Lou":"5楼","IsDaKa":1,"MapName":"三里屯SOHO","CreateTime":"2017-06-28 09:52:28","AtUser":"","Tchild":0,"ClildReplyList":null}]
     * Extend : null
     * Count : 5
     * GxNum : 0
     * PageNum : 0
     * retime : 1.8447265
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
         * ID : 110313
         * Images : []
         * Body : 你烦不烦啊，二狗子
         * Audio :
         * AudioTime :
         * Expression :
         * Ding : 0
         * UserID : 30937884
         * UserName : QQID433EBDD44443
         * Nick : bug
         * Userface : http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100
         * Level : 3
         * LImage :
         * Lou : 沙发
         * IsDaKa : 0
         * MapName : 北京吉利大学
         * CreateTime : 2017-06-28 07:55:38
         * AtUser :
         * Tchild : 1
         * ClildReplyList : [{"ID":110318,"Body":"刷评论狗","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30957299,"UserName":"QQID83FE9F965077","Nick":"😇二💔运😈","Userface":"http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg","Lou":1,"CreateTime":"2017-06-28 08:08:42","AtUser":""}]
         */

        private int ID;
        private String Body;
        private String Audio;
        private String AudioTime;
        private String Expression;
        private String Ding;
        private int UserID;
        private String UserName;
        private String Nick;
        private String Userface;
        private int Level;
        private String LImage;
        private String Lou;
        private int IsDaKa;
        private String MapName;
        private String CreateTime;
        private String AtUser;
        private int Tchild;
        private List<?> Images;
        private List<ClildReplyListBean> ClildReplyList;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getBody() {
            return Body;
        }

        public void setBody(String Body) {
            this.Body = Body;
        }

        public String getAudio() {
            return Audio;
        }

        public void setAudio(String Audio) {
            this.Audio = Audio;
        }

        public String getAudioTime() {
            return AudioTime;
        }

        public void setAudioTime(String AudioTime) {
            this.AudioTime = AudioTime;
        }

        public String getExpression() {
            return Expression;
        }

        public void setExpression(String Expression) {
            this.Expression = Expression;
        }

        public String getDing() {
            return Ding;
        }

        public void setDing(String Ding) {
            this.Ding = Ding;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getNick() {
            return Nick;
        }

        public void setNick(String Nick) {
            this.Nick = Nick;
        }

        public String getUserface() {
            return Userface;
        }

        public void setUserface(String Userface) {
            this.Userface = Userface;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public String getLImage() {
            return LImage;
        }

        public void setLImage(String LImage) {
            this.LImage = LImage;
        }

        public String getLou() {
            return Lou;
        }

        public void setLou(String Lou) {
            this.Lou = Lou;
        }

        public int getIsDaKa() {
            return IsDaKa;
        }

        public void setIsDaKa(int IsDaKa) {
            this.IsDaKa = IsDaKa;
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

        public String getAtUser() {
            return AtUser;
        }

        public void setAtUser(String AtUser) {
            this.AtUser = AtUser;
        }

        public int getTchild() {
            return Tchild;
        }

        public void setTchild(int Tchild) {
            this.Tchild = Tchild;
        }

        public List<?> getImages() {
            return Images;
        }

        public void setImages(List<?> Images) {
            this.Images = Images;
        }

        public List<ClildReplyListBean> getClildReplyList() {
            return ClildReplyList;
        }

        public void setClildReplyList(List<ClildReplyListBean> ClildReplyList) {
            this.ClildReplyList = ClildReplyList;
        }

        public static class ClildReplyListBean {
            /**
             * ID : 110318
             * Body : 刷评论狗
             * Audio :
             * AudioTime :
             * Expression :
             * Ding : 0
             * UserID : 30957299
             * UserName : QQID83FE9F965077
             * Nick : 😇二💔运😈
             * Userface : http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg
             * Lou : 1
             * CreateTime : 2017-06-28 08:08:42
             * AtUser :
             */

            private int ID;
            private String Body;
            private String Audio;
            private String AudioTime;
            private String Expression;
            private String Ding;
            private int UserID;
            private String UserName;
            private String Nick;
            private String Userface;
            private int Lou;
            private String CreateTime;
            private String AtUser;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getBody() {
                return Body;
            }

            public void setBody(String Body) {
                this.Body = Body;
            }

            public String getAudio() {
                return Audio;
            }

            public void setAudio(String Audio) {
                this.Audio = Audio;
            }

            public String getAudioTime() {
                return AudioTime;
            }

            public void setAudioTime(String AudioTime) {
                this.AudioTime = AudioTime;
            }

            public String getExpression() {
                return Expression;
            }

            public void setExpression(String Expression) {
                this.Expression = Expression;
            }

            public String getDing() {
                return Ding;
            }

            public void setDing(String Ding) {
                this.Ding = Ding;
            }

            public int getUserID() {
                return UserID;
            }

            public void setUserID(int UserID) {
                this.UserID = UserID;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getNick() {
                return Nick;
            }

            public void setNick(String Nick) {
                this.Nick = Nick;
            }

            public String getUserface() {
                return Userface;
            }

            public void setUserface(String Userface) {
                this.Userface = Userface;
            }

            public int getLou() {
                return Lou;
            }

            public void setLou(int Lou) {
                this.Lou = Lou;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getAtUser() {
                return AtUser;
            }

            public void setAtUser(String AtUser) {
                this.AtUser = AtUser;
            }
        }
    }
}
