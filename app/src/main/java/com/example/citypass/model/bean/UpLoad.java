package com.example.citypass.model.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述: 上传个人信息使用的实体类
 * 创建人: 马杰
 * 创建时间: 2017/6/23 15:10
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class UpLoad {

    /**
     * customerID : 8001
     * requestTime : 2017-06-23 14:57:03
     * Method : PHSocket_SetUserBaseInfo
     * customerKey : B28F1BB67F479F5C426849E200AA4E1B
     * appName : CcooCity
     * version : 4.5
     * Param : {"userID":"31042672","siteID":2422,"userName":"sid193108730110051","usiteID":2422,"keyID":12,"value":"北京吉利大学"}
     * Statis : {"SiteId":2422,"UserId":31042672,"PhoneNo":"OPPO A33","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"863181036606964","PhoneNum":"+8618501151714"}
     */

    private int customerID;
    private String requestTime;
    private String Method;
    private String customerKey;
    private String appName;
    private String version;
    /**
     * userID : 31042672
     * siteID : 2422
     * userName : sid193108730110051
     * usiteID : 2422
     * keyID : 12
     * value : 北京吉利大学
     */

    private ParamBean Param;
    /**
     * SiteId : 2422
     * UserId : 31042672
     * PhoneNo : OPPO A33
     * SystemNo : 2
     * System_VersionNo : Android 5.1.1
     * PhoneId : 863181036606964
     * PhoneNum : +8618501151714
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
        private String userID;
        private int siteID;
        private String userName;
        private int usiteID;
        private int keyID;
        private String value;


        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public int getSiteID() {
            return siteID;
        }

        public void setSiteID(int siteID) {
            this.siteID = siteID;
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

        public int getKeyID() {
            return keyID;
        }

        public void setKeyID(int keyID) {
            this.keyID = keyID;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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
