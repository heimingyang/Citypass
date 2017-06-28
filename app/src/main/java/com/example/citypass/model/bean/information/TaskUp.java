package com.example.citypass.model.bean.information;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 15:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskUp {

    /**
     * customerID : 8001
     * requestTime : 2017-06-27 15:00:55
     * Method : PHSocket_UserTaskConfigList
     * customerKey : 099ACCE62DB372B0D8C72CC90491E9B2
     * appName : CcooCity
     * version : 4.5
     * Param : {"siteID":2422,"userID":31042672,"property":1,"curPage":1,"pageSize":10}
     * Statis : {"SiteId":2422,"UserId":31042672,"PhoneNo":"OPPO A33","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"863181036606964","PhoneNum":" 8618501151714"}
     */

    private int customerID;
    private String requestTime;
    private String Method;
    private String customerKey;
    private String appName;
    private String version;
    /**
     * siteID : 2422
     * userID : 31042672
     * property : 1
     * curPage : 1
     * pageSize : 10
     */

    private ParamBean Param;
    /**
     * SiteId : 2422
     * UserId : 31042672
     * PhoneNo : OPPO A33
     * SystemNo : 2
     * System_VersionNo : Android 5.1.1
     * PhoneId : 863181036606964
     * PhoneNum :  8618501151714
     */

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
        private int siteID;
        private int userID;
        private int property;
        private int curPage;
        private int pageSize;


        public int getSiteID() {
            return siteID;
        }

        public void setSiteID(int siteID) {
            this.siteID = siteID;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public int getProperty() {
            return property;
        }

        public void setProperty(int property) {
            this.property = property;
        }

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class StatisBean {
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
