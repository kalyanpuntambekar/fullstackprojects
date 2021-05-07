package com.mong.mongo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mongo.DAO.UserDAO;
import com.mong.mongo.model.User;

@RestController
@CrossOrigin
public class UserController {
	
	private final UserDAO userDAO;

	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@CrossOrigin(allowedHeaders="*")
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {
		User res = userDAO.getUser(user);
		return res;
	}
	
	@CrossOrigin(allowedHeaders="*")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		return userDAO.addNewUser(user);
	}
	
}