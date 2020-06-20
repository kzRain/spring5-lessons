package kz.cf.spring5.lesson4.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

/**
 * Created  on 4/29/17.
 */
@Configuration
@EnableJpaRepositories
public class XAJpaConfig {

	private static Logger logger = LoggerFactory.getLogger(XAJpaConfig.class);

	@SuppressWarnings("unchecked")
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSourceA() {
		try {
			AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
			dataSource.setUniqueResourceName("XADBMSA");
			dataSource.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
			dataSource.setXaProperties(xaAProperties());
			dataSource.setPoolSize(1);
			return dataSource;
		} catch (Exception e) {
			logger.error("Populator DataSource bean cannot be created!", e);
			return null;
		}
	}

	@Bean
	public Properties xaAProperties() {
		Properties xaProp = new Properties();
		xaProp.put("databaseName", "anothertask");
		xaProp.put("user", "task");
		xaProp.put("password", "task");
		return xaProp;
	}

	@SuppressWarnings("unchecked")
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSourceB() {
		try {
			AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
			dataSource.setUniqueResourceName("XADBMSB");
			dataSource.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
			dataSource.setXaProperties(xaBProperties());
			dataSource.setPoolSize(1);
			return dataSource;
		} catch (Exception e) {
			logger.error("Populator DataSource bean cannot be created!", e);
			return null;
		}
	}

	@Bean
	public Properties xaBProperties() {
		Properties xaProp = new Properties();
		xaProp.put("databaseName", "task");
		xaProp.put("user", "task");
		xaProp.put("password", "task");
		return xaProp;
	}


	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
		hibernateProp.put(JTA_PLATFORM, "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
		// required by Hibernate 5
		hibernateProp.put(TRANSACTION_COORDINATOR_STRATEGY, "jta");
		hibernateProp.put(CURRENT_SESSION_CONTEXT_CLASS, "jta");

		hibernateProp.put(AUTOCOMMIT, false);
		hibernateProp.put(FLUSH_BEFORE_COMPLETION, false);
		hibernateProp.put(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		// this will work only if users/schemas are created first, use ddl.sql script for this
		hibernateProp.put(HBM2DDL_AUTO, "create-drop");
		hibernateProp.put(SHOW_SQL, true);
		hibernateProp.put(MAX_FETCH_DEPTH, 3);
		hibernateProp.put(STATEMENT_BATCH_SIZE, 10);
		hibernateProp.put(STATEMENT_FETCH_SIZE, 50);
		return hibernateProp;
	}


	@Bean
	public EntityManagerFactory emfA() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("kz.cf.spring5.lesson4.entities");
		factoryBean.setDataSource(dataSourceA());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setPersistenceUnitName("emfA");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}


	@Bean
	public EntityManagerFactory emfB() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("kz.cf.spring5.lesson4.entities");
		factoryBean.setDataSource(dataSourceB());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setPersistenceUnitName("emfB");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
}