package kz.cf.spring.lesson12.services;

import java.util.List;

import kz.cf.spring.lesson12.entities.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    Page<Singer> findAllByPage(Pageable pageable);
}
