package com.example.citypass.model.http;

import com.example.citypass.utils.UrlUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/21 10:19
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class LifeModel {

    public void Post(MyCallBack callBack) {
        Map<String, String> map = new HashMap<>();
         String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-23 08:45:03\",\"Method\":\"PHSocket_GetNewPostLiveInfoTwo\",\"customerKey\":\"1338E68768F11FE45C3026654DCCFCA9\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422},\"Statis\":{\"SiteId\":2422,\"UserId\":30938715,\"PhoneNo\":\"OPPO R9m\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1\",\"PhoneId\":\"862609032748977\",\"PhoneNum\":\"+8618833628372\"}}";
        map.put("param", str);

        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", callBack);


    }

}
