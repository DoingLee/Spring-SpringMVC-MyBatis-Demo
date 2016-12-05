package com.my.dto;

/**
 * Created by Doing on 2016/12/5 0005.
 */
public class Result<T> {
    private boolean success;
    private T data;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
