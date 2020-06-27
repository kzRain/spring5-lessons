package com.codeforce.product.model;


import javax.persistence.*;

@Entity
@Table(name = "user_images")
public class UserImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private long user_id;

    private String filename;
    @Lob
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
