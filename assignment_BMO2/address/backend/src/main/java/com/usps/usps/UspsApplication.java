package com.usps.usps;

import com.usps.usps.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class UspsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UspsApplication.class, args);
	}


}
