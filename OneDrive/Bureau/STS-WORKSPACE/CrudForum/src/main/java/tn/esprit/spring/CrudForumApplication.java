package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing
public class CrudForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudForumApplication.class, args);
	}

}