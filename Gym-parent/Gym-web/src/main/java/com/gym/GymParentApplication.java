package com.gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {("com.gym.*")})
@EntityScan(basePackages = {("com.gym.*")})
@EnableJpaRepositories(basePackages = {("com.gym.*")})
public class GymParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymParentApplication.class, args);
	}

}
