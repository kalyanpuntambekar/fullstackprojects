package com.mong.mongo.DAO;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import com.mong.mongo.model.User;
import com.mong.mongo.repos.UserRepository;
@Service
public class UserDAO {
	static final Logger log = LogManager.getLogger(UserDAO.class.getName());
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private UserRepository ur;
	
	public Optional<User> getUser(User user) {
		log.trace(user + " Logging get user in trace");
		ExampleMatcher x = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnorePaths("creationDate");
		Example<User> example = Example.of(user, x);
		Optional<User> res = ur.findOne(example);
		return res;
	}
	
	public User addNewUser(@RequestBody User user) {
		log.trace(user + " Logging add user in trace");
		String city = user.getAdr().split(",")[1];
		user.setCity(city);
		return mongoTemplate.save(user);
	}
	public String google(String adr, RestTemplate restTemplate) {
		String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input="+adr+"&key=AIzaSyDXdvm596A9ulV1XHf07NSfZ0t47fsIg4A";
		String res = restTemplate.getForObject(url, String.class);
		return res;
	}
}
