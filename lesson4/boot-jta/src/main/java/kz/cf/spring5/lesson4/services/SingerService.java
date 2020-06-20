package kz.cf.spring5.lesson4.services;

import kz.cf.spring5.lesson4.entities.Singer;

public interface SingerService {
    Singer save(Singer singer);

    long count();

}
