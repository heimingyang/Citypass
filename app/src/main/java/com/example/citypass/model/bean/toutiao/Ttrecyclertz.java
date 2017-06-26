package com.example.citypass.model.bean.toutiao;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/26 9:21
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


public class Ttrecyclertz {

    /**
     * Method : PHSocket_GetBBSTopicInfo
     * Param : {"siteID":2422,"topicID":9056361,"userName":""}
     * Statis : {"PhoneId":"864080037254494","PhoneNo":"OPPO R9s","PhoneNum":"18311468960","SiteId":2422,"SystemNo":2,"System_VersionNo":"Android 6.0.1","UserId":0}
     * appName : CcooCity
     * customerID : 8001
     * customerKey : 57CFE3799F320FFB96B951EB68EBCA39
     * requestTime : 2017-06-26 09:19:40
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
         * siteID : 2422
         * topicID : 9056361
         * userName :
         */

        private int siteID;
        private int topicID;
        private String userName;

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
    }

    public static class StatisBean {
        /**
         * PhoneId : 864080037254494
         * PhoneNo : OPPO R9s
         * PhoneNum : 18311468960
         * SiteId : 2422
         * SystemNo : 2
         * System_VersionNo : Android 6.0.1
         * UserId : 0
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
