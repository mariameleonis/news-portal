package com.epam.newsportal.config;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:persistence-oracle.properties")
@ComponentScan("com.epam.newsportal")
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class NewsPortalConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	  
	@Bean
	public DataSource myDataSource() {
		
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);	
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

	private Properties getHibernateProperties() {

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}

	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}


	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*").addResourceLocations("classpath:/static/")
        .resourceChain(true)
        .addResolver(new PathResourceResolver() {
        	@Override
        	protected Resource getResource(String resourcePath, Resource location) throws IOException {
        		Resource requestedResource = location.createRelative(resourcePath);
        		return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
        				: new ClassPathResource("/static/index.html");
        	}
        });         
    } 		
}
