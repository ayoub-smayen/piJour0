package com.project0.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import com.project0.esprit.entity.Mail;
import com.project0.esprit.service.EmailSenderService;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@EnableScheduling
@SpringBootApplication
@ComponentScan({"com.project0.esprit.mycharts","com.project0.esprit.mycharts.service","com.project0.esprit.mycharts.Dao","com.project0.esprit.mycharts.Model","com.project0.esprit.mycharts.Controller","com.project0.esprit.mycharts.service.impl","com.project0.esprit.service","com.project0.esprit.resource","com.project0.esprit","com.project0.esprit.dao","com.project0.esprit.datentity","com.project0.esprit.utils","com.project0.esprit.security","com.project0.esprit.dao","com.project0.esprit.controller","com.project0.esprit.entity","com.project0.esprit.repository","com.project0.esprit.config"})
/*@EnableAutoConfiguration(exclude = { //  
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })*/
public class EspritApplication {
	
	/*@Autowired
    private Environment env;*/
	
	@Autowired
    private EmailSenderService emailService;
	
	private static Logger log = LoggerFactory.getLogger(SpringApplication.class); 
	
	

	public static void main(String[] args) {
		SpringApplication.run(EspritApplication.class, args);
	}
	/*@Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        // See: application.properties
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
 
        System.out.println("## getDataSource: " + dataSource);
 
        return dataSource;
    }
 
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
 
        // See: application.properties  
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
 
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
        // Package contain entity classes
        factoryBean.setPackagesToScan(new String[] { "" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }
 
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
	
	
	*/
	 @Bean
	    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	        return new BufferedImageHttpMessageConverter();
	    }
	
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("START... Sending email");

        Mail mail = new Mail();
        mail.setFrom("ayoubjobs.2019@email.com");//replace with your desired email
        mail.setMailTo("ayoubjobs.2019@email.com");//replace with your desired email
        mail.setSubject("Email with Spring boot and thymeleaf template!");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Developer!");
        model.put("location", "United States");
        model.put("sign", "Java Developer");
        mail.setProps(model);

        emailService.sendEmail(mail);
        log.info("END... Email sent success");
		
	}

}
