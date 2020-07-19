package kz.cb.spring.lesson7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Created by ruslan on 6/5/17.
 */
@Configuration
@ComponentScan(basePackages = "kz.cb.spring.lesson7")
public class AppConfig {

	@Bean LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}


