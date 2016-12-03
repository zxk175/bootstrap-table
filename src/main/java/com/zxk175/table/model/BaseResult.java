package com.zxk175.table.model;

/**
 * Created by zxk175 on 16/12/2.
 */
public class BaseResult {
    private boolean success;
    private Object data;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
