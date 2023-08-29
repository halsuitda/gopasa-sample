package com.start.catproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@PropertySource("classpath:/env.yml")
@SpringBootApplication
public class CatprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatprojectApplication.class, args);
	}

}
