package com.codeforce.product.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/*Alimbetov Ruslan*/

@Entity
@Table(name = "container")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Country is requaired")
    @Size(min = 1, max = 100, message = "Size between 1 and 100 char")
    private String country;

    @NotNull(message = "city is requaired")
    @Size(min = 1, max = 100, message = "Size between 1 and 100 char")
    private String city;

    @NotNull(message = "adress is requaired")
    @Size(min = 10, max = 250, message = "Size between 10 and 100 char")
    @Column(length = 250, nullable = false)
    private String adress;

    @NotNull(message = "qnumber is requaired")
    @Size(min = 10, max = 100, message = "Size between 10 and 100 char")
    @Column(name = "qnumber", length = 100, nullable = false, unique = true)
    private String qnumber;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pack> packs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Point> points = new HashSet<>();

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

    public void addPack(Pack pack) {
        packs.add(pack);
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

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;

        Container container = (Container) o;

        if (id != container.id) return false;
        if (country != null ? !country.equals(container.country) : container.country != null) return false;
        if (city != null ? !city.equals(container.city) : container.city != null) return false;
        if (adress != null ? !adress.equals(container.adress) : container.adress != null) return false;
        return qnumber != null ? qnumber.equals(container.qnumber) : container.qnumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (qnumber != null ? qnumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", adress='" + adress + '\'' +
                ", qnumber='" + qnumber + '\'' +
                ", packs=" + packs +
                ", points=" + points +
                '}';
    }
}