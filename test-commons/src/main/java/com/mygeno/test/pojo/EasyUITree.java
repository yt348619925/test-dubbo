package com.mygeno.test.pojo;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: EasyUITree需要用到的属性
 * @version: 1.0
 */
public class EasyUITree {
    private long id;

    private String text;

    private String state;

    private List<?> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }
}
