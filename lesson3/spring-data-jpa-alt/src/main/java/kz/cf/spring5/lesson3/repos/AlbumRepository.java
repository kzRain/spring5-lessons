package kz.cf.spring5.lesson3.repos;

import kz.cf.spring5.lesson3.entities.Album;
import kz.cf.spring5.lesson3.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created  on 5/7/17.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
	List<Album> findBySinger(Singer singer);

	@Query("select a from Album a where a.title like %:title%")
	List<Album> findByTitle(@Param("title") String title);
}
