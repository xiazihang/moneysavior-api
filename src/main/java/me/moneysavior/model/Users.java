package me.moneysavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    @ApiModelProperty(value = "users information")
    private List<User> data = newArrayList();

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
