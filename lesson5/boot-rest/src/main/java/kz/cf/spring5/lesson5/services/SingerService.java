package kz.cf.spring5.lesson5.services;

import kz.cf.spring5.lesson5.entities.Singer;

import java.util.List;

public interface SingerService {

	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);
}
