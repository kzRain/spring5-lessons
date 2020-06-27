package com.codeforce.product.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
/*Alimbetov Ruslan*/
@Entity
@Table(name = "state")
public class State {
    @Id
    @SequenceGenerator( name = "state_sequence", sequenceName = "state_sequence", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "state_sequence")
    private Long id;

    @NotNull(message = "state is requaired")
    @Size(min=1, max =100, message = "Size between 1 and 100 char")
    @Column(length = 100, nullable = false, unique = true)
    private String state;

    @Column(length = 250)
    @Size( max =250, message = "text max size 250 char")
    private String description;

    @OneToMany (mappedBy = "state")
    private Set<Pack> packs = new HashSet<>();

    public State() {
    }

    public State(String myState) {
        this.state=myState;
    }

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

    public Set<Pack> getPacks() {
        return packs;
    }

    public void setPacks(Set<Pack> packs) {
        this.packs = packs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
