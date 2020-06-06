package kz.cf.spring5.lesson2;

import kz.cf.spring5.lesson2.config.NamedJdbcCfg;
import kz.cf.spring5.lesson2.dao.SingerDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by @Ruslan on 4/16/17.
 */
public class NamedJdbcCfgTest {

	@Test
	public void testCfg(){
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);

		SingerDao singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
		String singerName = singerDao.findNameById(1l);
		assertTrue("John Mayer".equals(singerName));

		ctx.close();
	}

}
