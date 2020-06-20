package kz.cf.spring5.lesson_5;

import kz.cf.spring5.lesson4.config.DataJpaConfig;
import kz.cf.spring5.lesson_5.config.ServicesConfig;
import kz.cf.spring5.lesson_5.services.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TxProgrammaticDemo {

	public static void main(String... args) {
		GenericApplicationContext ctx =
				 new AnnotationConfigApplicationContext(ServicesConfig.class,
				DataJpaConfig.class);
		SingerService singerService = ctx.getBean(SingerService.class);
		System.out.println("Singer count: " + singerService.countAll());

		ctx.close();
	}
}
