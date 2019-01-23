package com.mygeno.test.pojo;

/**
 * @Auther: yt
 * @Date: 2019/1/23
 * @Description: com.mygeno.test.pojo
 * @version: 1.0
 */
public class MygenoResult {

    private int status;

    private Object data;

    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
