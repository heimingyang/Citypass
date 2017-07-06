package com.example.citypass.model.bean.toutiao;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/5 10:54
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


public class Tzaommentinter {

    /**
     * Method : PHSocket_SetTopicInfoReply
     * Param : {"content":"顶","images":"","isMobile":2,"lastTime":"2014-02-10 11:54:01","mapName":"北京吉利大学","mapPoint":"40.183373,116.172241","replyID":0,"replyUser":"","replyUserLou":0,"roleName":"人贩","siteID":2422,"topicID":9060290,"userName":"sid094756353406476","usiteID":"2422"}
     * Statis : {"PhoneId":"864080037254494","PhoneNo":"OPPO R9s","PhoneNum":"18311468960","SiteId":2422,"SystemNo":2,"System_VersionNo":"Android 6.0.1","UserId":31363437}
     * appName : CcooCity
     * customerID : 8001
     * customerKey : B7F6C5CD4E6C94E9C58F74EF6A77DE7B
     * requestTime : 2017-07-05 10:53:22
     * version : 4.5
     */

    private String Method;
    private ParamBean Param;
    private StatisBean Statis;
    private String appName;
    private int customerID;
    private String customerKey;
    private String requestTime;
    private String version;

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public ParamBean getParam() {
        return Param;
    }

    public void setParam(ParamBean Param) {
        this.Param = Param;
    }

    public StatisBean getStatis() {
        return Statis;
    }

    public void setStatis(StatisBean Statis) {
        this.Statis = Statis;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static class ParamBean {
        /**
         * content : 顶
         * images :
         * isMobile : 2
         * lastTime : 2014-02-10 11:54:01
         * mapName : 北京吉利大学
         * mapPoint : 40.183373,116.172241
         * replyID : 0
         * replyUser :
         * replyUserLou : 0
         * roleName : 人贩
         * siteID : 2422
         * topicID : 9060290
         * userName : sid094756353406476
         * usiteID : 2422
         */

        private String content;
        private String images;
        private int isMobile;
        private String lastTime;
        private String mapName;
        private String mapPoint;
        private int replyID;
        private String replyUser;
        private int replyUserLou;
        private String roleName;
        private int siteID;
        private int topicID;
        private String userName;
        private String usiteID;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getIsMobile() {
            return isMobile;
        }

        public void setIsMobile(int isMobile) {
            this.isMobile = isMobile;
        }

        public String getLastTime() {
            return lastTime;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        public String getMapName() {
            return mapName;
        }

        public void setMapName(String mapName) {
            this.mapName = mapName;
        }

        public String getMapPoint() {
            return mapPoint;
        }

        public void setMapPoint(String mapPoint) {
            this.mapPoint = mapPoint;
        }

        public int getReplyID() {
            return replyID;
        }

        public void setReplyID(int replyID) {
            this.replyID = replyID;
        }

        public String getReplyUser() {
            return replyUser;
        }

        public void setReplyUser(String replyUser) {
            this.replyUser = replyUser;
        }

        public int getReplyUserLou() {
            return replyUserLou;
        }

        public void setReplyUserLou(int replyUserLou) {
            this.replyUserLou = replyUserLou;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public int getSiteID() {
            return siteID;
        }

        public void setSiteID(int siteID) {
            this.siteID = siteID;
        }

        public int getTopicID() {
            return topicID;
        }

        public void setTopicID(int topicID) {
            this.topicID = topicID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUsiteID() {
            return usiteID;
        }

        public void setUsiteID(String usiteID) {
            this.usiteID = usiteID;
        }
    }

    public static class StatisBean {
        /**
         * PhoneId : 864080037254494
         * PhoneNo : OPPO R9s
         * PhoneNum : 18311468960
         * SiteId : 2422
         * SystemNo : 2
         * System_VersionNo : Android 6.0.1
         * UserId : 31363437
         */

        private String PhoneId;
        private String PhoneNo;
        private String PhoneNum;
        private int SiteId;
        private int SystemNo;
        private String System_VersionNo;
        private int UserId;

        public String getPhoneId() {
            return PhoneId;
        }

        public void setPhoneId(String PhoneId) {
            this.PhoneId = PhoneId;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String PhoneNo) {
            this.PhoneNo = PhoneNo;
        }

        public String getPhoneNum() {
            return PhoneNum;
        }

        public void setPhoneNum(String PhoneNum) {
            this.PhoneNum = PhoneNum;
        }

        public int getSiteId() {
            return SiteId;
        }

        public void setSiteId(int SiteId) {
            this.SiteId = SiteId;
        }

        public int getSystemNo() {
            return SystemNo;
        }

        public void setSystemNo(int SystemNo) {
            this.SystemNo = SystemNo;
        }

        public String getSystem_VersionNo() {
            return System_VersionNo;
        }

        public void setSystem_VersionNo(String System_VersionNo) {
            this.System_VersionNo = System_VersionNo;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }
    }
}
