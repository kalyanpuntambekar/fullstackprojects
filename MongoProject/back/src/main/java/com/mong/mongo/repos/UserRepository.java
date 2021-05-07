package com.mong.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mong.mongo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
