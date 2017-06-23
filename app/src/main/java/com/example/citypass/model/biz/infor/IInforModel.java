package com.example.citypass.model.biz.infor;

import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压卫士
 * 类描述:上传信息的网络请求
 * 创建人: 马杰
 * 创建时间: 2017/6/23 15:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IInforModel implements InforModel {
    @Override
    public void UpLoad(String params, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("param",params);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx",map,null,callBack);
    }
}
