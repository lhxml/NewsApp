package com.example.base;

/**
 * Created by lxl on 2017/4/7.
 */

public class BaseResponse<T>{

    private int status;
    private String error;
    private int count;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
