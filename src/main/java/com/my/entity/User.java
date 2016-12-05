package com.my.entity;

/**
 * Created by Doing on 2016/12/5 0005.
 */
public class User {
    private long userId;
    private String userName;

    /**
     * 必须有空构造函数，否则报错：
     * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.executor.ExecutorException: No constructor found in com.my.User ...
     */
    public User() {
    }

    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
