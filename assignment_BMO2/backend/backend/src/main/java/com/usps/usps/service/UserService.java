package com.usps.usps.service;

import com.usps.usps.models.User;
import com.usps.usps.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUserById(String Id){
        return userRepository.findUsersByProp(Id);
    }

    public String getKey(){
        return apiKey;
    }
}
