package kz.cf.spring.lesson4.services;

import kz.cf.spring.lesson4.entities.Singer;

public interface SingerService {
    Singer save(Singer singer);

    long count();

}
