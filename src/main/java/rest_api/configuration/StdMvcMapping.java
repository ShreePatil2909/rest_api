package rest_api.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "rest_api")
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class StdMvcMapping {

	@Autowired
	Environment environment;

	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getRequiredProperty("database.driver"));
		datasource.setUrl(environment.getRequiredProperty("database.url"));
		datasource.setUsername(environment.getRequiredProperty("database.user"));
		datasource.setPassword(environment.getRequiredProperty("database.password"));

		return datasource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "rest_api.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	private Properties hibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

		return properties;
	}
}
