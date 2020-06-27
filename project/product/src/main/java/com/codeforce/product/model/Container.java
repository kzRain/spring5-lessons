package com.codeforce.product.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
/*Alimbetov Ruslan*/

@Entity
@Table(name = "container")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Country is requaired")
    @Size(min=1, max =100, message = "Size between 1 and 100 char")
    private String country;

    @NotNull(message = "city is requaired")
    @Size(min=1, max =100, message = "Size between 1 and 100 char")
    private String city;

    @NotNull(message = "adress is requaired")
    @Size(min=10, max =250, message = "Size between 10 and 100 char")
    @Column( length = 250, nullable = false)
    private String adress;

    @NotNull(message = "qnumber is requaired")
    @Size(min=10, max =100, message = "Size between 10 and 100 char")
    @Column( name="qnumber", length = 100, nullable = false, unique = true)
    private String qnumber;


    @OneToMany (mappedBy = "container")
    private Set<Pack> packs = new HashSet<>();

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

    public Set<Pack> getPacks() {
        return packs;
    }

    public void setPacks(Set<Pack> packs) {
        this.packs = packs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQnumber() {
        return qnumber;
    }

    public void setQnumber(String qnumber) {
        this.qnumber = qnumber;
    }
}