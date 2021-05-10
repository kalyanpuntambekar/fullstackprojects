package com.usps.usps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.usps.usps.exception.CustomeException;
import com.usps.usps.models.User;
import com.usps.usps.repositories.UserRepository;
import com.usps.usps.service.UserService;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
	RestTemplate restTemplate;

    private final UserRepository userRepository;

    private CustomeException CustomeException;
    
    private String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=";

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*@PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{Id}")
    public List<User> getUserById(@PathVariable String Id){
        return userRepository.findUsersByProp(Id);
    }*/

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{Id}")
    public List<User> getUserById(@PathVariable String Id){
        return userService.getUserById(Id.toLowerCase());
    }
    /*@GetMapping("/apikey")
    public ResponseEntity<String> getApiKey(){
        String key = userService.getKey();
        if(key==null||key.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(key, HttpStatus.OK);
        }
    }*/

//    @GetMapping("/address/{Id}")
//    public String getApiKey(){
//        String key = userService.getKey();
//        System.out.println(key);
//        if(key==null||key.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No key available");
//        }
//        return key;
//    }
    
    @GetMapping("/address/{searchText}")
	public String getAddress(@PathVariable String searchText) {
		
		return restTemplate.getForObject(url + searchText + "&key="+userService.getKey()+"&sessiontoken=1234567890", String.class);

	}
    
//    1600+Amphitheatre&key=<API_KEY>&sessiontoken=1234567890
    
//    @Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
