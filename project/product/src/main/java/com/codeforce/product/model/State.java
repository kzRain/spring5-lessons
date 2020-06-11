package com.codeforce.product.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String state;

    @OneToMany
    private List<Pack> packs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }
}
