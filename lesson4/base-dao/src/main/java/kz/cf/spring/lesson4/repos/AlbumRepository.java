package kz.cf.spring.lesson4.repos;

import kz.cf.spring.lesson4.entities.Album;
import kz.cf.spring.lesson4.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created  on 5/7/17.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
	List<Album> findBySinger(Singer singer);
}
