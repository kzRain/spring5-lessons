package kz.cf.spring5.lesson2;

import kz.cf.spring5.lesson2.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by @Ruslan on 3/19/17.
 */
@SpringBootApplication
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String... args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		assert (ctx != null);

		SingerDao singerDao = ctx.getBean(SingerDao.class);
		logger.info("All record count is " + singerDao.findAll().size());
		String singerName = singerDao.findNameById(5L);
		logger.info("Retrieved singer: " + singerName);

		System.in.read();
		ctx.close();
	}
}
