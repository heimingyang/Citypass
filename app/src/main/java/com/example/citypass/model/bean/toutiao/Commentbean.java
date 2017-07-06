package com.example.citypass.model.bean.toutiao;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/5 10:28
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


public class Commentbean {

    /**
     * customerID : 8001
     * requestTime : 2017-07-05 10:24:33
     * Method : PHSocket_SetCityNewsReplyInfo
     * customerKey : 974C42675BE7462326C338EA7061C5C3
     * appName : CcooCity
     * version : 4.5
     * Param : {"replyID":0,"siteID":2422,"newsID":9261805,"content":"评论","userID":31363437,"userName":"sid094756353406476","usiteID":2422}
     * Statis : {"SiteId":2422,"UserId":31363437,"PhoneNo":"OPPO R9s","SystemNo":2,"System_VersionNo":"Android 6.0.1","PhoneId":"864080037254494","PhoneNum":"18311468960"}
     */

    private int customerID;
    private String requestTime;
    private String Method;
    private String customerKey;
    private String appName;
    private String version;
    private ParamBean Param;
    private StatisBean Statis;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public static class ParamBean {
        /**
         * replyID : 0
         * siteID : 2422
         * newsID : 9261805
         * content : 评论
         * userID : 31363437
         * userName : sid094756353406476
         * usiteID : 2422
         */

        private int replyID;
        private int siteID;
        private int newsID;
        private String content;
        private int userID;
        private String userName;
        private int usiteID;

        public int getReplyID() {
            return replyID;
        }

        public void setReplyID(int replyID) {
            this.replyID = replyID;
        }

        public int getSiteID() {
            return siteID;
        }

        public void setSiteID(int siteID) {
            this.siteID = siteID;
        }

        public int getNewsID() {
            return newsID;
        }

        public void setNewsID(int newsID) {
            this.newsID = newsID;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUsiteID() {
            return usiteID;
        }

        public void setUsiteID(int usiteID) {
            this.usiteID = usiteID;
        }
    }

    public static class StatisBean {
        /**
         * SiteId : 2422
         * UserId : 31363437
         * PhoneNo : OPPO R9s
         * SystemNo : 2
         * System_VersionNo : Android 6.0.1
         * PhoneId : 864080037254494
         * PhoneNum : 18311468960
         */

        private int SiteId;
        private int UserId;
        private String PhoneNo;
        private int SystemNo;
        private String System_VersionNo;
        private String PhoneId;
        private String PhoneNum;

        public int getSiteId() {
            return SiteId;
        }

        public void setSiteId(int SiteId) {
            this.SiteId = SiteId;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String PhoneNo) {
            this.PhoneNo = PhoneNo;
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

        public String getPhoneId() {
            return PhoneId;
        }

        public void setPhoneId(String PhoneId) {
            this.PhoneId = PhoneId;
        }

        public String getPhoneNum() {
            return PhoneNum;
        }

        public void setPhoneNum(String PhoneNum) {
            this.PhoneNum = PhoneNum;
        }
    }
}
