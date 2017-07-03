package com.example.citypass.model.bean.toutiao;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/3 8:59
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


public class Divingbean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Address":"北京吉利大学","Sum":"2808","Level":1,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/6D80EFBFC196EE3CE46336CF87AF1807/100","NickName":"喏，给你喝","UserMedal":"","UserId":"29051757"},{"Address":"北京吉利大学","Sum":"135","Level":1,"UserFace":"http://r9.pccoo.cn/app_avatar/20170622/2017062211420171786438_780_780_300x225(s).jpg","NickName":"二狗他爸","UserMedal":"","UserId":"31139731"},{"Address":"延庆区延庆镇","Sum":"135","Level":4,"UserFace":"http://p5.pccoo.cn/weixin/20161018/2016101820430987986762s.jpg","NickName":"一瞬间","UserMedal":"","UserId":"21197112"},{"Address":"延庆县,X017","Sum":"115","Level":10,"UserFace":"http://r9.pccoo.cn/app_avatar/20170331/2017033104515643973329_390_390_300x225(s).jpg","NickName":"蚊子","UserMedal":"http://p3.pccoo.cn/vote/20151224/2015122410451968647127.png","UserId":"26233503"},{"Address":"双路小区","Sum":"105","Level":6,"UserFace":"http://p3.pccoo.cn/weixin/20160426/2016042607564458414664s.jpg","NickName":"苦咖啡","UserMedal":"","UserId":"18535745"},{"Address":"延庆","Sum":"102","Level":4,"UserFace":"http://r9.pccoo.cn/app_avatar/20170313/2017031310061351450659_780_780_300x225(s).jpg","NickName":"一杯浊酒敬曾经","UserMedal":"","UserId":"25917928"},{"Address":"石河营","Sum":"85","Level":4,"UserFace":"http://p2.pccoo.cn/weixin/20150424/2015042411380341375311s.jpg","NickName":"大懒猫。","UserMedal":"","UserId":"11952716"},{"Address":"北京","Sum":"80","Level":2,"UserFace":"http://p4.pccoo.cn/weixin/20160611/2016061108265873740385s.jpg","NickName":"AAA红领巾??","UserMedal":"","UserId":"19778441"},{"Address":"延庆","Sum":"61","Level":1,"UserFace":"https://q.qlogo.cn/qqapp/204708/CA0918012C359AEAAC594CC5F447F2F6/100","NickName":"顺其自然","UserMedal":"","UserId":"25531928"},{"Address":"康安小区","Sum":"58","Level":1,"UserFace":"http://qzapp.qlogo.cn/qzapp/204708/EA3A3ED77AFD49866B31015BE3B7B11C/100","NickName":"炎炎","UserMedal":"","UserId":"15091387"},{"Address":"旧县镇旧县村","Sum":"57","Level":6,"UserFace":"http://p5.pccoo.cn/weixin/20170313/2017031309434345676172s.jpg","NickName":"李建伟","UserMedal":"","UserId":"25917490"},{"Address":"北京昌平","Sum":"54","Level":2,"UserFace":"http://r9.pccoo.cn/app_avatar/20170516/2017051615233013153352_780_780_300x225(s).jpg","NickName":"小尹子","UserMedal":"","UserId":"29171570"},{"Address":"望都家园","Sum":"54","Level":1,"UserFace":"http://p5.pccoo.cn/weixin/20170214/2017021415001745889716s.jpg","NickName":"百草","UserMedal":"","UserId":"25299843"},{"Address":"延庆旧县镇","Sum":"54","Level":1,"UserFace":"http://r9.pccoo.cn/APPIMAGE/20170507/2017050718211317159028_80_80_300x225(s).jpg","NickName":"李伟","UserMedal":"","UserId":"11404074"},{"Address":"井庄","Sum":"50","Level":15,"UserFace":"http://p4.pccoo.cn/app_avatar/20160502/2016050219225922721835s.jpeg","NickName":"薄荷糖～微微凉","UserMedal":"","UserId":"18575543"},{"Address":"延庆永宁","Sum":"50","Level":5,"UserFace":"http://p4.pccoo.cn/app_avatar/20160607/2016060722094983933072s.jpg","NickName":"张强","UserMedal":"","UserId":"17207497"},{"Address":"北京吉利大学","Sum":"47","Level":4,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/433EBDD4EF33A3B67A334F1EA179C4FC/100","NickName":"bug","UserMedal":"","UserId":"30937884"},{"Address":"簸箕营小区","Sum":"46","Level":1,"UserFace":"http://p5.pccoo.cn/weixin/20170426/2017042617574630294638s.jpg","NickName":"哦CK弟弟可","UserMedal":"","UserId":"28272475"},{"Address":"北京地球村","Sum":"46","Level":1,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/E3796389282AECC2EA2C0FE796B133DE/100","NickName":"小东","UserMedal":"","UserId":"26325648"},{"Address":"燕水佳园南区","Sum":"45","Level":3,"UserFace":"http://r9.pccoo.cn/app_cover/20170101/2017010110495702439303_750_750_300x225(s).jpg","NickName":"素念。","UserMedal":"","UserId":"23899202"},{"Address":"张山营","Sum":"44","Level":15,"UserFace":"http://p3.pccoo.cn/app_avatar/20160409/2016040923375164716211s.jpg","NickName":"最佳之波波","UserMedal":"","UserId":"9978871"},{"Address":"延庆","Sum":"43","Level":4,"UserFace":"http://r9.pccoo.cn/weixin/20170302/2017030222465647657526_640_640_300x225(s).jpg","NickName":"秋天不回来","UserMedal":"","UserId":"25672116"},{"Address":"北京大学","Sum":"40","Level":4,"UserFace":"http://r9.pccoo.cn/app_avatar/20170701/2017070111274427131402_780_780_300x225(s).jpg","NickName":"5555","UserMedal":"","UserId":"31198418"},{"Address":"延庆北关","Sum":"36","Level":2,"UserFace":"http://qzapp.qlogo.cn/qzapp/204708/45BF82A38E43DDD992E599A204BB7365/100","NickName":"随风","UserMedal":"","UserId":"22854915"},{"Address":"康庄镇","Sum":"34","Level":1,"UserFace":"http://r9.pccoo.cn/app_avatar/20170530/2017053011030955329873_780_780_300x225(s).jpg","NickName":"乐天","UserMedal":"","UserId":"29918816"},{"Address":"延庆区","Sum":"34","Level":2,"UserFace":"http://r9.pccoo.cn/app_avatar/20170517/2017051706562104411699_780_780_300x225(s).jpg","NickName":"低调","UserMedal":"","UserId":"28645843"},{"Address":"北关","Sum":"34","Level":1,"UserFace":"http://p5.pccoo.cn/weixin/20170330/2017033022324633215384s.jpg","NickName":"雷小美🍒","UserMedal":"","UserId":"26493693"},{"Address":"康庄","Sum":"34","Level":3,"UserFace":"http://r9.pccoo.cn/app_avatar/20170317/2017031722103723543304_3120_4160_300x225(s).jpg","NickName":"天敌","UserMedal":"","UserId":"25969150"},{"Address":"延庆","Sum":"33","Level":6,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/81BA5946086C50B5F103654D2D1372FB/100","NickName":"开心","UserMedal":"","UserId":"28681280"},{"Address":"石河营","Sum":"33","Level":7,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/C9265FFCFFD931C205EFCBA799DF25D6/100","NickName":"懂你","UserMedal":"","UserId":"21619814"},{"Address":"新华营","Sum":"32","Level":2,"UserFace":"http://r9.pccoo.cn/weixin/20170517/2017051711582971600953_640_640_300x225(s).jpg","NickName":"希音鑫","UserMedal":"","UserId":"29258474"},{"Address":"北京吉利大学","Sum":"32","Level":3,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/DB073E985AB7863527137A64611FEDD8/100","NickName":"。。","UserMedal":"","UserId":"28834015"},{"Address":"北京吉利大学","Sum":"31","Level":2,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/7716BFEF893F20B6171CCFF717C06C89/100","NickName":"淡定","UserMedal":"","UserId":"30943103"},{"Address":"无法显示当前位置","Sum":"30","Level":1,"UserFace":"http://r9.pccoo.cn/webapp/20170407/2017040715045048185307_3120_4160_300x225(s).jpg","NickName":"JRQ","UserMedal":"","UserId":"26923388"},{"Address":"延庆","Sum":"30","Level":1,"UserFace":"http://p5.pccoo.cn/weixin/20170402/2017040212210153636045s.jpg","NickName":"烟花的美","UserMedal":"","UserId":"26625914"},{"Address":"西白庙","Sum":"29","Level":2,"UserFace":"http://p5.pccoo.cn/weixin/20170414/2017041409513611616421s.jpg","NickName":"丁志刚","UserMedal":"","UserId":"27199724"},{"Address":"无法显示当前位置延庆","Sum":"29","Level":4,"UserFace":"http://r9.pccoo.cn/app_avatar/20170326/2017032613484008718770_780_780_300x225(s).jpg","NickName":"快到碗里来","UserMedal":"","UserId":"21290051"},{"Address":"延庆","Sum":"29","Level":1,"UserFace":"http://p5.pccoo.cn/weixin/20161005/2016100517582048685104s.jpg","NickName":"都是有故事的人。","UserMedal":"","UserId":"21081802"},{"Address":"延庆县,S028(八峪路)","Sum":"28","Level":2,"UserFace":"http://r9.pccoo.cn/webapp/20170509/2017050909312857502290_960_1280_300x225(s).jpg","NickName":"多多","UserMedal":"","UserId":"28827397"},{"Address":"吴坊营","Sum":"28","Level":2,"UserFace":"http://r9.pccoo.cn/app_avatar/20170317/2017031716215066384675_1090_1090_300x225(s).jpg","NickName":"高小月","UserMedal":"","UserId":"24779923"},{"Address":"北京市","Sum":"28","Level":3,"UserFace":"http://p3.pccoo.cn/weixin/20151111/2015111117544596530236s.jpg","NickName":"瑾少","UserMedal":"","UserId":"16417877"},{"Address":"延庆","Sum":"27","Level":1,"UserFace":"http://qzapp.qlogo.cn/qzapp/204708/E08896F05D004FCF446B79795FEF8502/100","NickName":"老虎","UserMedal":"","UserId":"24899671"},{"Address":"北京延庆","Sum":"27","Level":6,"UserFace":"http://r9.pccoo.cn/app_cover/20170601/2017060118314932781970_750_750_300x225(s).jpg","NickName":"虚伪的承诺","UserMedal":"","UserId":"20872199"},{"Address":"北京","Sum":"26","Level":1,"UserFace":"https://q.qlogo.cn/qqapp/204708/E7279E28A664C44DDD1DEF30A2BE5D1B/100","NickName":"透明人","UserMedal":"","UserId":"27818196"},{"Address":"张山营镇辛家堡村","Sum":"26","Level":13,"UserFace":"http://p3.pccoo.cn/app_avatar/20160412/2016041217173374979504s.jpg","NickName":"燕云","UserMedal":"","UserId":"18337509"},{"Address":"北京吉利大学","Sum":"25","Level":2,"UserFace":"http://r9.pccoo.cn/app_avatar/20170619/2017061910545246831007_780_780_300x225(s).jpg","NickName":"超哥在昌平","UserMedal":"","UserId":"30938715"},{"Address":"北京吉利大学","Sum":"25","Level":2,"UserFace":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","NickName":"现实太美，美不过虚伪","UserMedal":"","UserId":"28809809"},{"Address":"沈家营","Sum":"25","Level":1,"UserFace":"http://r9.pccoo.cn/app_avatar/20170320/2017032015245743179812_780_780_300x225(s).jpg","NickName":"炫蓝","UserMedal":"","UserId":"26164587"},{"Address":"延庆","Sum":"25","Level":3,"UserFace":"http://p5.pccoo.cn/weixin/20170311/2017031121031760746045s.jpg","NickName":"快乐男孩","UserMedal":"","UserId":"25896404"},{"Address":"北京","Sum":"24","Level":7,"UserFace":"http://r9.pccoo.cn/app_avatar/20170626/2017062611423608599903_458_458_300x225(s).jpg","NickName":"12300","UserMedal":"http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png,http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png,http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png","UserId":"31090706"}]
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0107426
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
         * Address : 北京吉利大学
         * Sum : 2808
         * Level : 1
         * UserFace : http://q.qlogo.cn/qqapp/1102147502/6D80EFBFC196EE3CE46336CF87AF1807/100
         * NickName : 喏，给你喝
         * UserMedal :
         * UserId : 29051757
         */

        private String Address;
        private String Sum;
        private int Level;
        private String UserFace;
        private String NickName;
        private String UserMedal;
        private String UserId;

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getSum() {
            return Sum;
        }

        public void setSum(String Sum) {
            this.Sum = Sum;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public String getUserFace() {
            return UserFace;
        }

        public void setUserFace(String UserFace) {
            this.UserFace = UserFace;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getUserMedal() {
            return UserMedal;
        }

        public void setUserMedal(String UserMedal) {
            this.UserMedal = UserMedal;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }
    }
}
