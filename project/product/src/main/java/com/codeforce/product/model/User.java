package com.codeforce.product.model;

import javax.persistence.*;

@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20, nullable = false, unique = true)
    private String login;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;


    public Role getRole(){
        return this.role;
    }

    public User() {
    }

    public User(Role role, Long id, String login) {
        this.role = role;
        this.id = id;
        this.login = login;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
