package kz.cf.spring.lesson3.services;

import kz.cf.spring.lesson3.entities.Album;
import kz.cf.spring.lesson3.entities.Singer;

import java.util.List;

/**
 * Created  on 5/7/17.
 */
public interface AlbumService {
	List<Album> findBySinger(Singer singer);

	List<Album> findByTitle(String title);
}
