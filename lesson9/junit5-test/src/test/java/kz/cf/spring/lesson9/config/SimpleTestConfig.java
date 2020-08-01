package kz.cf.spring.lesson9.config;

import kz.cf.spring.lesson9.init.DBInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by ruslan beyganov on 6/25/17.
 */

@Configuration
@ComponentScan(basePackages={"kz.cf.spring.lesson9"},
		excludeFilters =  {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
				value = DBInitializer.class)
		})
@Profile("test")
public class SimpleTestConfig {

	private static Logger logger = LoggerFactory.getLogger(SimpleTestConfig.class);

	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
			return dbBuilder.setType(EmbeddedDatabaseType.H2).build();
		} catch (Exception e) {
			logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}

}
