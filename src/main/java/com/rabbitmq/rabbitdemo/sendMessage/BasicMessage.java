package com.rabbitmq.rabbitdemo.sendMessage;

import java.io.Serializable;

public class BasicMessage implements Serializable {
    private String name;
    private String desc;

    public BasicMessage(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BasicMessage{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
