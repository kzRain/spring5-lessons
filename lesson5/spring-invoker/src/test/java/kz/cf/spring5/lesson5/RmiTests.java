package kz.cf.spring5.lesson5;

import kz.cf.spring5.lesson5.config.RmiClientConfig;
import kz.cf.spring5.lesson5.entities.Singer;
import kz.cf.spring5.lesson5.services.SingerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by iuliana.cosmina on 6/5/17.
 */
@ContextConfiguration(classes = RmiClientConfig.class)
@RunWith(SpringRunner.class)
public class RmiTests {
	private Logger logger = LoggerFactory.getLogger(RmiTests.class);

	@Autowired
	private SingerService singerService;

	@Test
	public void testRmiAll() {
		List<Singer> singers = singerService.findAll();
		assertEquals(3, singers.size());
		listSingers(singers);
	}

	@Test
	public void testRmiJohn() {
		List<Singer> singers = singerService.findByFirstName("John");
		assertEquals(2, singers.size());
		listSingers(singers);
	}

	private void listSingers(List<Singer> singers){
		singers.forEach(s -> logger.info(s.toString()));
	}
}
