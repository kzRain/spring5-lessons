package com.example.demorabbitmq2;

import java.io.Serializable;

public class Image implements Serializable {
    private String name;
    private Integer size;
    private byte[] body;

    public Image() {
    }

    public Image(String name, Integer size, byte[] body) {
        this.name = name;
        this.size = size;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
