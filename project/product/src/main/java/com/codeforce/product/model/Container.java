package com.codeforce.product.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "container")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   private String country;

    @Column( length = 250, nullable = false, unique = true)
    private String adress;

    @OneToMany
    private List<Pack> packs;

    public Container() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }


}