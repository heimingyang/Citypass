package com.example.citypass.cotroller.tongyong;

/**
 * Created by Administrator on 2017/6/22 0022.
 */

public class CommunityDetailsZSXEntity {


    /**
     * appName : CcooCity
     * Param : {"sourceType":0,"userName":"sid113436607900679","topicID":8804518,"siteID":2422}
     * requestTime : 2017-06-22 10:27:50
     * customerKey : 1D28716393C8F8E2EAD8D3FF6F24DD92
     * Method : PHSocket_GetBBSTopicInfo
     * Statis : {"PhoneId":"861541443331377","System_VersionNo":"Android 4.2.2","UserId":30943009,"PhoneNum":"+8617637473187","SystemNo":2,"PhoneNo":"NX549J","SiteId":2422}
     * customerID : 8001
     * version : 4.5
     */

    private String appName;
    private ParamBean Param;
    private String requestTime;
    private String customerKey;
    private String Method;
    private StatisBean Statis;
    private int customerID;
    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public ParamBean getParam() {
        return Param;
    }

    public void setParam(ParamBean Param) {
        this.Param = Param;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public StatisBean getStatis() {
        return Statis;
    }

    public void setStatis(StatisBean Statis) {
        this.Statis = Statis;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static class ParamBean {
        /**
         * sourceType : 0
         * userName : sid113436607900679
         * topicID : 8804518
         * siteID : 2422
         */

        private int sourceType;
        private String userName;
        private int topicID;
        private int siteID;

        public int getSourceType() {
            return sourceType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getTopicID() {
            return topicID;
        }

        public void setTopicID(int topicID) {
            this.topicID = topicID;
        }

        public int getSiteID() {
            return siteID;
        }

        public void setSiteID(int siteID) {
            this.siteID = siteID;
        }
    }

    public static class StatisBean {
        /**
         * PhoneId : 861541443331377
         * System_VersionNo : Android 4.2.2
         * UserId : 30943009
         * PhoneNum : +8617637473187
         * SystemNo : 2
         * PhoneNo : NX549J
         * SiteId : 2422
         */

        private String PhoneId;
        private String System_VersionNo;
        private int UserId;
        private String PhoneNum;
        private int SystemNo;
        private String PhoneNo;
        private int SiteId;

        public String getPhoneId() {
            return PhoneId;
        }

        public void setPhoneId(String PhoneId) {
            this.PhoneId = PhoneId;
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

        public String getPhoneNum() {
            return PhoneNum;
        }

        public void setPhoneNum(String PhoneNum) {
            this.PhoneNum = PhoneNum;
        }

        public int getSystemNo() {
            return SystemNo;
        }

        public void setSystemNo(int SystemNo) {
            this.SystemNo = SystemNo;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String PhoneNo) {
            this.PhoneNo = PhoneNo;
        }

        public int getSiteId() {
            return SiteId;
        }

        public void setSiteId(int SiteId) {
            this.SiteId = SiteId;
        }
    }
}
