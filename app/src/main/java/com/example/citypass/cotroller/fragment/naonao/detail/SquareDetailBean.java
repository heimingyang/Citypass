package com.example.citypass.cotroller.fragment.naonao.detail;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 11:30
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class SquareDetailBean {
    private String Title;
    private String body;
    private String time;
    private String image;
    private String content;
    private String address;
    private String Images;
    private int id;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SquareDetailBean(String title, String body, String time, String image, String address, String Images,int id,String userName) {
        this.Title = title;
        this.body = body;
        this.time = time;
        this.image = image;
        this.address = address;
        this.Images = Images;
        this.id = id;
        this.userName = userName;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
