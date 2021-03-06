package kz.cf.spring5.lesson3.services;

import kz.cf.spring5.lesson3.repos.AlbumRepository;
import kz.cf.spring5.lesson3.entities.Album;
import kz.cf.spring5.lesson3.entities.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created  on 5/7/17.
 */
@Service("springJpaAlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumRepository albumRepository;

	@Transactional(readOnly=true)
	@Override public List<Album> findBySinger(Singer singer) {
		return albumRepository.findBySinger(singer);
	}

	@Override public List<Album> findByTitle(String title) {
		return albumRepository.findByTitle(title);
	}
}
