package com.codeforce.product.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*Alimbetov Ruslan*/
@Entity
@Table(name = "pack")
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "weigth is requaired")
    @DecimalMax(value = "100", message = "weigth between 1 and 100 kg")
    private double weigth;

    @NotNull(message = "packkey is requaired")
    @Size(min = 10, max = 20, message = "packkey between 10 and 20 char")
    @Column(length = 20, nullable = false, unique = true)
    private String packkey;

    @JsonIgnore
    @ManyToOne
    private State state;

    @ManyToOne
    private Container container;


    public Pack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public String getPackkey() {
        return packkey;
    }

    public void setPackkey(String packkey) {
        this.packkey = packkey;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
