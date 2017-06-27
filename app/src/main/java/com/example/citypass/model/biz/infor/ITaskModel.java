package com.example.citypass.model.biz.infor;

import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 15:59
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ITaskModel implements TaskModel {
    @Override
    public void getParam(String param, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("param",param);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx",map,null,callBack);
    }
}
