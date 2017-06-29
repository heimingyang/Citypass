package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/29 14:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Shop {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * CommodityList : {"Content":[{"Id":935449,"Title":"投票卡","Images":"http://r9.pccoo.cn/jfshop/20161122/2016112213315756734217_250_250_300x225(s).png","ShowImages":"http://r9.pccoo.cn/jfshop/20161123/2016112310051851746126_400_300_300x225(s).jpg","SCoin":50,"VCoin":120,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":131,"SType":1,"STime":""},{"Id":901150,"Title":"主题变色卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817330429443897s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817330965466009s.jpg","SCoin":10,"VCoin":100,"Money":0,"ShowSum":0,"RealSum":1100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":19,"SType":1,"STime":""},{"Id":900327,"Title":"值得一看卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817322411609205s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817323080546023s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":23,"SType":1,"STime":""},{"Id":898811,"Title":"帖子置顶卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817161142690048s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817210873204710s.jpg","SCoin":50,"VCoin":80,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":26,"SType":1,"STime":""},{"Id":892689,"Title":"飞吻","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811413750360964s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111075699982779s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":25,"SType":1,"STime":""},{"Id":892066,"Title":"香水","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811420664364491s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111064528364879s.jpg","SCoin":80,"VCoin":150,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":27,"SType":1,"STime":""},{"Id":890781,"Title":"手机","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811425465997810s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111061434160494s.jpg","SCoin":100,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":28,"SType":1,"STime":""},{"Id":890409,"Title":"钻戒","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811431287320250s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111054679324829s.jpg","SCoin":180,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":29,"SType":1,"STime":""},{"Id":888998,"Title":"包包","Images":"http://p3.pccoo.cn/weixin/20151221/2015122117380697748354s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111051650867241s.jpg","SCoin":150,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":30,"SType":1,"STime":""},{"Id":888372,"Title":"跑车","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811433267958957s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111043826928542s.jpg","SCoin":1000,"VCoin":1500,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":31,"SType":1,"STime":""}],"Count":40}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CommodityList":{"Content":[{"Id":935449,"Title":"投票卡","Images":"http://r9.pccoo.cn/jfshop/20161122/2016112213315756734217_250_250_300x225(s).png","ShowImages":"http://r9.pccoo.cn/jfshop/20161123/2016112310051851746126_400_300_300x225(s).jpg","SCoin":50,"VCoin":120,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":131,"SType":1,"STime":""},{"Id":901150,"Title":"主题变色卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817330429443897s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817330965466009s.jpg","SCoin":10,"VCoin":100,"Money":0,"ShowSum":0,"RealSum":1100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":19,"SType":1,"STime":""},{"Id":900327,"Title":"值得一看卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817322411609205s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817323080546023s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":23,"SType":1,"STime":""},{"Id":898811,"Title":"帖子置顶卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817161142690048s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817210873204710s.jpg","SCoin":50,"VCoin":80,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":26,"SType":1,"STime":""},{"Id":892689,"Title":"飞吻","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811413750360964s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111075699982779s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":25,"SType":1,"STime":""},{"Id":892066,"Title":"香水","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811420664364491s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111064528364879s.jpg","SCoin":80,"VCoin":150,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":27,"SType":1,"STime":""},{"Id":890781,"Title":"手机","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811425465997810s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111061434160494s.jpg","SCoin":100,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":28,"SType":1,"STime":""},{"Id":890409,"Title":"钻戒","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811431287320250s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111054679324829s.jpg","SCoin":180,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":29,"SType":1,"STime":""},{"Id":888998,"Title":"包包","Images":"http://p3.pccoo.cn/weixin/20151221/2015122117380697748354s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111051650867241s.jpg","SCoin":150,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":30,"SType":1,"STime":""},{"Id":888372,"Title":"跑车","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811433267958957s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111043826928542s.jpg","SCoin":1000,"VCoin":1500,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":31,"SType":1,"STime":""}],"Count":40}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0214844
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
         * Content : [{"Id":935449,"Title":"投票卡","Images":"http://r9.pccoo.cn/jfshop/20161122/2016112213315756734217_250_250_300x225(s).png","ShowImages":"http://r9.pccoo.cn/jfshop/20161123/2016112310051851746126_400_300_300x225(s).jpg","SCoin":50,"VCoin":120,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":131,"SType":1,"STime":""},{"Id":901150,"Title":"主题变色卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817330429443897s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817330965466009s.jpg","SCoin":10,"VCoin":100,"Money":0,"ShowSum":0,"RealSum":1100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":19,"SType":1,"STime":""},{"Id":900327,"Title":"值得一看卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817322411609205s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817323080546023s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":23,"SType":1,"STime":""},{"Id":898811,"Title":"帖子置顶卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817161142690048s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160408/2016040817210873204710s.jpg","SCoin":50,"VCoin":80,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":26,"SType":1,"STime":""},{"Id":892689,"Title":"飞吻","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811413750360964s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111075699982779s.jpg","SCoin":20,"VCoin":50,"Money":0,"ShowSum":0,"RealSum":1000,"BuySum":0,"CType":1,"CTypeName":"道具","VID":25,"SType":1,"STime":""},{"Id":892066,"Title":"香水","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811420664364491s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111064528364879s.jpg","SCoin":80,"VCoin":150,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":27,"SType":1,"STime":""},{"Id":890781,"Title":"手机","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811425465997810s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111061434160494s.jpg","SCoin":100,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":28,"SType":1,"STime":""},{"Id":890409,"Title":"钻戒","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811431287320250s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111054679324829s.jpg","SCoin":180,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":29,"SType":1,"STime":""},{"Id":888998,"Title":"包包","Images":"http://p3.pccoo.cn/weixin/20151221/2015122117380697748354s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111051650867241s.jpg","SCoin":150,"VCoin":199,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":30,"SType":1,"STime":""},{"Id":888372,"Title":"跑车","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811433267958957s.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111043826928542s.jpg","SCoin":1000,"VCoin":1500,"Money":0,"ShowSum":0,"RealSum":100,"BuySum":0,"CType":1,"CTypeName":"道具","VID":31,"SType":1,"STime":""}]
         * Count : 40
         */

        private CommodityListBean CommodityList;


        public CommodityListBean getCommodityList() {
            return CommodityList;
        }

        public void setCommodityList(CommodityListBean CommodityList) {
            this.CommodityList = CommodityList;
        }

        public static class CommodityListBean {
            private int Count;
            /**
             * Id : 935449
             * Title : 投票卡
             * Images : http://r9.pccoo.cn/jfshop/20161122/2016112213315756734217_250_250_300x225(s).png
             * ShowImages : http://r9.pccoo.cn/jfshop/20161123/2016112310051851746126_400_300_300x225(s).jpg
             * SCoin : 50
             * VCoin : 120
             * Money : 0
             * ShowSum : 0
             * RealSum : 1000
             * BuySum : 0
             * CType : 1
             * CTypeName : 道具
             * VID : 131
             * SType : 1
             * STime :
             */

            private List<ContentBean> Content;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<ContentBean> getContent() {
                return Content;
            }

            public void setContent(List<ContentBean> Content) {
                this.Content = Content;
            }

            public static class ContentBean {
                private int Id;
                private String Title;
                private String Images;
                private String ShowImages;
                private int SCoin;
                private int VCoin;
                private int Money;
                private int ShowSum;
                private int RealSum;
                private int BuySum;
                private int CType;
                private String CTypeName;
                private int VID;
                private int SType;
                private String STime;


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

                public String getImages() {
                    return Images;
                }

                public void setImages(String Images) {
                    this.Images = Images;
                }

                public String getShowImages() {
                    return ShowImages;
                }

                public void setShowImages(String ShowImages) {
                    this.ShowImages = ShowImages;
                }

                public int getSCoin() {
                    return SCoin;
                }

                public void setSCoin(int SCoin) {
                    this.SCoin = SCoin;
                }

                public int getVCoin() {
                    return VCoin;
                }

                public void setVCoin(int VCoin) {
                    this.VCoin = VCoin;
                }

                public int getMoney() {
                    return Money;
                }

                public void setMoney(int Money) {
                    this.Money = Money;
                }

                public int getShowSum() {
                    return ShowSum;
                }

                public void setShowSum(int ShowSum) {
                    this.ShowSum = ShowSum;
                }

                public int getRealSum() {
                    return RealSum;
                }

                public void setRealSum(int RealSum) {
                    this.RealSum = RealSum;
                }

                public int getBuySum() {
                    return BuySum;
                }

                public void setBuySum(int BuySum) {
                    this.BuySum = BuySum;
                }

                public int getCType() {
                    return CType;
                }

                public void setCType(int CType) {
                    this.CType = CType;
                }

                public String getCTypeName() {
                    return CTypeName;
                }

                public void setCTypeName(String CTypeName) {
                    this.CTypeName = CTypeName;
                }

                public int getVID() {
                    return VID;
                }

                public void setVID(int VID) {
                    this.VID = VID;
                }

                public int getSType() {
                    return SType;
                }

                public void setSType(int SType) {
                    this.SType = SType;
                }

                public String getSTime() {
                    return STime;
                }

                public void setSTime(String STime) {
                    this.STime = STime;
                }
            }
        }
    }
}
