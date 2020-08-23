package kz.cf.spring.lesson12.services;

import kz.cf.spring.lesson12.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
}
