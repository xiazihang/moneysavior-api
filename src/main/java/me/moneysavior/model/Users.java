package me.moneysavior.model;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Users {
    private List<User> data = newArrayList();

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
