package com.example.citypass.model.bean.naonao.detail;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/29 16:40
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailMainBean {
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"Id":8774836,"Title":"七张图","Description":"七张图","Images":["http://r9.pccoo.cn/app_bbs/20170627/2017062719451386655491_198_197_400x300(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451465360179_200_202_300x225(s).jpeg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451540993274_200_200_300x225(s).jpeg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451572996246_188_174_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451668682237_400_396_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719454256351819_800_800_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719454291756199_600_625_300x225(s).png"],"Audio":"","AudioTime":"","Hit":389,"Tchild":8,"Ding":3017,"DingName":"??二??运??,5555,null,俊爷就是帅,俊爷就是帅","Type":2,"GambitId":0,"GambitName":"","UserName":"QQID83FE9F965077","UserID":"30957299","Nick":"😇二💔运😈","UserFace":"http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg","Sex":"男","Level":7,"LImage":"","CreateTime":"2017-06-27 19:44:48","Body":"七张图[img][img][img][img][img][img][img]","Expression":"","AtUser":"","MapName":"北京吉利大学","IsTop":0,"IsLike":0,"RewardCount":0,"DakaNum":1,"ReplyCount":5,"NoisyType":0,"VideoData":null}
     * Extend : {"reShare":{"title":"来自 😇二💔运😈 的延庆在线闹闹话题","memo":"七张图","image":"http://r9.pccoo.cn/app_bbs/20170627/2017062719451386655491_198_197_400x300(s).jpg","url":"http://m.yanqing.ccoo.cn/tieba/shareinfo.aspx?id=8774836"},"IsMaster":0,"IsFriend":0}
     * Count : 1
     * GxNum : 0
     * PageNum : 0
     * retime : 0.1660156
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
         * Id : 8774836
         * Title : 七张图
         * Description : 七张图
         * Images : ["http://r9.pccoo.cn/app_bbs/20170627/2017062719451386655491_198_197_400x300(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451465360179_200_202_300x225(s).jpeg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451540993274_200_200_300x225(s).jpeg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451572996246_188_174_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719451668682237_400_396_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719454256351819_800_800_300x225(s).jpg","http://r9.pccoo.cn/app_bbs/20170627/2017062719454291756199_600_625_300x225(s).png"]
         * Audio :
         * AudioTime :
         * Hit : 389
         * Tchild : 8
         * Ding : 3017
         * DingName : ??二??运??,5555,null,俊爷就是帅,俊爷就是帅
         * Type : 2
         * GambitId : 0
         * GambitName :
         * UserName : QQID83FE9F965077
         * UserID : 30957299
         * Nick : 😇二💔运😈
         * UserFace : http://r9.pccoo.cn/app_avatar/20170622/2017062220362729822907_520_520_150x150(s).jpg
         * Sex : 男
         * Level : 7
         * LImage :
         * CreateTime : 2017-06-27 19:44:48
         * Body : 七张图[img][img][img][img][img][img][img]
         * Expression :
         * AtUser :
         * MapName : 北京吉利大学
         * IsTop : 0
         * IsLike : 0
         * RewardCount : 0
         * DakaNum : 1
         * ReplyCount : 5
         * NoisyType : 0
         * VideoData : null
         */

        private int Id;
        private String Title;
        private String Description;
        private String Audio;
        private String AudioTime;
        private int Hit;
        private int Tchild;
        private int Ding;
        private String DingName;
        private int Type;
        private int GambitId;
        private String GambitName;
        private String UserName;
        private String UserID;
        private String Nick;
        private String UserFace;
        private String Sex;
        private int Level;
        private String LImage;
        private String CreateTime;
        private String Body;
        private String Expression;
        private String AtUser;
        private String MapName;
        private int IsTop;
        private int IsLike;
        private int RewardCount;
        private int DakaNum;
        private int ReplyCount;
        private int NoisyType;
        private Object VideoData;
        private List<String> Images;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
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

        public int getHit() {
            return Hit;
        }

        public void setHit(int Hit) {
            this.Hit = Hit;
        }

        public int getTchild() {
            return Tchild;
        }

        public void setTchild(int Tchild) {
            this.Tchild = Tchild;
        }

        public int getDing() {
            return Ding;
        }

        public void setDing(int Ding) {
            this.Ding = Ding;
        }

        public String getDingName() {
            return DingName;
        }

        public void setDingName(String DingName) {
            this.DingName = DingName;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public int getGambitId() {
            return GambitId;
        }

        public void setGambitId(int GambitId) {
            this.GambitId = GambitId;
        }

        public String getGambitName() {
            return GambitName;
        }

        public void setGambitName(String GambitName) {
            this.GambitName = GambitName;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getNick() {
            return Nick;
        }

        public void setNick(String Nick) {
            this.Nick = Nick;
        }

        public String getUserFace() {
            return UserFace;
        }

        public void setUserFace(String UserFace) {
            this.UserFace = UserFace;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getBody() {
            return Body;
        }

        public void setBody(String Body) {
            this.Body = Body;
        }

        public String getExpression() {
            return Expression;
        }

        public void setExpression(String Expression) {
            this.Expression = Expression;
        }

        public String getAtUser() {
            return AtUser;
        }

        public void setAtUser(String AtUser) {
            this.AtUser = AtUser;
        }

        public String getMapName() {
            return MapName;
        }

        public void setMapName(String MapName) {
            this.MapName = MapName;
        }

        public int getIsTop() {
            return IsTop;
        }

        public void setIsTop(int IsTop) {
            this.IsTop = IsTop;
        }

        public int getIsLike() {
            return IsLike;
        }

        public void setIsLike(int IsLike) {
            this.IsLike = IsLike;
        }

        public int getRewardCount() {
            return RewardCount;
        }

        public void setRewardCount(int RewardCount) {
            this.RewardCount = RewardCount;
        }

        public int getDakaNum() {
            return DakaNum;
        }

        public void setDakaNum(int DakaNum) {
            this.DakaNum = DakaNum;
        }

        public int getReplyCount() {
            return ReplyCount;
        }

        public void setReplyCount(int ReplyCount) {
            this.ReplyCount = ReplyCount;
        }

        public int getNoisyType() {
            return NoisyType;
        }

        public void setNoisyType(int NoisyType) {
            this.NoisyType = NoisyType;
        }

        public Object getVideoData() {
            return VideoData;
        }

        public void setVideoData(Object VideoData) {
            this.VideoData = VideoData;
        }

        public List<String> getImages() {
            return Images;
        }

        public void setImages(List<String> Images) {
            this.Images = Images;
        }
    }

    public static class ExtendBean {
        /**
         * reShare : {"title":"来自 😇二💔运😈 的延庆在线闹闹话题","memo":"七张图","image":"http://r9.pccoo.cn/app_bbs/20170627/2017062719451386655491_198_197_400x300(s).jpg","url":"http://m.yanqing.ccoo.cn/tieba/shareinfo.aspx?id=8774836"}
         * IsMaster : 0
         * IsFriend : 0
         */

        private ReShareBean reShare;
        private int IsMaster;
        private int IsFriend;

        public ReShareBean getReShare() {
            return reShare;
        }

        public void setReShare(ReShareBean reShare) {
            this.reShare = reShare;
        }

        public int getIsMaster() {
            return IsMaster;
        }

        public void setIsMaster(int IsMaster) {
            this.IsMaster = IsMaster;
        }

        public int getIsFriend() {
            return IsFriend;
        }

        public void setIsFriend(int IsFriend) {
            this.IsFriend = IsFriend;
        }

        public static class ReShareBean {
            /**
             * title : 来自 😇二💔运😈 的延庆在线闹闹话题
             * memo : 七张图
             * image : http://r9.pccoo.cn/app_bbs/20170627/2017062719451386655491_198_197_400x300(s).jpg
             * url : http://m.yanqing.ccoo.cn/tieba/shareinfo.aspx?id=8774836
             */

            private String title;
            private String memo;
            private String image;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
