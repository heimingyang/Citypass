package com.example.citypass.model.bean.naonao;

import java.util.List;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/7 0007 8:27
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


public class Carmer_FaBu_NaoNao_Collect_Pop_Bean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":26,"DjId":898811,"Title":"帖子置顶卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817161142690048s.png","Description":"帖子在24小时内，置顶突出展示。","Amount":0},{"Id":23,"DjId":900327,"Title":"值得一看卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817322411609205s.png","Description":"贴子标题将显示\u201c值得一看\u201d图标，同时信息将在\u201c值得一看\u201d栏推荐显示。","Amount":0},{"Id":19,"DjId":901150,"Title":"主题变色卡","Images":"http://p3.pccoo.cn/weixin/20160408/2016040817330429443897s.png","Description":"帖子发出后，标题将变红突出显示。","Amount":0}]
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0117187
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
         * Id : 26
         * DjId : 898811
         * Title : 帖子置顶卡
         * Images : http://p3.pccoo.cn/weixin/20160408/2016040817161142690048s.png
         * Description : 帖子在24小时内，置顶突出展示。
         * Amount : 0
         */

        private int Id;
        private int DjId;
        private String Title;
        private String Images;
        private String Description;
        private int Amount;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getDjId() {
            return DjId;
        }

        public void setDjId(int DjId) {
            this.DjId = DjId;
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

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }
    }
}
