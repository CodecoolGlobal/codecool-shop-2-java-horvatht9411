package com.codecool.shop.model;


import com.codecool.shop.service.LogService;

import java.lang.reflect.Field;

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;

    public BaseModel(String name) {
        this.name = name;
    }

    public BaseModel() {
    }

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value != null) {
                    sb.append(field.getName()).append(":").append(value).append(",");
                }
            } catch (IllegalAccessException e) {
                LogService.log(e);
            }
        }
        return sb.toString();
    }
}
