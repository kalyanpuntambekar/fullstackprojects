package com.usps.usps.repositories;

import com.usps.usps.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    MongoTemplate mongoTemplate;

    @Autowired
    public UserCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> findUsersByProp(String pro) {
        Query query = new Query();
//     query.fields().include("id").include("name");
        final List<Criteria> criteria = new ArrayList<>();
        if(pro!=null && !pro.isEmpty()){
                criteria.add(Criteria.where("firstName").regex(pro,"i"));
                criteria.add(Criteria.where("lastName").regex(pro,"i"));
                criteria.add(Criteria.where("SSN").regex(pro,"i"));
                criteria.add(Criteria.where("email").regex(pro,"i"));
                criteria.add(Criteria.where("contact").regex(pro,"i"));
        }


        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()])));

        return mongoTemplate.find(query, User.class);
    }
}
