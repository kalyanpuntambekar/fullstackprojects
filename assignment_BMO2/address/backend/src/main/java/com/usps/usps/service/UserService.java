package com.usps.usps.service;

import com.usps.usps.exception.CustomException;
import com.usps.usps.models.User;
import com.usps.usps.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${google.api.key}")
    private String apiKey;

    public ResponseEntity<Object> addUser(User user){
        try{
            userRepository.insert(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception mongoWriteException){
        	String error = mongoWriteException.getLocalizedMessage();
            String errorContent = error.substring(error.indexOf("index:")+7,error.indexOf("};")+1);
            throw new CustomException(errorContent,HttpStatus.BAD_REQUEST);
        }
    }

    public List<User> getUserById(String Id){
        return userRepository.findUsersByProp(Id);
    }

    public String getKey(){
        return apiKey;
    }
}
