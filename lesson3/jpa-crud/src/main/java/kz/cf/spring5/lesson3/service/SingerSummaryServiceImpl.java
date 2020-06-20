package kz.cf.spring5.lesson3.service;

import kz.cf.spring5.lesson3.view.SingerSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("singerSummaryService")
@Repository
@Transactional
public class SingerSummaryServiceImpl implements SingerSummaryService {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<SingerSummary> findAll() {
		List<SingerSummary> result = em.createQuery(
				"select new kz.cf.spring5.lesson4.view.SingerSummary("
						+ "s.firstName, s.lastName, a.title) from Singer s "
						+ "left join s.albums a "
						+ "where a.releaseDate=(select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)",
				SingerSummary.class).getResultList();
		return result;
	}
}
