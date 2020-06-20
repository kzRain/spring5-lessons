
package kz.cf.spring.lesson4.services;

import kz.cf.spring.lesson4.entities.Singer;
import kz.cf.spring.lesson4.repos.SingerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerRepository singerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return Lists.newArrayList(singerRepository.findAll());
	}

	/*
	 * API  changed in  2.0.0.M3 findOne became findById
     * @param id
     * @return
     */
	@Override
	@Transactional(readOnly = true)
	public Singer findById(Long id) {
		return singerRepository.findById(id).get();
	}

	@Override
	public Singer save(Singer singer) {
		return singerRepository.save(singer);
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public long countAll() {
		return singerRepository.countAllSingers();
	}
}

