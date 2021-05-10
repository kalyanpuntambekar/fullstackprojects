package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GgController {
	private CustomerRepository customerRepository;
	
	public GgController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/add")
	public boolean add(@RequestBody JsonNode obj) {
		Customer c1 = new Customer(obj.get("fname").textValue(),obj.get("lname").textValue(),obj.get("address").textValue(),obj.get("ssn").textValue(),obj.get("number").textValue(),obj.get("email").textValue(),obj.get("dl").textValue());
		customerRepository.save(c1);
		return true;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/get")
	public ArrayList<Customer> get(@RequestBody JsonNode obj) {
		String fname = obj.get("fname").textValue();
		String lname = obj.get("lname").textValue();
		String email = obj.get("email").textValue();
		List<Customer> customers = customerRepository.findAll();
		ArrayList<Customer> a = new ArrayList<Customer>();
		for(Customer C : customers) {
			if(C.getFirstname().equals(fname) && C.getLastname().equals(lname) && C.getEmail().equals(email)) {
				a.add(new Customer(C.getFirstname(),C.getLastname(),C.getAddress(),C.getSsn(),C.getNumber(),C.getEmail(),C.getDl()));
			}
		}
		return a;
	}


}
