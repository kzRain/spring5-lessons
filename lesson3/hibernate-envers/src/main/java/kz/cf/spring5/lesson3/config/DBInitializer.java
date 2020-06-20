package kz.cf.spring5.lesson3.config;

import kz.cf.spring5.lesson3.repos.SingerAuditRepository;
import kz.cf.spring5.lesson3.entities.SingerAudit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created  on 4/23/17.
 */
//@Service
public class DBInitializer {
	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	//@Autowired
	SingerAuditRepository singerRepository;

	//@PostConstruct
	public void initDB(){
		logger.info("Starting database initialization...");

		SingerAudit singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1977, 9, 16)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("Eric");
		singer.setLastName("Clapton");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1945, 2, 30)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Butler");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1975, 3, 1)).getTime().getTime()));

		singerRepository.save(singer);
		logger.info("Database initialization finished.");
	}

}
