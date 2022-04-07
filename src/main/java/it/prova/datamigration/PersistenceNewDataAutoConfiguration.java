package it.prova.datamigration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * By default, the persistence-multiple-db.properties file is read for non auto
 * configuration in PersistenceUserConfiguration.
 * <p>
 * If we need to use persistence-multiple-db-boot.properties and auto
 * configuration then uncomment the below @Configuration class and comment out
 * PersistenceUserConfiguration.
 */
//@Configuration
@PropertySource({ "classpath:persistence-multiple-db-boot.properties" })
@EnableJpaRepositories(basePackages = "it.prova.datamigration.dto", entityManagerFactoryRef = "newEntityManager", transactionManagerRef = "newTransactionManager")
@Profile("!tc")
public class PersistenceNewDataAutoConfiguration {
	@Autowired
	private Environment env;

	public PersistenceNewDataAutoConfiguration() {
		super();
	}

	//

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean newEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(newDataSource());
		em.setPackagesToScan("it.prova.datamigration.dto");

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource newDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager newTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(newEntityManager().getObject());
		return transactionManager;
	}

}