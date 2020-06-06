package kz.cf.spring5.lesson2;

import kz.cf.spring5.lesson2.config.EmbeddedJdbcConfig;
import kz.cf.spring5.lesson2.config.PopulatorJdbcConfig;
import kz.cf.spring5.lesson2.dao.SingerDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by @Ruslan on 4/15/17.
 */
public class JdbcCfgTest {

	@Test
	public void testH2DB() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/embedded-h2-cfg.xml");
		ctx.refresh();
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testDerby() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/embedded-derby-cfg.xml");
		ctx.refresh();
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testEmbeddedJavaConfig() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	@Test
	public void testPopulatorJavaConfig() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(PopulatorJdbcConfig.class);
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	private void testDao(SingerDao singerDao) {
		assertNotNull(singerDao);
		String singerName = singerDao.findNameById(1l);
		System.out.println(singerName);
		assertTrue("John Mayer".equals(singerName));

	}
}
