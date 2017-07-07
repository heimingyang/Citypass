package com.example.citypass.utils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/5 20:40
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */
@Entity
public class Zan {
    @Id(autoincrement = true)
    private long id;
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 930316166)
    public Zan(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 785301865)
    public Zan() {
    }
}
