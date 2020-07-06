package com.codeforce.product.model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String num;
    private String address;
    private Integer boxNum;
    private Integer busy;
    private UUID token;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Box> boxes = new HashSet<>();
    @ManyToOne (cascade = CascadeType.ALL)
    private Container container;


    public Point() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getBusy() {
        return busy;
    }

    public void setBusy(Integer busy) {
        this.busy = busy;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Set<Box> boxes) {
        this.boxes = boxes;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", boxNum=" + boxNum +
                ", busy=" + busy +
                ", token=" + token +
                ", boxes=" + boxes +
                ", container=" + container +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (id != null ? !id.equals(point.id) : point.id != null) return false;
        if (num != null ? !num.equals(point.num) : point.num != null) return false;
        if (address != null ? !address.equals(point.address) : point.address != null) return false;
        if (boxNum != null ? !boxNum.equals(point.boxNum) : point.boxNum != null) return false;
        if (busy != null ? !busy.equals(point.busy) : point.busy != null) return false;
        return token != null ? token.equals(point.token) : point.token == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (boxNum != null ? boxNum.hashCode() : 0);
        result = 31 * result + (busy != null ? busy.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
