package com.usps.usps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UspsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UspsApplication.class, args);
	}


}
