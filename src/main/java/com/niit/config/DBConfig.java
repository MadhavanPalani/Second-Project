package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*The central artifact in Spring's new Java-configuration support is the @Configuration -annotated class.
These classes consist principally of @Bean -annotated methods that define instantiation, configuration, 
and initialization logic for objects that are managed by the Spring IoC container.*/
/*
Using component scan is one method of asking Spring to detect Spring managed components. 
Spring needs the information to locate and register all the Spring components with the application context when the application starts.
Spring can auto scan, detect, and instantiate components from pre-defined project packages. 
Spring can auto scan all classes annotated with the stereotype annotations @Component, @Controller, @Service, and @Repository*/

/*The annotation @EnableTransactionManagement tells Spring that classes with the @Transactional annotation 
should be wrapped with the Transactional Aspect.
With this the @Transactional is now ready to be used.*/
@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class DBConfig 
{
	/*@Autowired. Marks a constructor, field, setter method or config method as to be autowired 
	by Spring's dependency injection facilities. Only one constructor (at max) of any given bean class may carry this annotation
	, indicating the constructor to autowire when used as a Spring bean.*/
	@Bean(name="sessionFactory")
	@Autowired
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource());
	      sessionFactory.setPackagesToScan("com.niit.model");
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 
	      return sessionFactory;
	   }
	 
	   private Properties hibernateProperties() 
	   {
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		
		return properties;
	}

	@Bean(name="dataSource")
	
	   public DataSource dataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	      dataSource.setUsername("hr");
	      dataSource.setPassword("oracle");
	 
	      return dataSource;
	   }
	 
	   @Bean(name="transactionManager")
	   @Autowired
	   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	   {
	
		   HibernateTransactionManager hibernateTransactionManager= new HibernateTransactionManager();
		   hibernateTransactionManager.setSessionFactory(sessionFactory);
 
		   return hibernateTransactionManager;
	   }
	   
	  
}



