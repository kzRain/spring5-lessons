package com.codeforce.product.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

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
    private String packKey;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private State state;

    @ManyToOne
    private Cantainer container;

    @ManyToOne
    private Point point;

    @OneToOne
    private Box box;


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

    public String getPackKey() {
        return packKey;
    }

    public void setPackKey(String packKey) {
        this.packKey = packKey;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Cantainer getCantainer() {
        return container;
    }

    public void setCantainer(Cantainer container) {
        this.container = container;
    }
}
