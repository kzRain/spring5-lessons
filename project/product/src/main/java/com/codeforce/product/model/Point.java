package com.codeforce.product.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String num;
    private String address;
    private int boxNum;
    private int busy;
    private UUID token;

    public Point() {
    }

    public Point(Long id, String num, String address, int boxNum, int busy, UUID token) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.boxNum = boxNum;
        this.busy = busy;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public int getBusy() {
        return busy;
    }

    public void setBusy(int busy) {
        this.busy = busy;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", boxNum=" + boxNum +
                ", busy=" + busy +
                ", token=" + token +
                '}';
    }
}
