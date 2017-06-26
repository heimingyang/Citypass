package com.example.citypass.model.biz.infor;

import android.util.Log;

import com.example.citypass.model.http.FactoryIn;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/26 11:55
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class BbSimp implements Ibbs{
    private FactoryIn factoryIn;
    @Override
    public void loadBq(MyCallBack callback, String method) {
        factoryIn = HttpFacory.create();
        HashMap<String, String> params = new HashMap<>();
        params.put("param",method);
        Log.d("Bbsimp", params.get("param"));
        factoryIn.POST("http://appnew.ccoo.cn/appserverapi.ashx", params, null,callback);
    }
}
