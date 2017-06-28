package com.example.citypass.model.bean.information;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述: 获取到的个人信息
 * 创建人: 马杰
 * 创建时间: 2017/6/21 16:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Information {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * Id : 31042672
     * SiteID : 2422
     * SiteName : 延庆在线
     * SiteURL : m.yanqing.ccoo.cn
     * SiteSqURL : m.yanqing.ccoo.cn
     * SiteAreaName : 延庆
     * Initial : yqzx
     * UserName : sid193108730110051
     * Nick : 蠢均
     * UserFace : http://p9.pccoo.cn/app_avatar/20170620/2017062019312400988846_390_390.jpg
     * Sex : 男
     * Name : 未设置
     * Birthday : 1998-08-29
     * XingZuo : 19岁 处女座
     * Info : 写点什么
     * Mobile : 18501151714
     * Tel1 :
     * Tel : 18501151714
     * Email :
     * TrueEmail :
     * QQ : 仅关注好友可见
     * WeiXin : 仅关注好友可见
     * LifeAddr : 北京吉利大学
     * Marry : 未知
     * Job : 未设置
     * Position :
     * PositionName :
     * FrendNum : 0
     * FansNum : 0
     * Coin : 0
     * Level : 1
     * Integral : 0
     * Image :
     * HonorName : 新居民
     * TaskCount : 0
     * IntegralRank : 暂无排名
     * MedalCount : 0
     * MedalImags :
     * IsCity : 1
     * TState : {"code":1000,"rate":0}
     * BBID : 0
     * IsFirstPub : 1
     * MsgCount : 0
     * MsgAlert : {"title":"","headimg":"","firstid":0,"secondid":0}
     * IsQQBind : 0
     * IsWXBind : 0
     * IsWBBind : 0
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"Id":"31042672","SiteID":2422,"SiteName":"延庆在线","SiteURL":"m.yanqing.ccoo.cn","SiteSqURL":"m.yanqing.ccoo.cn","SiteAreaName":"延庆","Initial":"yqzx","UserName":"sid193108730110051","Nick":"蠢均","UserFace":"http://p9.pccoo.cn/app_avatar/20170620/2017062019312400988846_390_390.jpg","Sex":"男","Name":"未设置","Birthday":"1998-08-29","XingZuo":"19岁 处女座","Info":"写点什么","Mobile":"18501151714","Tel1":"","Tel":"18501151714","Email":"","TrueEmail":"","QQ":"仅关注好友可见","WeiXin":"仅关注好友可见","LifeAddr":"北京吉利大学","Marry":"未知","Job":"未设置","Position":"","PositionName":"","FrendNum":0,"FansNum":0,"Coin":0,"Level":1,"Integral":0,"Image":"","HonorName":"新居民","TaskCount":0,"IntegralRank":"暂无排名","MedalCount":0,"MedalImags":"","IsCity":1,"TState":{"code":1000,"rate":0},"BBID":0,"IsFirstPub":1,"MsgCount":0,"MsgAlert":{"title":"","headimg":"","firstid":0,"secondid":0},"IsQQBind":0,"IsWXBind":0,"IsWBBind":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 1.0546875
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
        private String Id;
        private int SiteID;
        private String SiteName;
        private String SiteURL;
        private String SiteSqURL;
        private String SiteAreaName;
        private String Initial;
        private String UserName;
        private String Nick;
        private String UserFace;
        private String Sex;
        private String Name;
        private String Birthday;
        private String XingZuo;
        private String Info;
        private String Mobile;
        private String Tel1;
        private String Tel;
        private String Email;
        private String TrueEmail;
        private String QQ;
        private String WeiXin;
        private String LifeAddr;
        private String Marry;
        private String Job;
        private String Position;
        private String PositionName;
        private int FrendNum;
        private int FansNum;
        private int Coin;
        private int Level;
        private int Integral;
        private String Image;
        private String HonorName;
        private int TaskCount;
        private String IntegralRank;
        private int MedalCount;
        private String MedalImags;
        private int IsCity;
        /**
         * code : 1000
         * rate : 0
         */

        private TStateBean TState;
        private int BBID;
        private int IsFirstPub;
        private int MsgCount;
        /**
         * title :
         * headimg :
         * firstid : 0
         * secondid : 0
         */

        private MsgAlertBean MsgAlert;
        private int IsQQBind;
        private int IsWXBind;
        private int IsWBBind;


        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public int getSiteID() {
            return SiteID;
        }

        public void setSiteID(int SiteID) {
            this.SiteID = SiteID;
        }

        public String getSiteName() {
            return SiteName;
        }

        public void setSiteName(String SiteName) {
            this.SiteName = SiteName;
        }

        public String getSiteURL() {
            return SiteURL;
        }

        public void setSiteURL(String SiteURL) {
            this.SiteURL = SiteURL;
        }

        public String getSiteSqURL() {
            return SiteSqURL;
        }

        public void setSiteSqURL(String SiteSqURL) {
            this.SiteSqURL = SiteSqURL;
        }

        public String getSiteAreaName() {
            return SiteAreaName;
        }

        public void setSiteAreaName(String SiteAreaName) {
            this.SiteAreaName = SiteAreaName;
        }

        public String getInitial() {
            return Initial;
        }

        public void setInitial(String Initial) {
            this.Initial = Initial;
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

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String Birthday) {
            this.Birthday = Birthday;
        }

        public String getXingZuo() {
            return XingZuo;
        }

        public void setXingZuo(String XingZuo) {
            this.XingZuo = XingZuo;
        }

        public String getInfo() {
            return Info;
        }

        public void setInfo(String Info) {
            this.Info = Info;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getTel1() {
            return Tel1;
        }

        public void setTel1(String Tel1) {
            this.Tel1 = Tel1;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getTrueEmail() {
            return TrueEmail;
        }

        public void setTrueEmail(String TrueEmail) {
            this.TrueEmail = TrueEmail;
        }

        public String getQQ() {
            return QQ;
        }

        public void setQQ(String QQ) {
            this.QQ = QQ;
        }

        public String getWeiXin() {
            return WeiXin;
        }

        public void setWeiXin(String WeiXin) {
            this.WeiXin = WeiXin;
        }

        public String getLifeAddr() {
            return LifeAddr;
        }

        public void setLifeAddr(String LifeAddr) {
            this.LifeAddr = LifeAddr;
        }

        public String getMarry() {
            return Marry;
        }

        public void setMarry(String Marry) {
            this.Marry = Marry;
        }

        public String getJob() {
            return Job;
        }

        public void setJob(String Job) {
            this.Job = Job;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String Position) {
            this.Position = Position;
        }

        public String getPositionName() {
            return PositionName;
        }

        public void setPositionName(String PositionName) {
            this.PositionName = PositionName;
        }

        public int getFrendNum() {
            return FrendNum;
        }

        public void setFrendNum(int FrendNum) {
            this.FrendNum = FrendNum;
        }

        public int getFansNum() {
            return FansNum;
        }

        public void setFansNum(int FansNum) {
            this.FansNum = FansNum;
        }

        public int getCoin() {
            return Coin;
        }

        public void setCoin(int Coin) {
            this.Coin = Coin;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public int getIntegral() {
            return Integral;
        }

        public void setIntegral(int Integral) {
            this.Integral = Integral;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public String getHonorName() {
            return HonorName;
        }

        public void setHonorName(String HonorName) {
            this.HonorName = HonorName;
        }

        public int getTaskCount() {
            return TaskCount;
        }

        public void setTaskCount(int TaskCount) {
            this.TaskCount = TaskCount;
        }

        public String getIntegralRank() {
            return IntegralRank;
        }

        public void setIntegralRank(String IntegralRank) {
            this.IntegralRank = IntegralRank;
        }

        public int getMedalCount() {
            return MedalCount;
        }

        public void setMedalCount(int MedalCount) {
            this.MedalCount = MedalCount;
        }

        public String getMedalImags() {
            return MedalImags;
        }

        public void setMedalImags(String MedalImags) {
            this.MedalImags = MedalImags;
        }

        public int getIsCity() {
            return IsCity;
        }

        public void setIsCity(int IsCity) {
            this.IsCity = IsCity;
        }

        public TStateBean getTState() {
            return TState;
        }

        public void setTState(TStateBean TState) {
            this.TState = TState;
        }

        public int getBBID() {
            return BBID;
        }

        public void setBBID(int BBID) {
            this.BBID = BBID;
        }

        public int getIsFirstPub() {
            return IsFirstPub;
        }

        public void setIsFirstPub(int IsFirstPub) {
            this.IsFirstPub = IsFirstPub;
        }

        public int getMsgCount() {
            return MsgCount;
        }

        public void setMsgCount(int MsgCount) {
            this.MsgCount = MsgCount;
        }

        public MsgAlertBean getMsgAlert() {
            return MsgAlert;
        }

        public void setMsgAlert(MsgAlertBean MsgAlert) {
            this.MsgAlert = MsgAlert;
        }

        public int getIsQQBind() {
            return IsQQBind;
        }

        public void setIsQQBind(int IsQQBind) {
            this.IsQQBind = IsQQBind;
        }

        public int getIsWXBind() {
            return IsWXBind;
        }

        public void setIsWXBind(int IsWXBind) {
            this.IsWXBind = IsWXBind;
        }

        public int getIsWBBind() {
            return IsWBBind;
        }

        public void setIsWBBind(int IsWBBind) {
            this.IsWBBind = IsWBBind;
        }

        public static class TStateBean {
            private int code;
            private int rate;


            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public int getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
            }
        }

        public static class MsgAlertBean {
            private String title;
            private String headimg;
            private int firstid;
            private int secondid;


            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public int getFirstid() {
                return firstid;
            }

            public void setFirstid(int firstid) {
                this.firstid = firstid;
            }

            public int getSecondid() {
                return secondid;
            }

            public void setSecondid(int secondid) {
                this.secondid = secondid;
            }
        }
    }
}
