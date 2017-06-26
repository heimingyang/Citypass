package com.example.citypass.model.bean.naonao;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/26 0026 11:56
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


public class Title_Detail_NaoNao_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":8757215,"Title":"须知胜友真良约，莫作寻常旅聚看。","Description":"须知胜友真良约，莫作寻常旅聚看。","Image":"http://r9.pccoo.cn/app_bbs/20170114/2017011420172686600635_952_960_500x300(w).jpg","ImageCount":1,"Tchild":0,"Ding":1,"Type":2,"GambitID":132,"GambitName":"想对2017的自己说","UserName":"21351958","Nick":"然后","UserFace":"http://r9.pccoo.cn/app_cover/20170114/2017011419460276222018_750_750_150x150(s).jpg","Level":2,"LevelImage":"","LastUserName":"","LastNick":"","LastTime":"01-14","CreateTime":"2017-1-14 20:17:33","MapName":"垡头街道","MapPoint":"39.860679,116.523683","IsTop":0,"Isdaka":0,"IsFire":0,"IsWatch":0,"IsColor":0,"StrColor":"","IsLike":0,"Url":"http://m.yanqing.ccoo.cn/tieba/shareinfo.aspx?id=8757215","ReplyJson1":null,"ReplyJson2":null,"NoisyType":0,"VideoData":null}]
     * Extend : null
     * Count : 1
     * GxNum : 0
     * PageNum : 1
     * retime : 0.0556662
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
         * Id : 8757215
         * Title : 须知胜友真良约，莫作寻常旅聚看。
         * Description : 须知胜友真良约，莫作寻常旅聚看。
         * Image : http://r9.pccoo.cn/app_bbs/20170114/2017011420172686600635_952_960_500x300(w).jpg
         * ImageCount : 1
         * Tchild : 0
         * Ding : 1
         * Type : 2
         * GambitID : 132
         * GambitName : 想对2017的自己说
         * UserName : 21351958
         * Nick : 然后
         * UserFace : http://r9.pccoo.cn/app_cover/20170114/2017011419460276222018_750_750_150x150(s).jpg
         * Level : 2
         * LevelImage :
         * LastUserName :
         * LastNick :
         * LastTime : 01-14
         * CreateTime : 2017-1-14 20:17:33
         * MapName : 垡头街道
         * MapPoint : 39.860679,116.523683
         * IsTop : 0
         * Isdaka : 0
         * IsFire : 0
         * IsWatch : 0
         * IsColor : 0
         * StrColor :
         * IsLike : 0
         * Url : http://m.yanqing.ccoo.cn/tieba/shareinfo.aspx?id=8757215
         * ReplyJson1 : null
         * ReplyJson2 : null
         * NoisyType : 0
         * VideoData : null
         */

        private int Id;
        private String Title;
        private String Description;
        private String Image;
        private int ImageCount;
        private int Tchild;
        private int Ding;
        private int Type;
        private int GambitID;
        private String GambitName;
        private String UserName;
        private String Nick;
        private String UserFace;
        private int Level;
        private String LevelImage;
        private String LastUserName;
        private String LastNick;
        private String LastTime;
        private String CreateTime;
        private String MapName;
        private String MapPoint;
        private int IsTop;
        private int Isdaka;
        private int IsFire;
        private int IsWatch;
        private int IsColor;
        private String StrColor;
        private int IsLike;
        private String Url;
        private Object ReplyJson1;
        private Object ReplyJson2;
        private int NoisyType;
        private Object VideoData;

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

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getImageCount() {
            return ImageCount;
        }

        public void setImageCount(int ImageCount) {
            this.ImageCount = ImageCount;
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

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public int getGambitID() {
            return GambitID;
        }

        public void setGambitID(int GambitID) {
            this.GambitID = GambitID;
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

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public String getLevelImage() {
            return LevelImage;
        }

        public void setLevelImage(String LevelImage) {
            this.LevelImage = LevelImage;
        }

        public String getLastUserName() {
            return LastUserName;
        }

        public void setLastUserName(String LastUserName) {
            this.LastUserName = LastUserName;
        }

        public String getLastNick() {
            return LastNick;
        }

        public void setLastNick(String LastNick) {
            this.LastNick = LastNick;
        }

        public String getLastTime() {
            return LastTime;
        }

        public void setLastTime(String LastTime) {
            this.LastTime = LastTime;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getMapName() {
            return MapName;
        }

        public void setMapName(String MapName) {
            this.MapName = MapName;
        }

        public String getMapPoint() {
            return MapPoint;
        }

        public void setMapPoint(String MapPoint) {
            this.MapPoint = MapPoint;
        }

        public int getIsTop() {
            return IsTop;
        }

        public void setIsTop(int IsTop) {
            this.IsTop = IsTop;
        }

        public int getIsdaka() {
            return Isdaka;
        }

        public void setIsdaka(int Isdaka) {
            this.Isdaka = Isdaka;
        }

        public int getIsFire() {
            return IsFire;
        }

        public void setIsFire(int IsFire) {
            this.IsFire = IsFire;
        }

        public int getIsWatch() {
            return IsWatch;
        }

        public void setIsWatch(int IsWatch) {
            this.IsWatch = IsWatch;
        }

        public int getIsColor() {
            return IsColor;
        }

        public void setIsColor(int IsColor) {
            this.IsColor = IsColor;
        }

        public String getStrColor() {
            return StrColor;
        }

        public void setStrColor(String StrColor) {
            this.StrColor = StrColor;
        }

        public int getIsLike() {
            return IsLike;
        }

        public void setIsLike(int IsLike) {
            this.IsLike = IsLike;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public Object getReplyJson1() {
            return ReplyJson1;
        }

        public void setReplyJson1(Object ReplyJson1) {
            this.ReplyJson1 = ReplyJson1;
        }

        public Object getReplyJson2() {
            return ReplyJson2;
        }

        public void setReplyJson2(Object ReplyJson2) {
            this.ReplyJson2 = ReplyJson2;
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
    }
}
