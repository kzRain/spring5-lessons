package kz.cf.spring5.lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Created by ruslan on 5/12/17.
 */
@SpringBootApplication(scanBasePackages = "kz.cf.spring5.lesson5")
public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		assert (ctx != null);
		logger.info("Application Started ...");

		System.in.read();
		ctx.close();
	}
}
