package com.draggerdemo.maidou.geeknews.model.bean;

/**
 * Created by Administrator on 2016/10/31.
 * 说明:           欢迎界面实体类
 * 创建人:         maixianda
 * 创建时间:       2016/10/31 11:44
 */

public class WelcomeBean {
    /**
     * text :  © Fido Dido
     * img : http://p2.zhimg.com/10/7b/107bb4894b46d75a892da6fa80ef504a.jpg
     */

    private String text;
    private String img;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
