package com.mong.mongo.DAO;

import com.mong.mongo.model.User;

public interface UserDAO {
	
	User getUser(User user);

	User addNewUser(User user);
}
