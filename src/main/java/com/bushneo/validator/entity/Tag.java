package com.bushneo.validator.entity;

import javax.validation.constraints.NotNull;


public class Tag {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull(message="标签名称不能为空！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
