package com.mong.mongo.controller;


import java.util.Optional;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mong.mongo.DAO.UserDAO;
import com.mong.mongo.model.User;

@RestController
@CrossOrigin
public class UserController {
	
	private final UserDAO userDAO;

	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@CrossOrigin(allowedHeaders="*")
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public Optional<User> getUser(@RequestBody User user) {
		Optional<User> res = userDAO.getUser(user);
		return res;
	}
	
	@CrossOrigin(allowedHeaders="*")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		return userDAO.addNewUser(user);
	}
	@CrossOrigin(allowedHeaders="*")
	@RequestMapping(value = "/fill", method = RequestMethod.POST)
	public String google(@RequestBody String adr, RestTemplate restTemplate) {
		return userDAO.google(adr, restTemplate);
	}
}