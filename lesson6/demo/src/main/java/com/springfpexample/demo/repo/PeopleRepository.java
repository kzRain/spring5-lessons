package com.springfpexample.demo.repo;

import com.springfpexample.demo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PeopleRepository extends JpaRepository<People, Long> {

}
