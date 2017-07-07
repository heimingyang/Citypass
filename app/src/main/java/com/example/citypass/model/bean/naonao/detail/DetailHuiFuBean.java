package com.example.citypass.model.bean.naonao.detail;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/4 15:41
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailHuiFuBean {


    /**
     * MessageList : {"code":1000,"message":"回帖成功~"}
     * ServerInfo : {"IsDk":0,"ReplyList":[{"ID":111347,"Images":[],"Body":"回复啊","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30938715,"UserName":"sid105524270160091","Nick":"超哥在昌平","Userface":"http://r9.pccoo.cn/app_avatar/20170619/2017061910545246831007_780_780_150x150(s).jpg","Level":1,"LImage":"","Lou":"28楼","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-07-04 17:20:06","AtUser":"","Tchild":0}]}
     * Extend : {"reTask":[{"id":75471,"title":"回复与评论","property":0,"integral":15,"coin":0,"code":1006}],"reMsg":""}
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.3476562
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
         * message : 回帖成功~
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
         * IsDk : 0
         * ReplyList : [{"ID":111347,"Images":[],"Body":"回复啊","Audio":"","AudioTime":"","Expression":"","Ding":"0","UserID":30938715,"UserName":"sid105524270160091","Nick":"超哥在昌平","Userface":"http://r9.pccoo.cn/app_avatar/20170619/2017061910545246831007_780_780_150x150(s).jpg","Level":1,"LImage":"","Lou":"28楼","IsDaKa":0,"MapName":"北京吉利大学","CreateTime":"2017-07-04 17:20:06","AtUser":"","Tchild":0}]
         */

        private int IsDk;
        private List<ReplyListBean> ReplyList;

        public int getIsDk() {
            return IsDk;
        }

        public void setIsDk(int IsDk) {
            this.IsDk = IsDk;
        }

        public List<ReplyListBean> getReplyList() {
            return ReplyList;
        }

        public void setReplyList(List<ReplyListBean> ReplyList) {
            this.ReplyList = ReplyList;
        }

        public static class ReplyListBean {
            /**
             * ID : 111347
             * Images : []
             * Body : 回复啊
             * Audio :
             * AudioTime :
             * Expression :
             * Ding : 0
             * UserID : 30938715
             * UserName : sid105524270160091
             * Nick : 超哥在昌平
             * Userface : http://r9.pccoo.cn/app_avatar/20170619/2017061910545246831007_780_780_150x150(s).jpg
             * Level : 1
             * LImage :
             * Lou : 28楼
             * IsDaKa : 0
             * MapName : 北京吉利大学
             * CreateTime : 2017-07-04 17:20:06
             * AtUser :
             * Tchild : 0
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
        }
    }

    public static class ExtendBean {
        /**
         * reTask : [{"id":75471,"title":"回复与评论","property":0,"integral":15,"coin":0,"code":1006}]
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
             * id : 75471
             * title : 回复与评论
             * property : 0
             * integral : 15
             * coin : 0
             * code : 1006
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
