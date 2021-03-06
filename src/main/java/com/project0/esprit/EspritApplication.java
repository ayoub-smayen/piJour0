package com.project0.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import java.awt.image.BufferedImage;
import java.util.GregorianCalendar;
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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import com.google.maps.model.LatLng;
import com.project0.esprit.entity.Dice;
import com.project0.esprit.entity.Mail;
import com.project0.esprit.entity.Rollable;
import com.project0.esprit.entity.Shop;
import com.project0.esprit.repository.MemoryStore;
import com.project0.esprit.repository.Store;
import com.project0.esprit.service.EmailSenderService;
import com.project0.esprit.service.GeocodeService;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@EnableScheduling
@EnableAsync
@SpringBootApplication

@EnableJpaRepositories
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"com.project0.esprit.aspect","com.project0.esprit.mycharts","com.project0.esprit.mycharts.service","com.project0.esprit.mycharts.Dao","com.project0.esprit.mycharts.Model","com.project0.esprit.mycharts.Controller","com.project0.esprit.mycharts.service.impl","com.project0.esprit.service","com.project0.esprit.resource","com.project0.esprit","com.project0.esprit.dao","com.project0.esprit.datentity","com.project0.esprit.utils","com.project0.esprit.security","com.project0.esprit.dao","com.project0.esprit.controller","com.project0.esprit.entity","com.project0.esprit.repository","com.project0.esprit.config"})
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
	
	@Bean
	//@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	 @Scheduled(fixedRate = 5000)
	 public void printDate() {
		 System.out.println("Rc service tieme " + new GregorianCalendar().getTime());
		 
	 }
	
	
	
	@Bean(name = "geocodeService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties(prefix = "config")
	public GeocodeService getGeocodeService() {
		GeocodeService service = new GeocodeService();
		return service;
	}

	@Bean(name = "memoryStore")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Store<Shop, LatLng> getMemoryStore() {
		return new MemoryStore();
	}
	
	 @Bean(name = "greenDice")
	    public Rollable greenDice() {
	        return new Dice(new Integer[]{1, 2, 3, 4, 5,6});
	    }

	    @Bean(name = "yellowDice")
	    public Rollable yellowDice() {
	        return new Dice(new Integer[]{0, 0, 1, 1, 1, 2});
	    }

	    @Bean(name = "brownDice")
	    public Rollable brownDice() {
	        return new Dice(new Integer[]{0, 1, 1, 2, 4, 5});
	    }

	    @Bean(name = "blueDice")
	    public Rollable blueDice() {
	        return new Dice(new Integer[]{0, 1, 1, 2, 3, 4});
	    }

	    @Bean(name = "greyDice")
	    public Rollable greyDice() {
	        return new Dice(new Integer[]{0, 0, 1, 1, 2, 3});
	    }

	    @Bean(name = "redDice")
	    public Rollable redDice() {
	        return new Dice(new Integer[]{0, 1, 1, 2, 2, 3});
	    }

	    @Bean(name = "blackDice")
	    public Rollable blackDice() {
	        return new Dice(new Integer[]{0, 0, 2, 2, 2, 3});
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
