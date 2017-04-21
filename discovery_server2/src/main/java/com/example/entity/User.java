package com.example.entity;

import java.io.Serializable;

/**
 * Created by ChuChen on 2017/4/20.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -6997111920516184053L;

    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
