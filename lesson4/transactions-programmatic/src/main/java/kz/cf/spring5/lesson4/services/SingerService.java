package kz.cf.spring5.lesson4.services;

import kz.cf.spring5.lesson4.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    long countAll();
}
