package com.codeforce.product.model;


import javax.persistence.*;
import java.util.Optional;

@Entity(name = "pack")
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double weigth;

    @Column( length = 20, nullable = false, unique = true)
    private String  packkey;


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
