package com.example.citypass.model.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 项目名称: 血压卫士
 * 类描述: 登录使用的实体类
 * 创建人: 马杰
 * 创建时间: 2017/6/21 15:14
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Login {

    /**
     * customerID : 8001
     * requestTime : 2017-06-21 15:03:00
     * Method : PHSocket_CheckUserLogin
     * customerKey : E45AB41A52D150F4CB9EE6832ECFCE75
     * appName : CcooCity
     * version : 4.5
     * Param : {"loginName":"18501151714","userPWD":"zxc123456","ip":"117.136.0.202","post":"8000","version":"android 4.3"}
     * Statis : {"SiteId":2422,"UserId":31042672,"PhoneNo":"OPPO A33","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"863181036606964","PhoneNum":" 8618501151714"}
     */

    private int customerID;
    private String requestTime;
    private String Method;
    private String customerKey;
    private String appName;
    private String version;
    /**
     * loginName : 18501151714
     * userPWD : zxc123456
     * ip : 117.136.0.202
     * post : 8000
     * version : android 4.3
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
        private String loginName;
        private String userPWD;
        private String ip;
        private String post;
        private String version;


        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getUserPWD() {
            return userPWD;
        }

        public void setUserPWD(String userPWD) {
            this.userPWD = userPWD;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
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
