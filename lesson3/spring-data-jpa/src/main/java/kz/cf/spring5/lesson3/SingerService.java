package kz.cf.spring5.lesson3;

import kz.cf.spring5.lesson3.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
