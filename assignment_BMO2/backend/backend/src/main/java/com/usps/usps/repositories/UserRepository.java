package com.usps.usps.repositories;

import com.usps.usps.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String>,UserCustomRepository {

    @Query("{ 'firstName' : ?0}")
    public List<User> findAllUsers(String var);
}
