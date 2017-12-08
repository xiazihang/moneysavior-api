package me.moneysavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Expenses {
    @ApiModelProperty(value = "expense information")
    private List<Expense> data = newArrayList();

    public List<Expense> getData() {
        return data;
    }

    public void setData(List<Expense> data) {
        this.data = data;
    }
}
