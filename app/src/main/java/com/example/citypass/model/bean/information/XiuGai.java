package com.example.citypass.model.bean.information;

import com.example.citypass.model.bean.BaseParamBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/6 19:32
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class XiuGai extends BaseParamBean{
    private String phone;
    private String newPassWord;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPassWord() {
        return newPassWord;
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }
}
