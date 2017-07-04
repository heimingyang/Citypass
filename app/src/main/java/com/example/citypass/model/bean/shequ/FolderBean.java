package com.example.citypass.model.bean.shequ;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/7/3 15:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class FolderBean {
    //图片路径
    private String dir;
    //第一张图片的路径
    private String firstDir;
    //文件夹名称
    private String name;
    //图片数量
    private int count;
    private boolean aBoolean;

    public void setName(String name) {
        this.name = name;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
        int lastIndexof = this.dir.lastIndexOf("/");
        this.name = this.dir.substring(lastIndexof);
    }

    public String getFirstDir() {
        return firstDir;
    }

    public void setFirstDir(String firstDir) {
        this.firstDir = firstDir;
    }

    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
