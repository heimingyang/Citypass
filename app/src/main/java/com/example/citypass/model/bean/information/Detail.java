package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/4 14:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Detail {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * CommodityInfo : {"Content":[{"Id":797587,"CouponId":0,"Title":"[礼物道具]鲜花","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811392880378213m.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111102065534460m.jpg","RealSum":110,"BuySum":0,"SCoin":1,"VCoin":3,"Money":0,"STime":"","ETime":2366362299,"Level":"所有会员均可兑换","Limit":"无兑换数量限制","CType":1,"Description":"<style>@font-face{font-family: \"ccoofont\";src: url('file:///android_asset/font/sys.ttf');} #spinfo{font-family: 'ccoofont';line-height:160%;font-size:14px;}<\/style>\r\n<div id=\"spinfo\">\r\n<b>道具使用说明：<\/b><br/>\r\n花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。\r\n<br/>\r\n<b>道具有效期：<\/b>兑换后180天有效~\r\n<\/div>\r\n","TQType":0,"IsUserBuy":0,"State":1}]}
     * Instruction : {"Description":"花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。"}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CommodityInfo":{"Content":[{"Id":797587,"CouponId":0,"Title":"[礼物道具]鲜花","Images":"http://p3.pccoo.cn/weixin/20160218/2016021811392880378213m.png","ShowImages":"http://p3.pccoo.cn/weixin/20160301/2016030111102065534460m.jpg","RealSum":110,"BuySum":0,"SCoin":1,"VCoin":3,"Money":0,"STime":"","ETime":2366362299,"Level":"所有会员均可兑换","Limit":"无兑换数量限制","CType":1,"Description":"<style>@font-face{font-family: \"ccoofont\";src: url('file:///android_asset/font/sys.ttf');} #spinfo{font-family: 'ccoofont';line-height:160%;font-size:14px;}<\/style>\r\n<div id=\"spinfo\">\r\n<b>道具使用说明：<\/b><br/>\r\n花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。\r\n<br/>\r\n<b>道具有效期：<\/b>兑换后180天有效~\r\n<\/div>\r\n","TQType":0,"IsUserBuy":0,"State":1}]},"Instruction":{"Description":"花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。"}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0439453
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
        private CommodityInfoBean CommodityInfo;
        /**
         * Description : 花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。
         */

        private InstructionBean Instruction;


        public CommodityInfoBean getCommodityInfo() {
            return CommodityInfo;
        }

        public void setCommodityInfo(CommodityInfoBean CommodityInfo) {
            this.CommodityInfo = CommodityInfo;
        }

        public InstructionBean getInstruction() {
            return Instruction;
        }

        public void setInstruction(InstructionBean Instruction) {
            this.Instruction = Instruction;
        }

        public static class CommodityInfoBean {
            /**
             * Id : 797587
             * CouponId : 0
             * Title : [礼物道具]鲜花
             * Images : http://p3.pccoo.cn/weixin/20160218/2016021811392880378213m.png
             * ShowImages : http://p3.pccoo.cn/weixin/20160301/2016030111102065534460m.jpg
             * RealSum : 110
             * BuySum : 0
             * SCoin : 1
             * VCoin : 3
             * Money : 0
             * STime :
             * ETime : 2366362299
             * Level : 所有会员均可兑换
             * Limit : 无兑换数量限制
             * CType : 1
             * Description : <style>@font-face{font-family: "ccoofont";src: url('file:///android_asset/font/sys.ttf');} #spinfo{font-family: 'ccoofont';line-height:160%;font-size:14px;}</style>
             <div id="spinfo">
             <b>道具使用说明：</b><br/>
             花的芬芳和美丽，与你一样。使用城市币兑换礼物送给女生用户。
             <br/>
             <b>道具有效期：</b>兑换后180天有效~
             </div>

             * TQType : 0
             * IsUserBuy : 0
             * State : 1
             */

            private List<ContentBean> Content;


            public List<ContentBean> getContent() {
                return Content;
            }

            public void setContent(List<ContentBean> Content) {
                this.Content = Content;
            }

            public static class ContentBean {
                private int Id;
                private int CouponId;
                private String Title;
                private String Images;
                private String ShowImages;
                private int RealSum;
                private int BuySum;
                private int SCoin;
                private int VCoin;
                private int Money;
                private String STime;
                private long ETime;
                private String Level;
                private String Limit;
                private int CType;
                private String Description;
                private int TQType;
                private int IsUserBuy;
                private int State;


                public int getId() {
                    return Id;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public int getCouponId() {
                    return CouponId;
                }

                public void setCouponId(int CouponId) {
                    this.CouponId = CouponId;
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

                public String getSTime() {
                    return STime;
                }

                public void setSTime(String STime) {
                    this.STime = STime;
                }

                public long getETime() {
                    return ETime;
                }

                public void setETime(long ETime) {
                    this.ETime = ETime;
                }

                public String getLevel() {
                    return Level;
                }

                public void setLevel(String Level) {
                    this.Level = Level;
                }

                public String getLimit() {
                    return Limit;
                }

                public void setLimit(String Limit) {
                    this.Limit = Limit;
                }

                public int getCType() {
                    return CType;
                }

                public void setCType(int CType) {
                    this.CType = CType;
                }

                public String getDescription() {
                    return Description;
                }

                public void setDescription(String Description) {
                    this.Description = Description;
                }

                public int getTQType() {
                    return TQType;
                }

                public void setTQType(int TQType) {
                    this.TQType = TQType;
                }

                public int getIsUserBuy() {
                    return IsUserBuy;
                }

                public void setIsUserBuy(int IsUserBuy) {
                    this.IsUserBuy = IsUserBuy;
                }

                public int getState() {
                    return State;
                }

                public void setState(int State) {
                    this.State = State;
                }
            }
        }

        public static class InstructionBean {
            private String Description;

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }
        }
    }
}
