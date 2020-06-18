package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LogsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "LOG_COLUMN")
    private String log;
}
