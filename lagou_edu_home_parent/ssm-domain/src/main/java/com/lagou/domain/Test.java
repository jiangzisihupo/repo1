package com.lagou.domain;

/**************************************
 * @author pan
 * @version 2022/6/3 22:52
 **************************************/
public class Test {

    private int id;
    private String  name;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
