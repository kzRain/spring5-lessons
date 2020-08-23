package kz.cf.spring.lesson12.repos;

import kz.cf.spring.lesson12.entities.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {

}
