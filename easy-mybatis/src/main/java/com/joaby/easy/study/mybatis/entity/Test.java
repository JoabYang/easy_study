package com.joaby.easy.study.mybatis.entity;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 17:47
 */
public class Test {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }
}
