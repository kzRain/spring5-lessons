package com.codeforce.product.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
public class LogsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "LOG_COLUMN")
    private String log;

    public LogsDB() {
    }

    public LogsDB(String log) {
        this.log = log;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "LogsDB{" +
                "id=" + id +
                ", log='" + log + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogsDB logsDB = (LogsDB) o;
        return Objects.equals(id, logsDB.id) &&
                Objects.equals(log, logsDB.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, log);
    }
}
