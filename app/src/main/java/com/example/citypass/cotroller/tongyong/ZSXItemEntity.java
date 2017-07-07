package com.example.citypass.cotroller.tongyong;

/**
 * Created by Administrator on 2017/6/24 0024.
 */

public class ZSXItemEntity {


    /**
     * appName : CcooCity
     * Param : {"isDaka":0,"pageSize":10,"ruserName":"","topicID":9052931,"siteID":2422,"order":0,"curPage":1}
     * requestTime : 2017-06-24+10:06:49
     * customerKey : 66F697FC3EBA4A6C2CECB8A67A3D06C2
     * Method : PHSocket_GetBBSReplyList
     * Statis : {"PhoneId":"861541443331377","System_VersionNo":"Android+4.2.2","UserId":30943009,"PhoneNum":"+8617637473187","SystemNo":2,"PhoneNo":"NX549J","SiteId":2422}
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
         * isDaka : 0
         * pageSize : 10
         * ruserName :
         * topicID : 9052931
         * siteID : 2422
         * order : 0
         * curPage : 1
         */

        private int isDaka;
        private int pageSize;
        private String ruserName;
        private int topicID;
        private int siteID;
        private int order;
        private int curPage;

        public int getIsDaka() {
            return isDaka;
        }

        public void setIsDaka(int isDaka) {
            this.isDaka = isDaka;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getRuserName() {
            return ruserName;
        }

        public void setRuserName(String ruserName) {
            this.ruserName = ruserName;
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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }
    }

    public static class StatisBean {
        /**
         * PhoneId : 861541443331377
         * System_VersionNo : Android+4.2.2
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
