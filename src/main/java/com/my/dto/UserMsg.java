package com.my.dto;

/**
 * Created by Doing on 2016/12/5 0005.
 */
public class UserMsg {
    private String name;
    private long id;

    public UserMsg(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserMsg{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
