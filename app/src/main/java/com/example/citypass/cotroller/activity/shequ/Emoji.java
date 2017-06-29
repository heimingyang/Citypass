package com.example.citypass.cotroller.activity.shequ;

import java.io.Serializable;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/29 10:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class Emoji implements Serializable{
    private String emojiName;

    private int emojiUri;

    public Emoji() {
    }

    public Emoji(String emojiName, int emojiUri) {
        this.emojiName = emojiName;
        this.emojiUri = emojiUri;
    }

    public String getEmojiName() {
        return emojiName;
    }

    public void setEmojiName(String emojiName) {
        this.emojiName = emojiName;
    }

    public int getEmojiUri() {
        return emojiUri;
    }

    public void setEmojiUri(int emojiUri) {
        this.emojiUri = emojiUri;
    }
}
