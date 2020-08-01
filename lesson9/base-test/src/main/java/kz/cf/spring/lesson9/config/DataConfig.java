package kz.cf.spring.lesson9.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by iuliana.cosmina on 6/25/17.
 */
@Profile("dev")
@Configuration
@ComponentScan(basePackages  = {"kz.cf.spring.lesson9.init"} )
public class DataConfig {

	private static Logger logger = LoggerFactory.getLogger(DataConfig.class);

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


	/**
	 * Create a data source with connection pool for PostgreSQL connections
	 * @param url the JDBC URL to connect to. Must start with "jdbc:postgresql:"
	 * @param user the username for the connection
	 * @param password the password for the connection
	 * @return a data source with the correct properties set
	 */
//	private static javax.sql.DataSource createDataSource(String url, String user, String password)
//	{
//		/* use a data source with connection pooling */
//		org.postgresql.ds.PGPoolingDataSource ds = new org.postgresql.ds.PGPoolingDataSource();
//		ds.setUrl(url);
//		ds.setUser(user);
//		ds.setPassword(password);
//		/* the connection pool will have 10 to 20 connections */
//		ds.setInitialConnections(10);
//		ds.setMaxConnections(20);
//		/* use SSL connections without checking server certificate */
//		ds.setSslMode("require");
//		ds.setSslfactory("org.postgresql.ssl.NonValidatingFactory");
//
//		return ds;
//	}

}
