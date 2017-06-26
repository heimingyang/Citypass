package com.example.citypass.model.biz.infor;

import com.example.citypass.model.http.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/26 11:57
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
interface Ibbs {
    void loadBq(MyCallBack callback, String method);
}
