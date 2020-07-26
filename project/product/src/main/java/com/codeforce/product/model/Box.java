package com.codeforce.product.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final Double height = 20.0;
    private final Double width = 30.0;
    private UUID uuid;
    private boolean isFree = true;
    @ManyToOne(cascade = CascadeType.ALL)
    private Point point;
    @OneToOne
    private Pack pack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;

        Box box = (Box) o;

        if (isFree != box.isFree) return false;
        if (id != null ? !id.equals(box.id) : box.id != null) return false;
        if (height != null ? !height.equals(box.height) : box.height != null) return false;
        if (width != null ? !width.equals(box.width) : box.width != null) return false;
        return uuid != null ? uuid.equals(box.uuid) : box.uuid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (isFree ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", isFree=" + isFree +
                ", point=" + point +
                ", pack=" + pack +
                '}';
    }
}
