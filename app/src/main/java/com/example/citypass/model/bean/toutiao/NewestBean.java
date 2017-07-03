package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/1 16:14
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


public class NewestBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"ReplyInfo":[{"Id":9169850,"ShowTime":"2017-7-1 1:00:01","Title":"这个女人，火了！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferA8BGyYEwMSXiaiauVCY4sfiafaQbYiaL6NKjxnoD0xBW531lNGRVeqb9hiat3dz5usA6zMNtAtdpnDn7w/300?wx_fmt=png","Browse":651,"Reply":1,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-07-01","newDate":"2017年7月1日","NTime":"六月初八","WeekTime":"周六"},{"Id":9142847,"ShowTime":"2017-6-30 1:00:01","Title":"违反国家安全生产法，延庆两家公司被处罚！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferCt4Ia4MFAVOaPWCRJqKRrcWMAfWiaibLpO9eiaPqIejOE1nbLFic8Ad7YZKicLEnyUtMPnevR3WoibYC6g/300?wx_fmt=jpeg","Browse":1041,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"1","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142806,"ShowTime":"2017-6-30 1:00:01","Title":"真悬！格兰山水电梯突发故障，1个小时不见维修人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferAk7UEmeC734twY5c8lldl111duibfRgEwzs4pu3DOuZYNiaUU1onicEPHP6iayA8lCCUP3AGdxFLpTSw/300?wx_fmt=jpeg","Browse":665,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142451,"ShowTime":"2017-6-30 1:00:01","Title":"妫川广场这辆小红车真的是太霸气！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferCt4Ia4MFAVOaPWCRJqKRrcPe8GT1yxq6ZjWVKiaCfc7bG46AFnxHCqwEOHk4ibvmE29D9m3th62jxA/300?wx_fmt=png","Browse":801,"Reply":1,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"1","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142368,"ShowTime":"2017-6-30 1:00:01","Title":"北京公园管理中心公开招聘299名工作人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferAGibjFWp3HicgjBrDkibafbJPfOmRibKYeibKbqe3gaCWyzBQbPLAic1HnWlq9fN7KQb9CkWBqPj6MG1DA/300?wx_fmt=png","Browse":654,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9103999,"ShowTime":"2017-6-29 1:00:01","Title":"天天吃鸡蛋，却不知道这样做，比饭店美味100倍！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_gif/OWGfXH7Hq6mfoOZMlCC8gZ6e9T4OULWzp74wGfhG9OuvaugzQCJkddV8dibVlnlKCgMicQUtQL8hmnMHtNlbicDMw/0","Browse":846,"Reply":3,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103981,"ShowTime":"2017-6-29 1:00:01","Title":"北京地勘局公开招聘86名事业单位工作人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferCoT2Dxx9rUQaj9r1IeHMsCRiaVa7xeVFdNxaH5qWHib5jnSp1icsibUiccFt7oYZ3o3ibWc8kFvGJmT6rw/300?wx_fmt=jpeg","Browse":852,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103962,"ShowTime":"2017-6-29 1:00:01","Title":"电视上再看见这几个\u201c专家\u201d，一定不要相信了！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_gif/yl6JkZAE3S9WZHZ8DAHHWN2TRZLpiacxIjhhXic4o24eQyOE2Vl6SSHNb80dofoI5z5FXbmNrmvFPBg1uZiaU29Iw/s640","Browse":756,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103946,"ShowTime":"2017-6-29 1:00:01","Title":"我为延庆代言：耿占全，我爱我的大美延庆！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferBJjORSu3Wjbra7xYbFicZy4DyEgqkmwre3Ffiat5G28hMhQTgOgju2Cic9a0gichiafGJBQQJsibN1Qibgg/300?wx_fmt=jpeg","Browse":625,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103934,"ShowTime":"2017-6-29 1:00:01","Title":"厉害了！延庆这个人入选第六届全国道德模范北京市候选人","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/ebADjSXedkywLNQqg2y1A1IkxRGg8ytYoIibPuicOBOUx83ILeWotUEh0ibSHQeGgdZuA43x0TXR7ibBLO3PVFR9Ow/640","Browse":577,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"}],"TotalPage":125,"UpdateCount":0}
     * Extend : null
     * Count : 1241
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0957068
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
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
         * ReplyInfo : [{"Id":9169850,"ShowTime":"2017-7-1 1:00:01","Title":"这个女人，火了！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferA8BGyYEwMSXiaiauVCY4sfiafaQbYiaL6NKjxnoD0xBW531lNGRVeqb9hiat3dz5usA6zMNtAtdpnDn7w/300?wx_fmt=png","Browse":651,"Reply":1,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-07-01","newDate":"2017年7月1日","NTime":"六月初八","WeekTime":"周六"},{"Id":9142847,"ShowTime":"2017-6-30 1:00:01","Title":"违反国家安全生产法，延庆两家公司被处罚！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferCt4Ia4MFAVOaPWCRJqKRrcWMAfWiaibLpO9eiaPqIejOE1nbLFic8Ad7YZKicLEnyUtMPnevR3WoibYC6g/300?wx_fmt=jpeg","Browse":1041,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"1","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142806,"ShowTime":"2017-6-30 1:00:01","Title":"真悬！格兰山水电梯突发故障，1个小时不见维修人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferAk7UEmeC734twY5c8lldl111duibfRgEwzs4pu3DOuZYNiaUU1onicEPHP6iayA8lCCUP3AGdxFLpTSw/300?wx_fmt=jpeg","Browse":665,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142451,"ShowTime":"2017-6-30 1:00:01","Title":"妫川广场这辆小红车真的是太霸气！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferCt4Ia4MFAVOaPWCRJqKRrcPe8GT1yxq6ZjWVKiaCfc7bG46AFnxHCqwEOHk4ibvmE29D9m3th62jxA/300?wx_fmt=png","Browse":801,"Reply":1,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"1","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9142368,"ShowTime":"2017-6-30 1:00:01","Title":"北京公园管理中心公开招聘299名工作人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferAGibjFWp3HicgjBrDkibafbJPfOmRibKYeibKbqe3gaCWyzBQbPLAic1HnWlq9fN7KQb9CkWBqPj6MG1DA/300?wx_fmt=png","Browse":654,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-30","newDate":"2017年6月30日","NTime":"六月初七","WeekTime":"周五"},{"Id":9103999,"ShowTime":"2017-6-29 1:00:01","Title":"天天吃鸡蛋，却不知道这样做，比饭店美味100倍！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_gif/OWGfXH7Hq6mfoOZMlCC8gZ6e9T4OULWzp74wGfhG9OuvaugzQCJkddV8dibVlnlKCgMicQUtQL8hmnMHtNlbicDMw/0","Browse":846,"Reply":3,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103981,"ShowTime":"2017-6-29 1:00:01","Title":"北京地勘局公开招聘86名事业单位工作人员","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferCoT2Dxx9rUQaj9r1IeHMsCRiaVa7xeVFdNxaH5qWHib5jnSp1icsibUiccFt7oYZ3o3ibWc8kFvGJmT6rw/300?wx_fmt=jpeg","Browse":852,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103962,"ShowTime":"2017-6-29 1:00:01","Title":"电视上再看见这几个\u201c专家\u201d，一定不要相信了！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_gif/yl6JkZAE3S9WZHZ8DAHHWN2TRZLpiacxIjhhXic4o24eQyOE2Vl6SSHNb80dofoI5z5FXbmNrmvFPBg1uZiaU29Iw/s640","Browse":756,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103946,"ShowTime":"2017-6-29 1:00:01","Title":"我为延庆代言：耿占全，我爱我的大美延庆！","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/8wLib3F2ferBJjORSu3Wjbra7xYbFicZy4DyEgqkmwre3Ffiat5G28hMhQTgOgju2Cic9a0gichiafGJBQQJsibN1Qibgg/300?wx_fmt=jpeg","Browse":625,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"},{"Id":9103934,"ShowTime":"2017-6-29 1:00:01","Title":"厉害了！延庆这个人入选第六届全国道德模范北京市候选人","Body":"","NewsImage":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/ebADjSXedkywLNQqg2y1A1IkxRGg8ytYoIibPuicOBOUx83ILeWotUEh0ibSHQeGgdZuA43x0TXR7ibBLO3PVFR9Ow/640","Browse":577,"Reply":0,"ReplyDaKaFace":"","ReplyDaKaNick":"","SeeUserFace":"","SeeUserNick":"","SeeUserIsDaRen":"","HotFlag":"0","Flag":"2017-06-29","newDate":"2017年6月29日","NTime":"六月初六","WeekTime":"周四"}]
         * TotalPage : 125
         * UpdateCount : 0
         */

        private int TotalPage;
        private int UpdateCount;
        private List<ReplyInfoBean> ReplyInfo;

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public int getUpdateCount() {
            return UpdateCount;
        }

        public void setUpdateCount(int UpdateCount) {
            this.UpdateCount = UpdateCount;
        }

        public List<ReplyInfoBean> getReplyInfo() {
            return ReplyInfo;
        }

        public void setReplyInfo(List<ReplyInfoBean> ReplyInfo) {
            this.ReplyInfo = ReplyInfo;
        }

        public static class ReplyInfoBean {
            /**
             * Id : 9169850
             * ShowTime : 2017-7-1 1:00:01
             * Title : 这个女人，火了！
             * Body :
             * NewsImage : http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_png/8wLib3F2ferA8BGyYEwMSXiaiauVCY4sfiafaQbYiaL6NKjxnoD0xBW531lNGRVeqb9hiat3dz5usA6zMNtAtdpnDn7w/300?wx_fmt=png
             * Browse : 651
             * Reply : 1
             * ReplyDaKaFace :
             * ReplyDaKaNick :
             * SeeUserFace :
             * SeeUserNick :
             * SeeUserIsDaRen :
             * HotFlag : 0
             * Flag : 2017-07-01
             * newDate : 2017年7月1日
             * NTime : 六月初八
             * WeekTime : 周六
             */

            private int Id;
            private String ShowTime;
            private String Title;
            private String Body;
            private String NewsImage;
            private int Browse;
            private int Reply;
            private String ReplyDaKaFace;
            private String ReplyDaKaNick;
            private String SeeUserFace;
            private String SeeUserNick;
            private String SeeUserIsDaRen;
            private String HotFlag;
            private String Flag;
            private String newDate;
            private String NTime;
            private String WeekTime;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getShowTime() {
                return ShowTime;
            }

            public void setShowTime(String ShowTime) {
                this.ShowTime = ShowTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getBody() {
                return Body;
            }

            public void setBody(String Body) {
                this.Body = Body;
            }

            public String getNewsImage() {
                return NewsImage;
            }

            public void setNewsImage(String NewsImage) {
                this.NewsImage = NewsImage;
            }

            public int getBrowse() {
                return Browse;
            }

            public void setBrowse(int Browse) {
                this.Browse = Browse;
            }

            public int getReply() {
                return Reply;
            }

            public void setReply(int Reply) {
                this.Reply = Reply;
            }

            public String getReplyDaKaFace() {
                return ReplyDaKaFace;
            }

            public void setReplyDaKaFace(String ReplyDaKaFace) {
                this.ReplyDaKaFace = ReplyDaKaFace;
            }

            public String getReplyDaKaNick() {
                return ReplyDaKaNick;
            }

            public void setReplyDaKaNick(String ReplyDaKaNick) {
                this.ReplyDaKaNick = ReplyDaKaNick;
            }

            public String getSeeUserFace() {
                return SeeUserFace;
            }

            public void setSeeUserFace(String SeeUserFace) {
                this.SeeUserFace = SeeUserFace;
            }

            public String getSeeUserNick() {
                return SeeUserNick;
            }

            public void setSeeUserNick(String SeeUserNick) {
                this.SeeUserNick = SeeUserNick;
            }

            public String getSeeUserIsDaRen() {
                return SeeUserIsDaRen;
            }

            public void setSeeUserIsDaRen(String SeeUserIsDaRen) {
                this.SeeUserIsDaRen = SeeUserIsDaRen;
            }

            public String getHotFlag() {
                return HotFlag;
            }

            public void setHotFlag(String HotFlag) {
                this.HotFlag = HotFlag;
            }

            public String getFlag() {
                return Flag;
            }

            public void setFlag(String Flag) {
                this.Flag = Flag;
            }

            public String getNewDate() {
                return newDate;
            }

            public void setNewDate(String newDate) {
                this.newDate = newDate;
            }

            public String getNTime() {
                return NTime;
            }

            public void setNTime(String NTime) {
                this.NTime = NTime;
            }

            public String getWeekTime() {
                return WeekTime;
            }

            public void setWeekTime(String WeekTime) {
                this.WeekTime = WeekTime;
            }
        }
    }
}
