package com.mong.mongo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mong.mongo.model.User;
@Service
public class UserService implements UserDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public User getUser(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("ssn").is(user.getSsn()));
		User res = mongoTemplate.findOne(query, User.class);
		return res;
	}
	@Override
	public User addNewUser(@RequestBody User user) {
		return mongoTemplate.save(user);
	}
}
