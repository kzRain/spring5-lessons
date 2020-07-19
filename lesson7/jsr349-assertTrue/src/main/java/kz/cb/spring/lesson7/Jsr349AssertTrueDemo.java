package kz.cb.spring.lesson7;

import kz.cb.spring.lesson7.config.AppConfig;
import kz.cb.spring.lesson7.obj.Genre;
import kz.cb.spring.lesson7.obj.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jsr349AssertTrueDemo {

	private static Logger logger = LoggerFactory.getLogger(Jsr349AssertTrueDemo.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		SingerValidationService singerValidationService =
				ctx.getBean("singerValidationService", SingerValidationService.class);

		Singer singer = new Singer();
		singer.setFirstName("Johnny");
		singer.setLastName("Mayer");
		singer.setGenre(Genre.COUNTRY);
		singer.setGender(null);

		validateSinger(singer, singerValidationService);

		ctx.close();
	}

	private static void validateSinger(Singer singer, SingerValidationService singerValidationService) {
		Set<ConstraintViolation<Singer>> violations = singerValidationService.validateSinger(singer);
		listViolations(violations);
	}

	private static void listViolations(Set<ConstraintViolation<Singer>> violations) {
		logger.info("No. of violations: " + violations.size());
		violations.forEach(v ->
				logger.info("Validation error for property: " + v.getPropertyPath()
						+ " with value: " + v.getInvalidValue()
						+ " with error message: " + v.getMessage()));
	}
}
